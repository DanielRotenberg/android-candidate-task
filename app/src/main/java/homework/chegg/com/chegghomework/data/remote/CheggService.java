package homework.chegg.com.chegghomework.data.remote;


import homework.chegg.com.chegghomework.Consts;
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
    @GET(Consts.DATA_SOURCE_A_URL)
    Observable<DataSourceA> getDataSourceA();

    @GET(Consts.DATA_SOURCE_B_URL)
    Observable<DataSourceB> getDataSourceB();

    @GET(Consts.DATA_SOURCE_C_URL)
    Observable<List<News>> getDataSourceC();

}
