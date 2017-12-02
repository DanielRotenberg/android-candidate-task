package homework.chegg.com.chegghomework.data.remote;


import android.util.Log;
import homework.chegg.com.chegghomework.data.CheggDataSource;
import homework.chegg.com.chegghomework.data.entities.Item;
import homework.chegg.com.chegghomework.data.entities.dataSourceC.DataSourceC;

import io.reactivex.Observable;

import io.reactivex.functions.Function3;
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
    Log.e("jira", "fetchDataFromMultipleSources: "+getClass().getSimpleName() );
    Observable<List<Item>> finalObservarble = Observable
        .zip(getDataSourceA().subscribeOn(Schedulers.io()),
            getDataSourceB().subscribeOn(Schedulers.io())
            , getDataSourceC().subscribeOn(Schedulers.io()),
            new Function3<List<Item>, List<Item>, List<Item>, List<Item>>() {
              @Override
              public List<Item> apply(List<Item> items, List<Item> items2, List<Item> items3)
                  throws Exception {
                items.addAll(items2);
                items.addAll(items3);
                Log.e("jira1", "apply: final size is "+items.size() );
                return items;
              }
            });
    return finalObservarble;
  }
}



