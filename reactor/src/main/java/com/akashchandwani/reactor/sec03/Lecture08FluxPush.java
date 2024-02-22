package com.akashchandwani.reactor.sec03;

import com.akashchandwani.reactor.sec03.helper.NameProducer;
import com.akashchandwani.reactor.utils.DefaultSubscriber;
import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

/**
 * Flux.push is not thread safe
 */
public class Lecture08FluxPush {
    public static void main(String[] args){
        NameProducer nameProducer = new NameProducer();
        Flux.push(nameProducer)
                .subscribe(DefaultSubscriber.subscriber("subscriber"));

        Runnable runnable = nameProducer::produce;

        for(int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);
    }
}
