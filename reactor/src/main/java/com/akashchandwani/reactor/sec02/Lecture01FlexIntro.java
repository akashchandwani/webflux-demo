package com.akashchandwani.reactor.sec02;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

/**
 * Easiest way to create a flux when you have data already is by using Just method.
 * the onNext() method will emit data one at a time to the subscriber
 */
public class Lecture01FlexIntro {

    public static void main(String[] args){
        Flux<Object> flux = Flux.just(1, 2, 3, "Hello", "World", Util.faker().name().firstName());

//        Flux<Integer> flux = Flux.empty();
        flux.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
