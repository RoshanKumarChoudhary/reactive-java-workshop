package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

import static io.javabrains.reactiveworkshop.ReactiveSources.intNumbersFlux;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here

        List<Integer> numbers = intNumbersFlux().toStream().toList();

        System.out.println("List " + numbers);
        System.out.println("Size " + numbers.size());


        System.out.println("Press a key to end");
    }

}
