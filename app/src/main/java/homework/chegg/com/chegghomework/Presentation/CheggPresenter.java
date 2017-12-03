package homework.chegg.com.chegghomework.Presentation;

import android.util.Log;
import homework.chegg.com.chegghomework.Presentation.CheggContract.View;

import homework.chegg.com.chegghomework.data.CheggRepository;
import homework.chegg.com.chegghomework.data.entities.Item;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Timed;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

/**
 * Created by DanielR on 30/11/2017.
 */

public class CheggPresenter implements CheggContract.Presenter {

  private CompositeDisposable subscriptions = new CompositeDisposable();
  CheggContract.View view;
  CheggRepository cheggRepository;

  @Inject
  public CheggPresenter(View view, CheggRepository cheggRepository) {
    this.view = view;
    this.cheggRepository = cheggRepository;
  }

  @Override
  public void subscribe() {
    cheggRepository.getDataSourceA();
   /* Observable<List<Item>> listObservable = cheggRepository.fetchDataFromMultipleSources();
    Disposable disposable = listObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(
        next -> {
          Log.d(
              "jira", "subscribe:YESSS " + next.size());
          view.showUpdatedData(next);
        },
        throwable -> Log.e("jira1", "subscribe: error " + throwable.getMessage()));

    subscriptions.add(disposable);*/

    view.showLoadingProgress();
  }

  @Override
  public void unSubscribe() {
    if (subscriptions != null && !subscriptions.isDisposed()) {
      subscriptions.dispose();
    }
  }

  @Override
  public void getDataUpdate() {

  }

  @Override
  public void refreshDataSourceA() {
    Observable<List<Item>> listSourceA = cheggRepository.getDataSourceA();
    Disposable disposable = listSourceA.observeOn(AndroidSchedulers.mainThread()).subscribe(
        next -> {
          Log.d(
              "jira", "subscribe:YESSS " + next.size());
          view.showUpdatedData(next);
        },
        throwable -> Log.e("jira1", "subscribe: error " + throwable.getMessage()));

    subscriptions.add(disposable);

  }

  @Override
  public void refreshDataSourceB() {
    Observable<List<Item>> listSourceB = cheggRepository.getDataSourceB();
    Disposable disposable = listSourceB.observeOn(AndroidSchedulers.mainThread()).subscribe(
        next -> {
          Log.d(
              "jira", "subscribe:YESSS " + next.size());
          view.showUpdatedData(next);
        },
        throwable -> Log.e("jira1", "subscribe: error " + throwable.getMessage()));

    subscriptions.add(disposable);
  }

  @Override
  public void refreshDataSourceC() {
    Observable<List<Item>> listSourceC = cheggRepository.getDataSourceC();
    Disposable disposable = listSourceC.observeOn(AndroidSchedulers.mainThread()).subscribe(
        next -> {
          Log.d(
              "jira", "subscribe:YESSS " + next.size());
          view.showUpdatedData(next);
        },
        throwable -> Log.e("jira1", "subscribe: error " + throwable.getMessage()));

    subscriptions.add(disposable);
  }

}

