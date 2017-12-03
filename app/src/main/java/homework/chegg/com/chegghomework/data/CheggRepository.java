package homework.chegg.com.chegghomework.data;



import android.util.Log;
import homework.chegg.com.chegghomework.data.entities.Item;
import io.reactivex.Observable;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Timed;
import java.util.List;

import java.util.concurrent.TimeUnit;
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
        Log.e("jira", "getDataSourceA: called" );
        Observable.interval(5, TimeUnit.SECONDS).timeInterval()
            .map(new Function<Timed<Long>, Observable<List<Item>>>() {
                @Override
                public Observable<List<Item>> apply(Timed<Long> longTimed) throws Exception {
                    Observable<List<Item>> observable = remoteDataSource.getDataSourceA();
                    observable.subscribe(itemList -> Log.d("jira", "apply: " + itemList.size()));
                    return remoteDataSource.getDataSourceA();
                }

//                public Observable<List<Item>> call(Long seconds) {
//                    return remoteDataSource.getDataSourceA(); } });
            });

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

