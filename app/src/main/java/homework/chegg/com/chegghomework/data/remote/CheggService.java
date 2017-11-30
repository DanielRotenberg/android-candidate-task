package homework.chegg.com.chegghomework.data.remote;


import homework.chegg.com.chegghomework.data.entities.dataSourceA.DataSourceA;
import homework.chegg.com.chegghomework.data.entities.dataSourceB.DataSourceB;
import homework.chegg.com.chegghomework.data.entities.dataSourceC.DataSourceC;
import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by dr9874 on 30/11/2017.
 */

public interface CheggService {
    @GET("android_homeword_datasourceA.json")
    Single<DataSourceA> getDataSourceA();

    @GET("android_homework_datasourceB.json")
    Single<DataSourceB> getDataSourceB();

    @GET("android_homework_datasourceC.json")
    Single<DataSourceC> getDataSourceC();
}
