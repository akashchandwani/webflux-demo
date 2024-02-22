package com.akashchandwani.reactor.sec03;

import com.akashchandwani.reactor.utils.DefaultSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.Consumer;

public class Lecture10Assignment {
    private static final Path PATH = Paths.get("src/main/resources/assignment/sec03");
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream inputStream = new FileInputStream(PATH + "/file01.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

        Flux.generate(getSynchronousSinkConsumer(br))
        .subscribe(DefaultSubscriber.subscriber("ds-1"));
    }

    private static Consumer<SynchronousSink<Object>> getSynchronousSinkConsumer(BufferedReader br) {
        return synchronousSink -> {
            try {
                String line = br.readLine();
                if ( Objects.isNull(line)) {
                    synchronousSink.complete();
                } else {
                    synchronousSink.next(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
