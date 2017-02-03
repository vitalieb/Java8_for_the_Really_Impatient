package com.blahblah.ch1;

public class Ex6 {


    public static void main(String[] args) {
        new Thread(uncheck(
                () -> {
                    System.out.println("Zzz");
                    Thread.sleep(1000);
                })).start();
    }

    private static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        };
    }
}

@FunctionalInterface
interface RunnableEx {

    void run() throws Exception;

}