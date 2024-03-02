package io.javabrains.reactiveworkshop;

import java.util.Comparator;

import static io.javabrains.reactiveworkshop.StreamSources.intNumbersStream;
import static io.javabrains.reactiveworkshop.StreamSources.userStream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        System.out.println("Print all numbers in the intNumbersStream stream");
        // TODO: Write code here
        intNumbersStream().forEach(System.out::println);

        System.out.println("// Print numbers from intNumbersStream that are less than 5");
        // TODO: Write code here
        intNumbersStream().filter(number -> number < 5).forEach(System.out::println);

        System.out.println("// Print the second and third numbers in intNumbersStream that's greater than 5");
        // TODO: Write code here
        intNumbersStream().filter(number -> number > 5)
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("//  Print the first number in intNumbersStream that's greater than 5.");
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println(intNumbersStream().filter(number -> number > 5)
                .findFirst()
                .orElse(-1));

        System.out.println("// Print first names of all users in userStream");
        // TODO: Write code here

        userStream().forEach(user -> System.out.println(user.getFirstName()));

        System.out.println("// Print first names in userStream for users that have IDs from number stream");
        // TODO: Write code here
        userStream()
                .filter(user ->
                        intNumbersStream()
                                .anyMatch(number -> number == user.getId()))
                .map(user -> user.getFirstName())
                .forEach(System.out::println);

    }

}
