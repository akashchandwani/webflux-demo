package com.akashchandwani.reactor.sec02;

import reactor.core.publisher.Flux;

/**
 * multiple subscriber can subscribe to the same flux
 */
public class Lecture02MultipleSubscribers {
    public static void main(String[] args){
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);

        Flux<Integer> evenFlux = flux.filter(i -> i % 2 == 0);

        flux.subscribe(i -> System.out.println("Sub 1: " + i));

        evenFlux.subscribe(i -> System.out.println("Sub 2: " + i));
    }
}
