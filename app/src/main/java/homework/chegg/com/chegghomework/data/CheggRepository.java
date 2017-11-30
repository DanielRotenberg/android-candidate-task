package homework.chegg.com.chegghomework.data;

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
  public void getDataSourceA() {
    remoteDataSource.getDataSourceA();
  }

  @Override
  public void getDataSourceB() {
    remoteDataSource.getDataSourceB();
  }

  @Override
  public void getDataSourceC() {
    remoteDataSource.getDataSourceC();
  }
}
