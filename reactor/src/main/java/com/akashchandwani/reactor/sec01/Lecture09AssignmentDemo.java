package com.akashchandwani.reactor.sec01;

import com.akashchandwani.reactor.sec01.assignment.FileService;
import com.akashchandwani.reactor.utils.Util;

public class Lecture09AssignmentDemo {

    public static void main(String[] args){
        FileService.read("file03.txt").subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.write("file03.txt", "This is file3").subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        FileService.delete("file03.txt").subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
