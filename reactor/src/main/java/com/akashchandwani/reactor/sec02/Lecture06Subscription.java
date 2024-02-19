package com.akashchandwani.reactor.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lecture06Subscription {
    public static void main(String[] args){
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1,20)
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        
                    }

                    @Override
                    public void onNext(Integer integer) {

                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {

                    }
                })
    }
}
