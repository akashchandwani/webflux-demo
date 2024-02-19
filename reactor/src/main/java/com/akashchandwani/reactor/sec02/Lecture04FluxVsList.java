package com.akashchandwani.reactor.sec02;

import com.akashchandwani.reactor.sec02.helper.NameGenerator;
import com.akashchandwani.reactor.utils.Util;

/**
 * When you use flux, you don't have to wait for all items to begin processing. As and when an item is available, it can be used.
 * List is a data structure but flux is not.
 */
public class Lecture04FluxVsList {
    public static void main(String[] args) {

        NameGenerator.getNames(5)
                .subscribe(Util.onNext());
    }
}
