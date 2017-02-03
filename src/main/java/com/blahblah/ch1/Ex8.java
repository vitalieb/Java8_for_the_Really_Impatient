package com.blahblah.ch1;

import java.util.ArrayList;
import java.util.List;

public class Ex8 {

    public static void main(String[] args) {

        //1st approach
        String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<>();
        for (String name : names) //name is effectively final
            runners.add(() -> System.out.println(name));
        for (Runnable runner : runners)
            new Thread(runner).start(); // prints all 3 names

        //2nd approach
        List<Runnable> runnersForI = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            int finalI = i; // you have to copy i to a final or effectively final variable
            runnersForI.add(() -> System.out.println(names[finalI]));
        }
        for (Runnable runner : runnersForI)
            new Thread(runner).start(); // prints all 3 names


    }
}
