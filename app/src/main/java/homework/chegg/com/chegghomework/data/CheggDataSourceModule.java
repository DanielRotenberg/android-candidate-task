package homework.chegg.com.chegghomework.data;

import dagger.Module;
import dagger.Provides;
import homework.chegg.com.chegghomework.data.remote.CheggService;

import javax.inject.Singleton;

/**
 * Created by DanielR on 30/11/2017.
 */
@Module
public class CheggDataSourceModule {

  @Provides
  @Singleton
  public CheggRepository provideCheggRepository(CheggService cheggService) {
    return new CheggRepository(cheggService);

  }


}


