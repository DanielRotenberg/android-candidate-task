package homework.chegg.com.chegghomework.data;


import android.util.Log;
import homework.chegg.com.chegghomework.data.entities.Item;
import homework.chegg.com.chegghomework.data.entities.dataSourceA.DataSourceA;
import homework.chegg.com.chegghomework.data.entities.dataSourceB.DataSourceB;
import homework.chegg.com.chegghomework.data.entities.dataSourceC.DataSourceC;
import homework.chegg.com.chegghomework.data.entities.dataSourceC.News;
import io.reactivex.Observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.schedulers.Timed;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by DanielR on 30/11/2017.
 */
@Singleton
public class CheggRepository implements CheggDataSource {

  private List<Item> multipleSourcesList = new ArrayList<>();
  private Map<String, List<Item>> cachedListMap = new HashMap<>();
  CheggDataSource remoteDataSource;

  @Inject
  public CheggRepository(CheggDataSource remoteDataSource) {
    this.remoteDataSource = remoteDataSource;
  }


  @Override
  public Observable<List<Item>> getDataSourceA() {
    Log.e("jira", "getDataSourceA: called");
    Observable.interval(5, TimeUnit.SECONDS).timeInterval()
        .map(new Function<Timed<Long>, Observable<List<Item>>>() {
          @Override
          public Observable<List<Item>> apply(Timed<Long> longTimed) throws Exception {
            Observable<List<Item>> observable = remoteDataSource.getDataSourceA();
            observable.subscribe(itemList -> Log.d("jira", "apply: " + itemList.size()));
            return remoteDataSource.getDataSourceA();
          }
        });

//                public Observable<List<Item>> call(Long seconds) {
//                    return remoteDataSource.getDataSourceA(); } });
    return remoteDataSource.getDataSourceA();
  }

  @Override
  public Observable<List<Item>> getDataSourceB() {
    return remoteDataSource.getDataSourceB();
  }

  @Override
  public Observable<List<Item>> getDataSourceC() {
    return remoteDataSource.getDataSourceC();
  }

  @Override
  public Observable<List<Item>> fetchDataFromMultipleSources() {

    Observable<List<Item>> firstSourec = getOriginalA().subscribeOn(Schedulers.io()).map(
        dataSourceA -> {
          List<Item> temp = dataSourceA.convert();
          multipleSourcesList.addAll(temp);
          cachedListMap.put(dataSourceA.getClass().getSimpleName(), temp);
          return temp;
        });

    Observable<List<Item>> secondSourec = getOriginalB().subscribeOn(Schedulers.io()).map(
        dataSourceB -> {
          List<Item> temp = dataSourceB.convert();
          multipleSourcesList.addAll(temp);
          cachedListMap.put(dataSourceB.getClass().getSimpleName(), temp);
          return temp;
        });
/*
return cheggService.getDataSourceC().map(news -> {
      DataSourceC dataSourceC = new DataSourceC();
      dataSourceC.setNewsList(news);
      return dataSourceC.convert();
    });

 */
    Observable<List<Item>> thirdSource = getOriginalC().subscribeOn(Schedulers.io()).map(news -> {
      DataSourceC dataSourceC = new DataSourceC();
      dataSourceC.setNewsList(news);
      List<Item> temp = dataSourceC.convert();
      multipleSourcesList.addAll(temp);
      cachedListMap.put(dataSourceC.getClass().getSimpleName(), temp);
      return temp;
    });
return Observable.zip(firstSourec,secondSourec,thirdSource,(itemList, itemList2, itemList3) -> multipleSourcesList);
//      Observable<List<Item>> thirdSourec = getOriginalC().map(
//          dataSourceC -> {
//            DataSourceC dataSourceCtemp = new DataSourceC();
//            dataSourceC.setNewsList(news);
//            return dataSourceC.convert();
//            List<Item> temp = dataSourceC.convert();
//            multipleSourcesList.addAll(temp);
//            cachedListMap.put(dataSourceC.getClass().getSimpleName(),temp);
//            return temp;
//          });

    //   return cheggService.getDataSourceA().map(dataSourceA -> dataSourceA.convert());
  /*       Observable<List<Item>> finalObservarble = Observable
        .zip(remoteDataSource.getDataSourceA().subscribeOn(Schedulers.io()),
            remoteDataSource.getDataSourceB().subscribeOn(Schedulers.io())
            , remoteDataSource.getDataSourceC().subscribeOn(Schedulers.io()),
            (items, items2, items3) -> {
                cachedListMap.put(items.getClass().getSimpleName(),items);
                cachedListMap.put(items2.getClass().getSimpleName(),items2);
                cachedListMap.put(items3.getClass().getSimpleName(),items3);
//              items.addAll(items2);
//              items.addAll(items3);
              multipleSourcesList.addAll(items);
              multipleSourcesList.addAll(items2);
              multipleSourcesList.addAll(items3);
              return multipleSourcesList;
            });
    return finalObservarble;
       // return remoteDataSource.fetchDataFromMultipleSources();*/
  }

  @Override
  public Observable<DataSourceA> getOriginalA() {
    return remoteDataSource.getOriginalA();
  }

  @Override
  public Observable<DataSourceB> getOriginalB() {
    return remoteDataSource.getOriginalB();
  }

  @Override
  public Observable<List<News>> getOriginalC() {
    return remoteDataSource.getOriginalC();
  }

  @Override
  public Observable<DataSourceA> refreshSourceA() {
   // Observable<List<Item>> observable =

    return null;
  }


  private boolean checkIfNeedRefresh(String key ,List<Item> list) {

    List<Item> cachedList = cachedListMap.get(list.getClass().getSimpleName());
    return false;
  }
}

