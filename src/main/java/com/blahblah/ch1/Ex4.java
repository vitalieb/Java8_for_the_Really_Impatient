package com.blahblah.ch1;

import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Ex4 {

    public static void main(String[] args) {

        Ex4 ex = new Ex4();
        for (File file : ex.listDirectoriesAndFiles()) {
            System.out.println(file.getName() + " : isDirectory = " + file.isDirectory());
        }

    }

    public File[] listDirectoriesAndFiles() {
        String currentDirecotry = Paths.get(".").toAbsolutePath().normalize().toString();
        File f = new File(currentDirecotry);
        return Arrays.stream(f.listFiles()).sorted((f1, f2) -> f1.getAbsolutePath().compareTo(f2.getAbsolutePath())).sorted((f1, f2) -> {
            if (f1.isDirectory() && f2.isDirectory()) {
                return 0;
            } else if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else {
                return 1;
            }
        }).toArray(File[]::new);
    }

    @Test
    public void test() {
        Ex4 ex = new Ex4();
        String[] fileNames = Arrays.stream(ex.listDirectoriesAndFiles()).map(File::getName).toArray(String[]::new);
        assertThat(fileNames[fileNames.length - 1], equalTo("pom.xml"));
    }

}
