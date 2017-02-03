package com.blahblah.ch1;

import org.junit.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class Ex3 {

    public File[] getFileWithExtension(String directory, String extension) {
        File file = new File(directory);
        return Arrays.stream(file.listFiles()).filter(f -> f.getName().endsWith(extension)).toArray(File[]::new);
    }

    public static void main(String[] args) {
        Ex3 ex = new Ex3();
        String currentDirecotry = Paths.get(".").toAbsolutePath().normalize().toString();
        File[] filesWithCertainExtension = ex.getFileWithExtension(currentDirecotry, "xml");
        for (File file : filesWithCertainExtension) {
            System.out.println(file.getName());
        }
    }

    @Test
    public void test() {
        Ex3 ex = new Ex3();
        String currentDirecotry = Paths.get(".").toAbsolutePath().normalize().toString();
        String[] filesWithCertainExtension = Arrays.stream(ex.getFileWithExtension(currentDirecotry, "xml")).map(File::getName).toArray(String[]::new);
        assertThat(Arrays.asList(filesWithCertainExtension), hasItem("pom.xml"));
        assertThat(Arrays.asList(filesWithCertainExtension), not(hasItem("src")));
    }

}
