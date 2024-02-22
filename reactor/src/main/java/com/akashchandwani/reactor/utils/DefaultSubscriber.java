package com.akashchandwani.reactor.utils;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber implements Subscriber<Object> {

    private String name = "";

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    public DefaultSubscriber() {
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);
    }

    @Override
    public void onNext(Object o) {
        System.out.println(name + " - Received : " + o);

    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println(name + " - " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println(name + " - Completed");
    }

    public static Subscriber<Object> subscriber() {
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name) {
        return new DefaultSubscriber(name);
    }
}
