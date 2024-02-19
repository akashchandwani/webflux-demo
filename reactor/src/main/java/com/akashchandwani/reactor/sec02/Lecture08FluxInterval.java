package com.akashchandwani.reactor.sec02;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Flux.interval will publish items periodically.
 * This can be used when items need to be periodically be sent to the client like stock data
 */
public class Lecture08FluxInterval {
    public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sleepSeconds(5);
    }
}
