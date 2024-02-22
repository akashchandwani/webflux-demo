package com.akashchandwani.reactor.sec03;

import com.akashchandwani.reactor.utils.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lecture03FluxTake {

    public static void main(String[] args){
        Flux.range(0, 10)
                .log()
                .take(3) // Upstream subscription is cancelled after 3rd
                .log()
                .subscribe(DefaultSubscriber.subscriber("sub-1"));
    }

}
