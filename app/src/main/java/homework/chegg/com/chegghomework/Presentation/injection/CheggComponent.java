package homework.chegg.com.chegghomework.Presentation.injection;

import dagger.Component;
import homework.chegg.com.chegghomework.Presentation.CheggActivity;
import homework.chegg.com.chegghomework.injection.component.GlobalComponent;


/**
 * Created by DanielR on 30/11/2017.
 */
@ActivityScope
@Component(modules = CheggModule.class, dependencies = GlobalComponent.class)
public interface CheggComponent {

  void inject(CheggActivity cheggActivity);

}
