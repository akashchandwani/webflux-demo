package com.akashchandwani.reactor.sec03;

import com.akashchandwani.reactor.sec03.assignment.FileService;
import com.akashchandwani.reactor.utils.DefaultSubscriber;
import com.akashchandwani.reactor.utils.Util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Lecture10AssignmentInCourse {


    public static void main(String[] args){

        FileService fileService = new FileService();
        Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
        fileService.read(path)
                .map(s -> {
                    Integer integer = Util.faker().random().nextInt(0, 15);
                    if (integer >  13) {
                        throw new RuntimeException("Oops");
                    }
                    return s;
                })
                .take(10)
                .subscribe(DefaultSubscriber.subscriber("ds-2"))
        ;
    }
}
