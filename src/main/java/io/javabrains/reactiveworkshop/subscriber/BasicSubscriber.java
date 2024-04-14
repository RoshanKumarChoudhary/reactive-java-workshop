package io.javabrains.reactiveworkshop.subscriber;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.SignalType;

public class BasicSubscriber<T> extends BaseSubscriber<T> {


    @Override
    protected Subscription upstream() {
        return super.upstream();
    }

    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscription added ");
        request(3);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value + " received");
        request(1);
    }

    @Override
    protected void hookOnComplete() {
        super.hookOnComplete();
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        super.hookOnError(throwable);
    }

    @Override
    protected void hookOnCancel() {
        super.hookOnCancel();
    }

    @Override
    protected void hookFinally(SignalType type) {
        super.hookFinally(type);
    }
}
