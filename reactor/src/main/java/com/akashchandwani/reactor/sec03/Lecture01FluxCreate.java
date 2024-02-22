package com.akashchandwani.reactor.sec03;

import com.akashchandwani.reactor.utils.DefaultSubscriber;
import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

/**
 * 1. Example to show how to emit items using flux.create(flux sink)
 * 2. Generate 10 countries
 * 3. Simulate the generation of countries till you get Canada
 */
public class Lecture01FluxCreate {
    public static void main(String[] args) {
        // 1. Example to show how to emit items using flux.create(flux sink)
//                Flux.create(fluxSink -> {
//                    fluxSink.next(1);
//                    fluxSink.next(2);
//                    fluxSink.next(3);
//                    fluxSink.complete();
//
//                }).subscribe(DefaultSubscriber.subscriber("sub1"));

//        Flux.create(fluxSink -> {
//            for(int i = 0; i < 10; i++) {
//                fluxSink.next(Util.faker().country().name());
//            }
//            fluxSink.complete();
//        }).subscribe(DefaultSubscriber.subscriber("countryNamesSub : "));

        Flux.create(fluxSink -> {
            String countryName;
            do {
                countryName = Util.faker().country().name();
                fluxSink.next(countryName);
            } while (!countryName.equalsIgnoreCase("canada"));
        }).subscribe(DefaultSubscriber.subscriber("countries"));

    }
}
