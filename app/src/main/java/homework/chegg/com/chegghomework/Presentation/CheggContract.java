package homework.chegg.com.chegghomework.Presentation;


import homework.chegg.com.chegghomework.base.BasePresenter;
import homework.chegg.com.chegghomework.base.BaseView;
import homework.chegg.com.chegghomework.data.entities.Item;
import java.util.List;

/**
 * Created by DanielR on 30/11/2017.
 */

public interface CheggContract {

  interface View extends BaseView<Presenter> {

    void showLoadingProgress();

    void hideLoadingProgress();

    void showUpdatedData(List<Item> itemList);
  }


  interface Presenter extends BasePresenter {

    void getDataUpdate();

    void refreshDataSourceA();

    void refreshDataSourceB();

    void refreshDataSourceC();  }
}
