package io.javabrains.reactiveworkshop;

import io.javabrains.reactiveworkshop.subscriber.BasicSubscriber;
import io.javabrains.reactiveworkshop.subscriber.DefaultSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here

        ReactiveSources.intNumberMono()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));
        ReactiveSources.intNumbersFlux()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));
        ReactiveSources.userMono()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));
        ReactiveSources.userFlux()
                .subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Completed"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here


        ReactiveSources.intNumberMono()
                .subscribe(new DefaultSubscriber<>("Number Mono"));
        ReactiveSources.intNumbersFlux()
                .subscribe(new DefaultSubscriber<>("Number Flux"));
        ReactiveSources.userMono()
                .subscribe(new DefaultSubscriber<>("User Mono"));
        ReactiveSources.userFlux()
                .subscribe(new DefaultSubscriber<>("User Flux"));


        ReactiveSources.intNumberMono()
                .subscribe(new BasicSubscriber<>());
        ReactiveSources.intNumbersFlux()
                .subscribe(new BasicSubscriber<>());
        ReactiveSources.userMono()
                .subscribe(new BasicSubscriber<>());
        ReactiveSources.userFlux()
                .subscribe(new BasicSubscriber<>());

        System.out.println("Press a key to end");
        System.in.read();
    }

}