package homework.chegg.com.chegghomework.data.remote;


import homework.chegg.com.chegghomework.data.entities.dataSourceA.DataSourceA;
import homework.chegg.com.chegghomework.data.entities.dataSourceB.DataSourceB;
import homework.chegg.com.chegghomework.data.entities.dataSourceC.News;
import io.reactivex.Observable;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by dr9874 on 30/11/2017.
 */

public interface CheggService {
    @GET("android_homeword_datasourceA.json")
    Observable<DataSourceA> getDataSourceA();

    @GET("android_homework_datasourceB.json")
    Observable<DataSourceB> getDataSourceB();

    @GET("android_homework_datasourceC.json")
    Observable<List<News>> getDataSourceC();

}
