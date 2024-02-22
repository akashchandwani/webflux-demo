package com.akashchandwani.reactor.sec03.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class FileService {

    private static final Path PATH = Paths.get("src/main/resources/assignment/sec03");

    private Callable<BufferedReader> openReader (Path path) {
        System.out.println("---opened");
        return () -> Files.newBufferedReader(path);
    }

    private BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read() {
        return (br, sink) -> {
            try {
                String line = br.readLine();
                System.out.println("---line: " + line);
                if (Objects.isNull(line)){
                    sink.complete();
                } else {
                    sink.next(line);
                }
            } catch (IOException e) {
                sink.error(e);
            }
            return br;
        };
    }

    private Consumer<BufferedReader> closeReader() {
        return br -> {
            try {
                System.out.println("---closed");
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public Flux<String> read(Path path) {
        return Flux.generate(
                openReader(path),
                read(),
                closeReader()
        );

    }
}
