package homework.chegg.com.chegghomework.data.remote;


import homework.chegg.com.chegghomework.data.CheggDataSource;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by DanielR on 30/11/2017.
 */
@Singleton
public class CheggRemoteDataSource implements CheggDataSource {

  CheggService cheggService;

  @Inject
  public CheggRemoteDataSource(CheggService cheggService) {
    this.cheggService = cheggService;
  }

  @Override
  public void getDataSourceA() {
    cheggService.getDataSourceA();
  }

  @Override
  public void getDataSourceB() {
    cheggService.getDataSourceB();
  }

  @Override
  public void getDataSourceC() {
    cheggService.getDataSourceC();
  }
}
