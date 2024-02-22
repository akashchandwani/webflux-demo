package com.akashchandwani.reactor.sec03;

import com.akashchandwani.reactor.utils.DefaultSubscriber;
import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

public class Lecture05FluxGenerate {


    // With Synchronous sink you can just emit one item.
    // The looping is taken care by the generate method
    public static void main(String[] args){
        Flux.generate(
                synchronousSink -> {
                    System.out.println("emitting");
                    synchronousSink.next(Util.faker().cat().name()); // 1
                    synchronousSink.error(new RuntimeException("RunTimeException"));
//                    synchronousSink.complete();
                }
        )
        .take(2)
        .subscribe(DefaultSubscriber.subscriber("sub-1"));
    }
}
