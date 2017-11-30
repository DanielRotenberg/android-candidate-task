package homework.chegg.com.chegghomework.data;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by DanielR on 30/11/2017.
 */
@Module
public class CheggDataSourceModule {

  @Provides
  @Singleton
  public CheggRepository provideCheggRepository(CheggDataSource cheggDataSource) {
    return new CheggRepository(cheggDataSource);

  }


}


