package uk.ac.edd.patterns.observable;

import org.junit.Test;
import rx.Observable;
import rx.Subscriber;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by edd on 13/09/2015.
 */
public class HelloWorldRxJavaTest {

    @Test
    public void testHello() throws Exception {
        HelloWorldRxJava.hello("Hello", "World!");
    }

    @Test
    public void pubAndSub() {
        Observable<String> observable = Observable.from(Arrays.asList("one", "two"));
        Subscriber<String> subscriber1 = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Subscriber 1 completed.");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber 1 received: " + s);
            }
        };
        observable.subscribe(subscriber1);

        Subscriber<String> subscriber2 = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("Subscriber 2 completed.");
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("Subscriber 2 received: " + s);
            }
        };
        observable.subscribe(subscriber2);
    }

}