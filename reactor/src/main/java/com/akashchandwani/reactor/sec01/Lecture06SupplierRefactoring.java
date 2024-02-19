package com.akashchandwani.reactor.sec01;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Building Mono pipeline is easy and takes less time than executing it.
 * You can make things async by using `.subscribeOn(Schedulers.boundedElastic())`
 */
public class Lecture06SupplierRefactoring {

    public static void main(String[] args){
        getName();
        String name = getName()
                .subscribeOn(Schedulers.boundedElastic()) // async
                .block(); // blocking the thread. comment it to make is non blocking. This is not a reactive way to doing things.
        System.out.println(name);
        getName();
        Util.sleepSeconds(4);
    }

    private static Mono<String> getName() {
        System.out.println("entered getName method");
        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }
}
