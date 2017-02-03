package com.blahblah.ch1;

import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class Ex2 {

    public static void main(String[] args) {
        Ex2 e = new Ex2();
        for (File file : e.listDirectories()) {
            System.out.println(file.getName());
        }
    }

    public File[] listDirectories() {
        File f = new File(Paths.get(".").toAbsolutePath().normalize().toString());
        return f.listFiles(File::isDirectory);
    }

    @Test
    public void test() {
        Ex2 ex = new Ex2();
        String[] directoryNames = Arrays.stream(ex.listDirectories()).map(File::getName).toArray(String[]::new);
        assertThat(Arrays.asList(directoryNames), hasItem("src"));
        assertThat(Arrays.asList(directoryNames), not(hasItem("pom.xml")));
    }

}
