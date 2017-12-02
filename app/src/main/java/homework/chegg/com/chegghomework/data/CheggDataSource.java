package homework.chegg.com.chegghomework.data;

import homework.chegg.com.chegghomework.data.entities.Item;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by DanielR on 30/11/2017.
 */

public interface CheggDataSource {

  Observable<List<Item>> getDataSourceA();

  Observable<List<Item>> getDataSourceB();

  Observable<List<Item>> getDataSourceC();

  Observable<List<Item>> fetchDataFromMultipleSources();

}
