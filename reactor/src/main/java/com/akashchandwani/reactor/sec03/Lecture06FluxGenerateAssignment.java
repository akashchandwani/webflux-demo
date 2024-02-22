package com.akashchandwani.reactor.sec03;

import com.akashchandwani.reactor.utils.DefaultSubscriber;
import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

/**
 * Assignment: Keep on emitting countries till canada comes
 */
public class Lecture06FluxGenerateAssignment {
    public static void main(String[] args){
        Flux.generate(synchronousSink -> {
            String countryName = Util.faker().country().name();
            synchronousSink.next(countryName);
            if (countryName.equalsIgnoreCase("canada")) {
                synchronousSink.complete();
            }
        }).subscribe(DefaultSubscriber.subscriber("country names"));
    }
}
