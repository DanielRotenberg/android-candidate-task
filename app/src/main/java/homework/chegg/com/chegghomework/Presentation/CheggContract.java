package homework.chegg.com.chegghomework.Presentation;


import homework.chegg.com.chegghomework.base.BasePresenter;
import homework.chegg.com.chegghomework.base.BaseView;

/**
 * Created by DanielR on 30/11/2017.
 */

public interface CheggContract {

  interface View extends BaseView<Presenter> {

    void showLoadingProgress();

    void hideLoadingProgress();

    void showUpdatedData();
  }


  interface Presenter extends BasePresenter {

    void getDataUpdate();


  }
}
