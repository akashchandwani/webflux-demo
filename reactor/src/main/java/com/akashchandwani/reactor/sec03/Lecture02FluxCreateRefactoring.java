package com.akashchandwani.reactor.sec03;

import com.akashchandwani.reactor.sec03.helper.NameProducer;
import com.akashchandwani.reactor.utils.DefaultSubscriber;
import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

/**
 * 1. Demonstration of externalizing the fluxSink and producing items after it has been subscribed earlier.
 * 2. You can emit items from multiple threads using flux sink
 */
public class Lecture02FluxCreateRefactoring {

    public static void main(String[] args){
        NameProducer nameProducer = new NameProducer();
        Flux.create(nameProducer)
                .subscribe(DefaultSubscriber.subscriber("subscriber"));

        Runnable runnable = nameProducer::produce;

        for(int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}
