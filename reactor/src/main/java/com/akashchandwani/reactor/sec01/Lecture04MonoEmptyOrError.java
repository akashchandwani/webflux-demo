package com.akashchandwani.reactor.sec01;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Mono;

public class Lecture04MonoEmptyOrError {
    public static void main(String[] args){
        userRepository(2)
                .subscribe(
                        Util.onNext(),
                        Util.onError(),
                        Util.onComplete());
    }

    private static Mono<String> userRepository(int userId) {
        // 1
        if (userId == 1) {
            return Mono.just(Util.faker().name().firstName());
        } else if (userId==2) {
            return Mono.empty();
        }
        return Mono.error(new RuntimeException("Not in allowed range"));
    }
}
