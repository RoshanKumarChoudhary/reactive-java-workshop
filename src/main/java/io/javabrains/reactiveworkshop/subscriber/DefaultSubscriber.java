package io.javabrains.reactiveworkshop.subscriber;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class DefaultSubscriber<T> implements Subscriber<T> {

    private String name = "";

    private Subscription subscription;

    public DefaultSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(T o) {
        System.out.println("On next invoked for " + name + " items " + o);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("An error occurred for " + name + " " + throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.out.println("On complete got invoked for " + name);
    }
}
