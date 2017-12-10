package homework.chegg.com.chegghomework.data;


import homework.chegg.com.chegghomework.data.entities.Item;
import homework.chegg.com.chegghomework.data.entities.dataSourceA.DataSourceA;
import homework.chegg.com.chegghomework.data.entities.dataSourceB.DataSourceB;
import homework.chegg.com.chegghomework.data.entities.dataSourceC.News;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.Call;

/**
 * Created by DanielR on 30/11/2017.
 */

public interface CheggDataSource {

  Observable<List<Item>> getDataSourceA();

  Observable<List<Item>> getDataSourceB();

  Observable<List<Item>> getDataSourceC();

  Observable<List<Item>> fetchDataFromMultipleSources();

  Observable<DataSourceA> getOriginalA();
  Observable<DataSourceB> getOriginalB();
  Observable<List<News>> getOriginalC();

  Observable<List<Item>> refreshSourceA();

 List<Item> refreshSourceACall();

}
