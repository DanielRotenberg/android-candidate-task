package homework.chegg.com.chegghomework.Presentation.injection;

import dagger.Module;
import dagger.Provides;
import homework.chegg.com.chegghomework.Presentation.CheggContract;
import homework.chegg.com.chegghomework.Presentation.CheggContract.Presenter;
import homework.chegg.com.chegghomework.Presentation.CheggContract.View;
import homework.chegg.com.chegghomework.Presentation.CheggPresenter;

/**
 * Created by DanielR on 30/11/2017.
 */
@Module
public class CheggModule {

  CheggContract.View view;

  public CheggModule(View view) {
    this.view = view;
  }

  @Provides
  @ActivityScope
  public CheggContract.View provideView(){
    return view;
  }

  @Provides
  public Presenter provideCheggPresenter(CheggPresenter presenter){
    return presenter;
  }
}
