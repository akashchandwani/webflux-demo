package com.akashchandwani.reactor.sec03;

import com.akashchandwani.reactor.utils.DefaultSubscriber;
import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

/**
 * Use flux generate to generate countries util -
 * 1. canada comes
 * 2.
 */
public class Lecture07FluxGenerateWithState {

    public static void main(String[] args){
        Flux.generate(
                () -> 1, // Initial state will be invoked only once
                (counter, sink) -> {
                    String countryName = Util.faker().country().name();
                    sink.next(countryName);
                    if (counter >= 10 || countryName.equalsIgnoreCase("canada")) {
                        sink.complete();
                    }
                    return counter + 1;
                })
                .subscribe(DefaultSubscriber.subscriber("test"));
    }
}
