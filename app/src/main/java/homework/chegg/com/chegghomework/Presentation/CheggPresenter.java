package homework.chegg.com.chegghomework.Presentation;

import android.util.Log;
import homework.chegg.com.chegghomework.Presentation.CheggContract.View;

import homework.chegg.com.chegghomework.data.CheggRepository;
import javax.inject.Inject;

/**
 * Created by DanielR on 30/11/2017.
 */

public class CheggPresenter implements CheggContract.Presenter {

  CheggContract.View view;
  CheggRepository cheggRepository;

  @Inject
  public CheggPresenter(View view, CheggRepository cheggRepository) {
    this.view = view;
    this.cheggRepository = cheggRepository;
  }

  @Override
  public void subscribe() {
    Log.d("jira", "subscribe: called");
    view.showLoadingProgress();
  }

  @Override
  public void unSubscribe() {

  }

  @Override
  public void getDataUpdate() {

  }
}
