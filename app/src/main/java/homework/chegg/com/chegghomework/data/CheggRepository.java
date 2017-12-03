package homework.chegg.com.chegghomework.data;



import homework.chegg.com.chegghomework.data.entities.Item;
import io.reactivex.Observable;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by DanielR on 30/11/2017.
 */
@Singleton
public class CheggRepository implements CheggDataSource {

    CheggDataSource remoteDataSource;

    @Inject
    public CheggRepository(CheggDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }


    @Override
    public Observable<List<Item>> getDataSourceA() {
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

        return remoteDataSource.fetchDataFromMultipleSources();
    }
}

