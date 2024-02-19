package com.akashchandwani.reactor.sec02;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

/**
 * Range will emit `count` number of items starting from `start`
 * log will log what's happening in between publishers
 */
public class Lecture05FluxRange {

    public static void main(String[] args){

        Flux.range(3, 10)
                .subscribe(Util.onNext());

        Flux.range(1, 10)
                .log()
                .map(i -> Util.faker().name().fullName())
                .log()
                .subscribe(Util.onNext());
    }
}
