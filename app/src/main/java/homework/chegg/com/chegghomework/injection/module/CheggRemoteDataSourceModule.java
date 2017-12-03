package homework.chegg.com.chegghomework.injection.module;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;

import homework.chegg.com.chegghomework.Consts;
import homework.chegg.com.chegghomework.data.CheggDataSource;
import homework.chegg.com.chegghomework.data.remote.CheggRemoteDataSource;
import homework.chegg.com.chegghomework.data.remote.CheggService;
import javax.inject.Singleton;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dr9874 on 30/11/2017.
 */
@Module
public class CheggRemoteDataSourceModule {

  private final static String BASE_URL = "http://chegg-mobile-promotioms.s3.amazonaws.com/android/homework/";

  @Provides
  @Singleton
  CheggDataSource provideCheggRemoteDataSource(CheggService cheggService) {
    return new CheggRemoteDataSource(cheggService);
  }

  @Provides
  @Singleton
  CheggService provideCheggService(Retrofit retrofit) {
    return retrofit.create(CheggService.class);
  }

  @Provides
  @Singleton
  Retrofit provideRetrofit(OkHttpClient client, Gson gson) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build();

    return retrofit;
  }

  @Provides
  @Singleton
  OkHttpClient provideOkHttpClient(Cache cache) {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.cache(cache);
    return builder.build();
  }

  @Provides
  @Singleton
  Cache provideOkHttpCashe(Context application) {
    int cacheSize = 10 * 1024 * 1024; // 10 MiB
    Cache cache = new Cache(application.getCacheDir(), cacheSize);
    return cache;
  }

  @Provides
  @Singleton
  Gson provideGson() {
    return new GsonBuilder().create();
  }

}
