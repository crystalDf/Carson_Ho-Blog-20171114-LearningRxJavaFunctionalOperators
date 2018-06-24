package com.star.learningrxjavafunctionaloperators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observable;
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
//
//        Observable
//                .create((ObservableOnSubscribe<Integer>) emitter -> {
//
//                    emitter.onNext(1);
//                    emitter.onNext(2);
//                    emitter.onNext(3);
//                    emitter.onError(new Exception("发生错误了"));
//                })
//                .onExceptionResumeNext(new Observable<Integer>() {
//                    @Override
//                    protected void subscribeActual(Observer<? super Integer> observer) {
//                        observer.onNext(11);
//                        observer.onNext(22);
//                        observer.onComplete();
//                    }
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
//                    emitter.onError(new Exception("发生错误了"));
//                    emitter.onNext(3);
//                })
//                .retry()
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
//                    emitter.onError(new Exception("发生错误了"));
//                    emitter.onNext(3);
//                })
//                .retry(3)
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
//                    emitter.onError(new Exception("发生错误了"));
//                    emitter.onNext(3);
//                })
//                .retry(throwable -> {
//                    Log.d(TAG, "retry错误: " + throwable.toString());
//
//                    return true;
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
//                    emitter.onError(new Exception("发生错误了"));
//                    emitter.onNext(3);
//                })
//                .retry((integer, throwable) -> {
//                    Log.d(TAG, "异常错误 = " + throwable.toString());
//                    Log.d(TAG, "当前重试次数 = " + integer);
//
//                    return true;
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
//                    emitter.onError(new Exception("发生错误了"));
//                    emitter.onNext(3);
//                })
//                .retry(3, throwable -> {
//                    Log.d(TAG, "retry错误: " + throwable.toString());
//
//                    return true;
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
//                    emitter.onError(new Exception("发生错误了"));
//                    emitter.onNext(3);
//                })
//                .retryUntil(() -> {
//                    Log.d(TAG, "retry错误: ");
//
//                    return false;
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
//                    emitter.onError(new Exception("发生错误了"));
//                    emitter.onNext(3);
//                })
//                .retryWhen(throwableObservable ->
//                        throwableObservable.flatMap(throwable ->
//                                Observable.error(new Throwable("retryWhen终止啦"))))
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
//                        Log.d(TAG, "对Error事件作出响应" + e.toString());
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
//                    emitter.onError(new Exception("发生错误了"));
//                    emitter.onNext(3);
//                })
//                .retryWhen(throwableObservable ->
//                        throwableObservable.flatMap(throwable ->
//                                Observable.just(4)))
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
//                        Log.d(TAG, "对Error事件作出响应" + e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .just(1, 2, 3, 4)
//                .repeat(3)
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
//                        Log.d(TAG, "对Error事件作出响应" + e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .just(1, 2, 3, 4)
//                // 情况1：若新被观察者(Observable)返回1个Complete()/Error()事件，则不重新订阅 & 发送原来的Observable
//                .repeatWhen(objectObservable -> {
//                    // Observable.empty() = 发送Complete事件
//
//                    return Observable.empty();
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
//                        Log.d(TAG, "对Error事件作出响应" + e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });
//
//        Observable
//                .just(1, 2, 3, 4)
//                // 情况1：若新被观察者(Observable)返回1个Complete()/Error()事件，则不重新订阅 & 发送原来的 Observable
//                .repeatWhen(objectObservable -> {
//                    // 返回Error事件 = 回调onError（）事件，并接收传过去的错误信息。
//
//                    return Observable.error(new Throwable("不再重新订阅事件"));
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
//                        Log.d(TAG, "对Error事件作出响应" + e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Log.d(TAG, "对Complete事件作出响应");
//                    }
//                });

        Observable
                .just(1, 2, 3, 4)
                // 情况2：若新被观察(Observable)返回其余事件，则重新订阅 & 发送原来的 Observable
                .repeatWhen(objectObservable -> {
                    // 仅仅是作为1个触发重新订阅被观察者的通知，发送的是什么数据并不重要，只要不是Complete()/Error()事件。

                    return Observable.just(1);
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
                        Log.d(TAG, "对Error事件作出响应" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "对Complete事件作出响应");
                    }
                });
    }
}
