package uk.ac.edd.patterns.observable;

import rx.Observable;
import rx.functions.Action1;

/**
 * Observable akin to a publisher: something
 * that can be observed.
 *
 * Created by edd on 13/09/2015.
 */
public class HelloWorldRxJava {
    public static void hello(String... names) {
        Observable.from(names).subscribe(new Action1<String>() {

            @Override
            public void call(String s) {
                System.out.println("Hello " + s + "!");
            }

        });
    }
}
