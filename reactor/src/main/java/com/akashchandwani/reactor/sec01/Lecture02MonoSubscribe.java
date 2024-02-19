package com.akashchandwani.reactor.sec01;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Mono;

/**
 * Introduction to Mono. Mono is an implementation of Publisher
 * Easiest way to create a Mono is via a `just` method.
 * Nothing happens unless you subscribe to a publisher
 */
public class Lecture02MonoSubscribe {

    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l/0);

        mono.subscribe(
                Util.onNext(), // onNext Consumer
                Util.onError(), // onError Consumer
                Util.onComplete() // onComplete Consumer
        );

    }
}
