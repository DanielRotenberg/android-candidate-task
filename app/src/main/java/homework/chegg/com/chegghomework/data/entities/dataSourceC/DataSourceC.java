package homework.chegg.com.chegghomework.data.entities.dataSourceC;

import android.util.Log;
import homework.chegg.com.chegghomework.data.entities.DataConverter;
import homework.chegg.com.chegghomework.data.entities.Item;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dr9874 on 30/11/2017.
 */

public class DataSourceC implements DataConverter {

  private List<News> newsList = Collections.emptyList();

  public List<News> getNewsList() {
    return newsList;
  }

  public void setNewsList(List<News> newsList) {
    this.newsList = newsList;
  }

  @Override
  public List<Item> convert() {
    List<Item> itemList = new ArrayList<>();
    for (News news : newsList) {
      Item item = new Item();
      item.setHeader(news.getTopLine());
      item.setDescription(news.getSubLine1().concat(news.getSubline2()));
      item.setPicture(news.getImage());
      itemList.add(item);
    }
    return itemList;
  }

  @Override
  public void fetchData() {

  }
}
