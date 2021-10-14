import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observables.ConnectableObservable;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Launcher {

    private static int start = 1;
    private static int count = 5;
    private static final CompositeDisposable disposables = new CompositeDisposable();

    public static void main(String[] args){

        Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable1 = seconds.subscribe(s -> System.out.println("Observer 1: " + s));
        Disposable disposable2 = seconds.subscribe(s -> System.out.println("Observer 2: " + s));
        disposables.addAll(disposable1, disposable2);
        sleep(5000);
        disposables.dispose();
        sleep(5000);

        /*Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        Disposable disposable = seconds.subscribe(l -> System.out.println("RECEIVED:  " + l));
        sleep(5000);
        disposable.dispose();
        sleep(5000);*/

        /*Completable.fromRunnable( () -> runProcess() )
            .subscribe( () -> System.out.println("Done!"));*/

        /*Maybe<Integer> presentSource = Maybe.just(100);

        presentSource.subscribe(s -> System.out.println("Procces 1 RECIVED: " + s),
                    Throwable::printStackTrace,
                    () -> System.out.println("Done 1!"));

        Maybe<Integer> emptySource = Maybe.empty();
        emptySource.subscribe(s -> System.out.println("Procces 2 RECIVED: " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Done 2!"));

        Observable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Epsilon");
        source.firstElement()
                .subscribe(s -> System.out.println("Procces RECIVED: " + s),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));*/

        /*Observable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Epsilon");
        source.first("Nil")
                .subscribe(s -> System.out.println(s));*/

        /*Observable.fromCallable(() -> 1 / 0)
                .subscribe( i -> System.out.println("Recived :" + i),
                        e -> System.out.println("Error captured: " + e));*/

        /*Observable<Integer> source = Observable.defer( () -> Observable.range(start,count));
        source.subscribe(s -> System.out.println("Observer 1: " + s));
        count = 10;
        source.subscribe(s -> System.out.println("Observer 2: " + s));*/

        /*ConnectableObservable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS).publish();
        seconds.subscribe(s -> System.out.println("Observer 1: " +  s));
        seconds.connect();
        sleep(5000);
        seconds.subscribe(s -> System.out.println("Observer 2: " +  s));
        seconds.connect();
        sleep(5000);*/

        /*Observable<Long> seconds = Observable.interval(1, TimeUnit.SECONDS);
        seconds.subscribe(s -> System.out.println("Observer 1: " +  s));
        sleep(5000);
        seconds.subscribe(s -> System.out.println("Observer 2: " +  s));
        sleep(5000);*/

        /*Observable.range(5,10)
                .subscribe(s -> System.out.println("RECIVED: " +  s));*/

        /*ConnectableObservable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Epsilon").publish();*/
        /*Observable<String> source = Observable.just("Alpha","Beta","Gamma","Delta","Epsilon");*/

        /*source.subscribe(s -> System.out.println("Observer 1 received: " + s));

        source.map(String::length)
                .subscribe(s -> System.out.println("Observer 2 received: " + s));*/

        /*/source.map(String::length)
                .filter(i -> i >= 5)
                .subscribe(s -> System.out.println("Observer 2 received: " + s));*/

        /*source.connect();*/

        /*source.subscribe(s -> System.out.println("Observer 2 received: " + s));*/

        /*source.map(String::length)
                .filter(i -> i >= 5)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));*/

        /*Observer<Integer> myObserver = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("RECEIVED: " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done!");
            }
        };

        source.map(String::length)
                .filter(i -> i >= 5)
                .subscribe(myObserver);*/

        /*Observable<String> source = Observable.create( emitter -> {
            try {
                emitter.onNext("Alpha");
                emitter.onNext("Beta");
                emitter.onNext("Gamma");
                emitter.onNext("Delta");
                emitter.onNext("Epsilon");
                emitter.onComplete();
            } catch (Throwable e) {
                emitter.onError(e);
            }
        });*/

        /*List<String> items = Arrays.asList("Alpha","Beta","Gamma","Delta","Epsilon");
        Observable<String> source = Observable.fromIterable(items);

        source.map(String::length)
                .filter( i -> i >= 5)
                .subscribe(s -> System.out.println("RECEIVE: " + s),
                        Throwable::printStackTrace);*/

        /*
        Observable<Integer> lenghts = source.map(String::length);
        Observable<Integer> filtered = lenghts.filter(i -> i >= 5);
        filtered.subscribe(s -> System.out.println("RECEIVE: " + s),
        Throwable::printStackTrace);
        */

        /*
        Observable<String> source = Observable.create( emitter -> {
            emitter.onNext("Alpha");
            emitter.onNext("Beta");
            emitter.onNext("Gamma");
            emitter.onNext("Delta");
            emitter.onNext("Epsilon");
            emitter.onComplete();
        });

        source.subscribe(s -> System.out.println("RECEIVE: " + s));
        */

        /*
        Observable<Long> secondInterval= Observable.interval(1, TimeUnit.SECONDS);
        secondInterval.subscribe(System.out::println);
        sleep(5000);
        */

        /*
        Observable<String> myString =
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        myString.map(s -> s.length())
        .subscribe(System.out::println);
        */

        /* myString.subscribe(s -> System.out.println(s)); */
    }

    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void runProcess(){
        // Nothing
    }
}
