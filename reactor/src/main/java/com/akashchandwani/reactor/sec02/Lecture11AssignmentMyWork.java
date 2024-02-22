package com.akashchandwani.reactor.sec02;

import com.akashchandwani.reactor.utils.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Assignment to generate numbers starting from 100 which will add a random number between -5 to 5 to the number until it
 * becomes out of range [90,100]
 */
public class Lecture11AssignmentMyWork {
    public static void main(String[] args){
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Subscriber<Long> subscriber = Flux.interval(Duration.ofSeconds(1))
                .subscribeWith(new Subscriber<Long>() {
                    long value = 100L;

                    private final Random random = new Random();

                   @Override
                   public void onSubscribe(Subscription subscription) {
                       atomicReference.set(subscription);
                   }

                   @Override
                   public void onNext(Long aLong) {
                       if (value > 110 || value < 90){
                           atomicReference.get().cancel();
                       } else {
                           System.out.println("Received: " + value);
                           value += random.nextLong(-5, 5);
                       }
                   }

                   @Override
                   public void onError(Throwable throwable) {
                       System.err.println("Error: " + throwable.getMessage());

                   }

                   @Override
                   public void onComplete() {
                       System.out.println("Process completed");
                   }
               }
        );
        atomicReference.get().request(100);
        Util.sleepSeconds(100);
    }
}
