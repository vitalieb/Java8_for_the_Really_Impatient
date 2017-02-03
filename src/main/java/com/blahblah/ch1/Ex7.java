package com.blahblah.ch1;

import static java.lang.System.*;

public class Ex7 {

    public static Runnable andThen(Runnable r1,Runnable r2){
        Runnable runner = () -> {
            r1.run();
            r2.run();
        };

        return runner;
    }

    public static void main(String[] args) {
        new Thread(andThen(()-> out.println("1st runner"),()-> out.println("2nd runner"))).start();
    }
}
