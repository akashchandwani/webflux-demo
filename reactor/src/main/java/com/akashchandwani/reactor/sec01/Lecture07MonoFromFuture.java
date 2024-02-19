package com.akashchandwani.reactor.sec01;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

/**
 * Completable futures are equivalent of Promises in Javascript
 */
public class Lecture07MonoFromFuture {
    public static void main(String[] args){
        Mono.fromFuture(getName()).subscribe(Util.onNext());
        Util.sleepSeconds(1); // Blocking thread to see the result
    }

    /**
     * This method will get executed as part of asychronous Fork join pool
     * @return
     */
    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.faker().name().fullName());
    }
}
