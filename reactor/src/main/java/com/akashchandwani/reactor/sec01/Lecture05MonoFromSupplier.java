package com.akashchandwani.reactor.sec01;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 * Creating mono from a supplier or from a callable
 * fromSubscriber is preferred when accessing any mono as things should be lazy
 */
public class Lecture05MonoFromSupplier {
    public static void main(String[] args){
//        Use just only when you have data available
//        Mono<String> name = Mono.just(getName());
        Supplier<String> stringSupplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(Util.onNext());

        Callable<String> stringCallable = () -> getName();
        Mono.fromCallable(stringCallable)
                .subscribe(Util.onNext());
    }

    private static String getName() {
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }
}
