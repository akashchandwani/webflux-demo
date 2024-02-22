package com.akashchandwani.reactor.sec03.helper;

import com.akashchandwani.reactor.utils.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        String name = Util.faker().name().fullName();
        String threadName = Thread.currentThread().getName();
        this.fluxSink.next(threadName + " : "+ name);
    }



}
