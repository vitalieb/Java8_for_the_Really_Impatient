package com.blahblah.ch1;

public class Ex12 {

//    from http://stackoverflow.com/questions/33131195/java-8-default-methods-concerns-for-legacy-code:
//    1. The new stream() default method in Collection returns a Stream<E>, also a new type in Java 8.
//       Legacy code will fail compilation if it contains a stream() method with the same signature,
//       but returning something else, resulting in a clash of return types.
//    2. Legacy code will continue to run as long as it's not recompiled.

}