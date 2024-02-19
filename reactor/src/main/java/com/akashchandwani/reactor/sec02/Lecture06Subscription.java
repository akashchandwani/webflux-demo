package com.akashchandwani.reactor.sec02;

import com.akashchandwani.reactor.utils.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Creating a custom subscription with `subscribeWith`.
 * Also using AtomicReference to hold the subscription object and then requesting number of items with request(itemCount).
 * Once the subscription is cancelled, it can no longer request for the items.
 */
public class Lecture06Subscription {
    public static void main(String[] args){
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Flux.range(1,20)
                .log()
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub: " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext : " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.err.println("onNext : " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");

                    }
                });
        Util.sleepSeconds(3);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        atomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("going to cancel");
        atomicReference.get().cancel();
        Util.sleepSeconds(3);
        atomicReference.get().request(4);
        Util.sleepSeconds(3);

    }
}
