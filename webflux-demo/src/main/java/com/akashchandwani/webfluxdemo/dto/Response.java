package com.akashchandwani.webfluxdemo.dto;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Response {
    private final Date date = new Date();
    private int output;

    public Response(int output) {
        this.output = output;
    }
}
