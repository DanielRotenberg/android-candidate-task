package homework.chegg.com.chegghomework.injection.component;

import android.content.Context;
import dagger.Component;

import homework.chegg.com.chegghomework.data.CheggDataSourceModule;
import homework.chegg.com.chegghomework.data.CheggRepository;
import homework.chegg.com.chegghomework.injection.module.ApplicationModule;
import homework.chegg.com.chegghomework.injection.module.CheggRemoteDataSourceModule;
import javax.inject.Singleton;

/**
 * Created by dr9874 on 30/11/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class, CheggRemoteDataSourceModule.class, CheggDataSourceModule.class})
public interface GlobalComponent {
  CheggRepository getCheggRepository();

  Context getApllicationContext();

}
