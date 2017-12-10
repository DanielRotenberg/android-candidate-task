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
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
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
//    cheggRepository.getDataSourceA();
    Observable<List<Item>> listObservable = cheggRepository.fetchDataFromMultipleSources();
    Disposable disposable = listObservable.observeOn(AndroidSchedulers.mainThread()).subscribe(
        next -> {
          Log.d(
              "jira", "here updating view vs full list" + next.size());
          view.showUpdatedData(next);
        },
        throwable -> Log.e("jira1", "subscribe: error " + throwable.getMessage()));

   // subscriptions.add(disposable);

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
    Observable<List<Item>> listSourceA = cheggRepository.refreshSourceA();
    ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
    long period = 100; // the period between successive executions
    exec.scheduleAtFixedRate(()-> {
      Log.w("jira", "refreshDataSourceA: excecuting scheduler");
//      Disposable disposable = listSourceA.observeOn(AndroidSchedulers.mainThread()).subscribe(
//          next -> {
//            Log.d(
//                "jira", "subscribe:Refreshing source AA" + next.size());
//            view.showUpdatedData(next);
//          },
//          throwable -> Log.e("jira1", "subscribe: error " + throwable.getMessage()));

      //subscriptions.add(disposable);
      Log.d("jira", "refreshData: A scheduler");
    }, 0, 20, TimeUnit.SECONDS);
    Log.e("jira", "refreshDataSourceA: AFTER excecuter task" );
    /*Disposable disposable = listSourceA.observeOn(AndroidSchedulers.mainThread()).subscribe(
        next -> {
          Log.d(
              "jira", "subscribe:YESSS AAA" + next.size());
          view.showUpdatedData(next);
        },
        throwable -> Log.e("jira1", "subscribe: error " + throwable.getMessage()));

    subscriptions.add(disposable);*/

  }

  @Override
  public void refreshDataSourceB() {
    Observable<List<Item>> listSourceB = cheggRepository.getDataSourceB();
    Disposable disposable = listSourceB.observeOn(AndroidSchedulers.mainThread()).subscribe(
        next -> {
          Log.d(
              "jira", "subscribe:YESSS BBB " + next.size());
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
              "jira", "subscribe:YESSS CCC" + next.size());
          view.showUpdatedData(next);
        },
        throwable -> Log.e("jira1", "subscribe: error " + throwable.getMessage()));

    subscriptions.add(disposable);
  }

  @Override
  public void refreshData() {

//    ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(3);
//    long period = 100; // the period between successive executions
//    exec.scheduleAtFixedRate(()-> {
//      cheggRepository.getDataSourceA();
//      Log.d("jira", "refreshData: A scheduler");
//    }, 0, 1, TimeUnit.MINUTES);





//    exec.scheduleAtFixedRate(()->{cheggRepository.getDataSourceB();
//      Log.e("jira", "refreshData: B scheduler" );},0,10,TimeUnit.SECONDS);
//    exec.scheduleAtFixedRate(()->cheggRepository.getDataSourceA(),0,15,TimeUnit.SECONDS);
    //long delay = 100; //the delay between the termination of one execution and the commencement of the next
    //exec.scheduleWithFixedDelay(new MyTask(), 0, delay, TimeUnit.MICROSECONDS);
  }

}

