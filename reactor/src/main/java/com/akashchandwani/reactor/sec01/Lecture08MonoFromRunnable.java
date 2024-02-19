package com.akashchandwani.reactor.sec01;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Mono;

public class Lecture08MonoFromRunnable {
    public static void main(String[] args){

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(), Util.onError(),
                        () -> System.out.println("process is done"));
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }
}
