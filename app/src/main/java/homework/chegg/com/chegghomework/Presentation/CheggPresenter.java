package homework.chegg.com.chegghomework.Presentation;

import android.util.Log;
import homework.chegg.com.chegghomework.Presentation.CheggContract.View;

import homework.chegg.com.chegghomework.data.CheggRepository;
import homework.chegg.com.chegghomework.data.entities.Item;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by DanielR on 30/11/2017.
 */

public class CheggPresenter implements CheggContract.Presenter {

  private CompositeDisposable subscriptions = new CompositeDisposable();
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
    Observable<List<Item>> listObservable = cheggRepository.fetchDataFromMultipleSources();
    Disposable disposable = listObservable.subscribe(
        next -> Log.d("jira", "subscribe:YESSS "+next.size()),
        throwable -> Log.e("jira1", "subscribe: error "+throwable.getMessage() ));

    subscriptions.add(disposable);

    view.showLoadingProgress();
  }

  @Override
  public void unSubscribe() {

  }

  @Override
  public void getDataUpdate() {

  }
}
