package com.akashchandwani.reactor.sec02;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class demonstrates how you can convert a Mono to a Flux. This can be useful when you have to convert a Mono to
 * Flux for passing it to a function etc.
 */
public class Lecture09FluxFromMono {
    public static void main(String[] args){
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
        flux.subscribe(Util.onNext());
    }

    private static void doSomeThing(Flux<String> flux) {
        // todo
    }

}
