package homework.chegg.com.chegghomework;

import android.app.Application;
import homework.chegg.com.chegghomework.data.CheggDataSourceModule;
import homework.chegg.com.chegghomework.injection.component.DaggerGlobalComponent;
import homework.chegg.com.chegghomework.injection.component.GlobalComponent;
import homework.chegg.com.chegghomework.injection.module.ApplicationModule;
import homework.chegg.com.chegghomework.injection.module.CheggRemoteDataSourceModule;


/**
 * Created by dr9874 on 30/11/2017.
 */

public class CheggApplication extends Application {

 private GlobalComponent globalComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    globalComponent = DaggerGlobalComponent.builder()
        .applicationModule(new ApplicationModule(this))
        .cheggRemoteDataSourceModule(new CheggRemoteDataSourceModule())
        .cheggDataSourceModule(new CheggDataSourceModule()).build();
  }

  public GlobalComponent getGlobalComponent(){
    return globalComponent;
  }
}

