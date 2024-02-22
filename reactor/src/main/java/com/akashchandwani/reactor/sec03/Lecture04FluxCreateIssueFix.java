package com.akashchandwani.reactor.sec03;

import com.akashchandwani.reactor.utils.DefaultSubscriber;
import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

public class Lecture04FluxCreateIssueFix {

    public static void main(String[] args){

        // Only one instance of flux sink is available for anyone to use
        Flux.create(fluxSink -> {
            String countryName;
            do {
                countryName = Util.faker().country().name();
                System.out.println("Emitting country: " + countryName);
                fluxSink.next(countryName);
            } while (!countryName.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
        })
        .take(3)
        .subscribe(DefaultSubscriber.subscriber("countries"));
    }
}
