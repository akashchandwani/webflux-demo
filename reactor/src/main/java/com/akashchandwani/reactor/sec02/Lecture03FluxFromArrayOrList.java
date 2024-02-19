package com.akashchandwani.reactor.sec02;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

/**
 * If you already have data in an Array or List, you can use the Flux.fromIterable, or Flux.fromArray method to get a flux out of it.
 */
public class Lecture03FluxFromArrayOrList {

    public static void main(String[] args){

        // Items already in list
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

        // Similar to just.
        Flux.fromIterable(list)
                .subscribe(Util.onNext());

        Integer[] arr = {1, 2, 3, 4};
        Flux.fromArray(arr).subscribe(Util.onNext());
    }
}
