package homework.chegg.com.chegghomework.Presentation;

import android.util.Log;

import homework.chegg.com.chegghomework.Presentation.CheggContract.View;

import homework.chegg.com.chegghomework.data.CheggRepository;
import homework.chegg.com.chegghomework.data.entities.Item;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Created by DanielR on 30/11/2017.
 */

public class CheggPresenter implements CheggContract.Presenter {

    public static final String TAG = CheggPresenter.class.getSimpleName();
    private CompositeDisposable subscriptions = new CompositeDisposable();
    ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(3);
    CheggContract.View view;
    CheggRepository cheggRepository;

    @Inject
    public CheggPresenter(View view, CheggRepository cheggRepository) {
        this.view = view;
        this.cheggRepository = cheggRepository;
    }

    @Override
    public void subscribe() {
        Observable<List<Item>> listObservable = cheggRepository.fetchDataFromMultipleSources();
        Disposable disposable = listObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(
                next -> view.showUpdatedData(next),
                throwable -> Log.e(TAG, "subscribe: error " + throwable.getMessage()));
        subscriptions.add(disposable);
    }

    @Override
    public void unSubscribe() {
        if (subscriptions != null && !subscriptions.isDisposed()) {
            subscriptions.dispose();
        }
    }

    @Override
    public void refreshData() {
        refreshDataSourceA();
        refreshDataSourceB();
        refreshDataSourceC();
    }



    private void refreshDataSourceA() {
        Observable<List<Item>> listSourceA = cheggRepository.refreshSourceA();
        exec.scheduleAtFixedRate(() -> {
            Disposable disposable = listSourceA.observeOn(AndroidSchedulers.mainThread()).subscribe(
                    next -> view.showRefreshData(next),
                    throwable -> Log.e(TAG, "subscribe: error " + throwable.getMessage()));
            subscriptions.add(disposable);
        }, 0, 20, TimeUnit.SECONDS);
    }

    private void refreshDataSourceB() {
        Observable<List<Item>> listSourceB = cheggRepository.refreshSourceB();
        exec.scheduleAtFixedRate(() -> {
            Disposable disposable = listSourceB.observeOn(AndroidSchedulers.mainThread()).subscribe(
                    next -> view.showRefreshData(next),
                    throwable -> Log.e(TAG, "subscribe: error " + throwable.getMessage()));
            subscriptions.add(disposable);
        }, 0, 10, TimeUnit.SECONDS);
    }

    private void refreshDataSourceC() {
        Observable<List<Item>> listSourceC = cheggRepository.refreshSourceC();
        exec.scheduleAtFixedRate(() -> {
            Disposable disposable = listSourceC.observeOn(AndroidSchedulers.mainThread()).subscribe(
                    next -> view.showRefreshData(next),
                    throwable -> Log.e(TAG, "subscribe: error " + throwable.getMessage()));
            subscriptions.add(disposable);
        }, 0, 30, TimeUnit.SECONDS);

    }




}

