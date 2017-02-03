package com.blahblah.ch1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.Assert.assertEquals;


public class Ex9 {

    interface Collection2<T> extends Collection<T> {
        default void forEachIf(Consumer<T> action, Predicate<T> filter) {
            forEach(e -> {
                if (filter.test(e)) {
                    action.accept(e);
                }
            });
        }
    }

    class ArrayList2<T> extends ArrayList<T> implements Collection2<T> {
    }

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void test() {
        Consumer consumer = object -> System.out.println("This is a null element!");

        Predicate objectIsNull = object -> {
            if (object != null) {
                return false;
            } else
                return true;
        };
        ArrayList2<String> array = new ArrayList2<>();
        array.add(null);
        array.add("One");
        array.add("Two");

        array.forEachIf(consumer, objectIsNull);

        assertEquals("This is a null element!\r\n", outContent.toString());
    }

}
