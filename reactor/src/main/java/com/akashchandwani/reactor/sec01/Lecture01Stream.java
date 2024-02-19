package com.akashchandwani.reactor.sec01;

import java.util.stream.Stream;
/**
 * A class to demonstrate the working of Java stream. A Java stream is quite similar to a Publisher (flux / mono).
 * Java streams are lazy. If you don't connect a terminal operator to stream, it will not do anything.
 * A terminal operator which will execute the stream.
 * This example shows the blocking behavior of a stream
 */
public class Lecture01Stream {
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1).map(i -> {
            try {
                // Blocks stream for 5 second
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return i * 2;
        });

        stream.forEach(System.out::println);
    }
}
