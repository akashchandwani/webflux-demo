package com.akashchandwani.reactor.sec02;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lecture04FluxFromStream {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4);
        // As streams cannot be reused after a terminal operation is applied, similarly a stream cannot be used with flux twice.
        // Only if you create a stream as part of supplier, it can be reused.

        Flux<Integer> integerFlux = Flux.fromStream(() ->list.stream());

        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
        integerFlux.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

    }
}
