package com.akashchandwani.reactor.sec02;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

/**
 * To convert a flux to a mono, you need to use next().
 * If you want to filter and get only a specific item, use filter.
 */
public class Lecture10FluxToMono {
    public static void main(String[] args){
        Flux<Integer> flux = Flux.range(1, 10);
        flux.filter(i -> i > 3).next().subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }
}
