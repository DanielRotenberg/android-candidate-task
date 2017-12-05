package homework.chegg.com.chegghomework.data.remote;



import android.util.Log;
import homework.chegg.com.chegghomework.data.CheggDataSource;
import homework.chegg.com.chegghomework.data.entities.Item;
import homework.chegg.com.chegghomework.data.entities.dataSourceA.DataSourceA;
import homework.chegg.com.chegghomework.data.entities.dataSourceB.DataSourceB;
import homework.chegg.com.chegghomework.data.entities.dataSourceC.DataSourceC;

import homework.chegg.com.chegghomework.data.entities.dataSourceC.News;
import io.reactivex.Observable;

import io.reactivex.schedulers.Schedulers;

import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Created by DanielR on 30/11/2017.
 */
@Singleton
public class CheggRemoteDataSource implements CheggDataSource {

  CheggService cheggService;


  @Inject
  public CheggRemoteDataSource(CheggService cheggService) {
    this.cheggService = cheggService;
  }

  @Override
  public Observable<List<Item>> getDataSourceA() {
    Log.i("jira", "getDataSourceA: called in remote");
    return cheggService.getDataSourceA().map(dataSourceA -> dataSourceA.convert());

  }

  @Override
  public Observable<List<Item>> getDataSourceB() {
    return cheggService.getDataSourceB().map(dataSourceB -> dataSourceB.convert());


  }

  @Override
  public Observable<List<Item>> getDataSourceC() {
    return cheggService.getDataSourceC().map(news -> {
      DataSourceC dataSourceC = new DataSourceC();
      dataSourceC.setNewsList(news);
      return dataSourceC.convert();
    });
  }

  @Override
  public Observable<List<Item>> fetchDataFromMultipleSources() {
//    Observable<List<Item>> finalObservarble = Observable
//        .zip(getDataSourceA().subscribeOn(Schedulers.io()),
//            getDataSourceB().subscribeOn(Schedulers.io())
//            , getDataSourceC().subscribeOn(Schedulers.io()),
//            (items, items2, items3) -> {
//              items.addAll(items2);
//              items.addAll(items3);
//              return items;
//            });
//    return finalObservarble;
    return null;
  }

  @Override
  public Observable<DataSourceA> getOriginalA() {
    return cheggService.getDataSourceA();
  }

  @Override
  public Observable<DataSourceB> getOriginalB() {
    return cheggService.getDataSourceB();
  }

  @Override
  public Observable<List<News>> getOriginalC() {
    return cheggService.getDataSourceC();
  }

  @Override
  public Observable<DataSourceA> refreshSourceA() {
    return null;
  }

}



