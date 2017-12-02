package homework.chegg.com.chegghomework.data;

import android.util.Log;
import homework.chegg.com.chegghomework.data.entities.Item;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by DanielR on 30/11/2017.
 */
@Singleton
public class CheggRepository implements CheggDataSource {

  CheggDataSource remoteDataSource;

  List<Item> itemList = new ArrayList<>();

  @Inject
  public CheggRepository(CheggDataSource remoteDataSource) {
    this.remoteDataSource = remoteDataSource;
  }


  @Override
  public Observable<List<Item>> getDataSourceA() {
/*   Observable<List<Item>> list = remoteDataSource.getDataSourceA();
    Log.e("jirA", "getDataSourceA: "+getClass().getSimpleName());

   list.subscribe(new Observer<List<Item>>() {
     @Override
     public void onSubscribe(Disposable d) {
     }

     @Override
     public void onNext(List<Item> items) {

     }

     @Override
     public void onError(Throwable e) {
       Log.i("jira", "onError: "+e.getMessage());
     }

     @Override
     public void onComplete() {
       Log.i("jira", "onComplete: ");
     }
   });*/
    return null;
  }

  @Override
  public Observable<List<Item>> getDataSourceB() {
  /*  Log.e("jira", "getDataSourceB: " );
    Observable<List<Item>> list = remoteDataSource.getDataSourceB();
    list.subscribe(new Observer<List<Item>>() {
      @Override
      public void onSubscribe(Disposable d) {

      }

      @Override
      public void onNext(List<Item> items) {

      }

      @Override
      public void onError(Throwable e) {
        Log.i("jira", "onError: "+e.getMessage());
      }

      @Override
      public void onComplete() {
        Log.i("jira", "onComplete: ");
      }
    });*/


   // return remoteDataSource.getDataSourceB();
    return null;
  }

  @Override
  public Observable<List<Item>> getDataSourceC() {
  /*  Log.e("jira", "getDataSourceC: " );
   // return remoteDataSource.getDataSourceC();
    Observable<List<Item>> list = remoteDataSource.getDataSourceC();
    list.subscribe(new Observer<List<Item>>() {
      @Override
      public void onSubscribe(Disposable d) {
        Log.d("jira", "onSubscribe: ");
      }

      @Override
      public void onNext(List<Item> items) {

      }

      @Override
      public void onError(Throwable e) {
        Log.i("jira", "onError: "+e.getMessage());
      }

      @Override
      public void onComplete() {
        Log.i("jira", "onComplete: ");
      }
    }); */
    return null;
  }

  @Override
  public Observable<List<Item>> fetchDataFromMultipleSources() {
    Log.d("jira", "fetchDataFromMultipleSources: called "+getClass().getSimpleName());
    return remoteDataSource.fetchDataFromMultipleSources();
  }
}


