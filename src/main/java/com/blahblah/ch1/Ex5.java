package com.blahblah.ch1;

import javax.swing.*;

public class Ex5 {

    public static void main(String[] args) {
        //with anonymous class
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //some code
            }
        });

        //same code with lambdas
        SwingUtilities.invokeLater(() -> {
            //some code
        });
    }
}
