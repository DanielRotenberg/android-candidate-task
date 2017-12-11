package homework.chegg.com.chegghomework.data;


import homework.chegg.com.chegghomework.data.entities.Item;
import homework.chegg.com.chegghomework.data.entities.dataSourceA.DataSourceA;
import homework.chegg.com.chegghomework.data.entities.dataSourceC.DataSourceC;
import homework.chegg.com.chegghomework.data.remote.CheggService;
import io.reactivex.Observable;

import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by DanielR on 30/11/2017.
 */
@Singleton
public class CheggRepository implements CheggDataSource {

  private Map<String, List<Item>> itemsMap = new HashMap<>();
  CheggService cheggService;

  @Inject
  public CheggRepository(CheggService cheggService) {
    this.cheggService = cheggService;
  }

  @Override
  public Observable<List<Item>> fetchDataFromMultipleSources() {
    Observable<List<Item>> firstSource = cheggService.getDataSourceA().subscribeOn(Schedulers.io())
        .map(
            dataSourceA -> {
              List<Item> temp = dataSourceA.convert();
              itemsMap.put(dataSourceA.getClass().getSimpleName(), temp);
              return temp;
            });

    Observable<List<Item>> secondSource = cheggService.getDataSourceB().subscribeOn(Schedulers.io())
        .map(
            dataSourceB -> {
              List<Item> temp = dataSourceB.convert();
              itemsMap.put(dataSourceB.getClass().getSimpleName(), temp);
              return temp;
            });
    Observable<List<Item>> thirdSource = cheggService.getDataSourceC().subscribeOn(Schedulers.io())
        .map(news -> {
          DataSourceC dataSourceC = new DataSourceC();
          dataSourceC.setNewsList(news);
          List<Item> temp = dataSourceC.convert();
          itemsMap.put(dataSourceC.getClass().getSimpleName(), temp);
          return temp;
        });
    return Observable.zip(firstSource, secondSource, thirdSource,
        (itemList, itemList2, itemList3) -> convertMapToList());
  }

  @Override
  public Observable<List<Item>> refreshSourceA() {
    Observable<List<Item>> itemSource = cheggService.getDataSourceA().subscribeOn(Schedulers.io())
        .map(
            dataSourceA -> {
              List<Item> temp = dataSourceA.convert();
              List<Item> cashedList = itemsMap.get(DataSourceA.class.getSimpleName());
              if ((isListDataChanged(cashedList, temp))) {
                itemsMap.put(dataSourceA.getClass().getSimpleName(), temp);
              }
              return convertMapToList();
            });
    return itemSource;
  }

  @Override
  public Observable<List<Item>> refreshSourceB() {
    Observable<List<Item>> itemSource = cheggService.getDataSourceB().subscribeOn(Schedulers.io())
        .map(
            dataSourceB -> {
              List<Item> temp = dataSourceB.convert();
              List<Item> cashedList = itemsMap.get(DataSourceA.class.getSimpleName());
              if ((isListDataChanged(cashedList, temp))) {
                itemsMap.put(dataSourceB.getClass().getSimpleName(), temp);
              }
              return convertMapToList();
            });
    return itemSource;
  }

  @Override
  public Observable<List<Item>> refreshSourceC() {
    Observable<List<Item>> itemSource = cheggService.getDataSourceC().subscribeOn(Schedulers.io())
        .map(news -> {
          DataSourceC dataSourceC = new DataSourceC();
          dataSourceC.setNewsList(news);
          List<Item> temp = dataSourceC.convert();
          itemsMap.put(dataSourceC.getClass().getSimpleName(), temp);
          return convertMapToList();
        });

    return itemSource;
  }

  private boolean isListDataChanged(List<Item> cashed, List<Item> newList) {
    boolean dataChanged = false;
    for (int i = 0; i < cashed.size(); i++) {
      if (!cashed.get(i).equals(newList.get(i))) {
        dataChanged = true;
        break;
      }
    }
    return dataChanged;
  }

  private List<Item> convertMapToList() {
    List<Item> finalList = new ArrayList<>();
    for (List<Item> itemList : itemsMap.values()) {
      finalList.addAll(itemList);
    }
    return finalList;
  }

}



