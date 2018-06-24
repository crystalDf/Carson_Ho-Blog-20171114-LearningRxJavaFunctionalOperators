package com.star.learningrxjavafunctionaloperators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RxJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Observable
//                .just(1, 2, 3)
//                .delay(3, TimeUnit.SECONDS)
//                .subscribe(new Observer<Integer>() {
//
//                    private Disposable mDisposable;
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接");
//
//                        mDisposable = d;
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应");
//
//                        if (integer == 2) {
//                            mDisposable.dispose();
//
//                            Log.d(TAG, "已经切断了连接：" + mDisposable.isDisposed());
//                        }
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .create((ObservableOnSubscribe<Integer>) emitter -> {
//
//                    emitter.onNext(1);
//                    emitter.onNext(2);
//                    emitter.onNext(3);
//                    emitter.onError(new Throwable("发生错误了"));
//                })
//                .doOnSubscribe(disposable -> Log.d(TAG, "doOnSubscribe: "))
//                .doOnEach(integerNotification ->
//                        Log.d(TAG, "doOnEach: " + integerNotification.getValue()))
//                .doOnNext(integer -> Log.d(TAG, "doOnNext: " + integer))
//                .doAfterNext(integer -> Log.d(TAG, "doAfterNext: " + integer))
//                .doOnComplete(() -> Log.d(TAG, "doOnComplete: "))
//                .doOnError(throwable -> Log.d(TAG, "doOnError: " + throwable.getMessage()))
//                .doFinally(() -> Log.d(TAG, "doFinally: "))
//                .doAfterTerminate(() -> Log.d(TAG, "doAfterTerminate: "))
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应"  );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .create((ObservableOnSubscribe<Integer>) emitter -> {
//
//                    emitter.onNext(1);
//                    emitter.onNext(2);
//                    emitter.onNext(3);
//                    emitter.onError(new Throwable("发生错误了"));
//                })
//                .onErrorReturn(throwable -> {
//                    Log.d(TAG, "在onErrorReturn处理了错误: " + throwable.toString());
//
//                    return 666;
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应"  );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .create((ObservableOnSubscribe<Integer>) emitter -> {
//
//                    emitter.onNext(1);
//                    emitter.onNext(2);
//                    emitter.onNext(3);
//                    emitter.onError(new Throwable("发生错误了"));
//                })
//                .onErrorResumeNext(throwable -> {
//                    Log.d(TAG, "在onErrorReturn处理了错误: " + throwable.toString());
//
//                    return Observable.just(11,22);
//                })
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Log.d(TAG, "开始采用subscribe连接");
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//                        Log.d(TAG, "对Next事件" + integer + "作出响应"  );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.d(TAG, "对Error事件作出响应");
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });

        Observable
                .create((ObservableOnSubscribe<Integer>) emitter -> {

                    emitter.onNext(1);
                    emitter.onNext(2);
                    emitter.onNext(3);
                    emitter.onError(new Exception("发生错误了"));
                })
                .onExceptionResumeNext(new Observable<Integer>() {
                    @Override
                    protected void subscribeActual(Observer<? super Integer> observer) {
                        observer.onNext(11);
                        observer.onNext(22);
                        observer.onComplete();
                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "开始采用subscribe连接");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.d(TAG, "对Next事件" + integer + "作出响应"  );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "对Error事件作出响应");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }
}
