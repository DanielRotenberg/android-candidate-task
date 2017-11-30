package homework.chegg.com.chegghomework.injection.module;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by dr9874 on 30/11/2017.
 */
@Module
public class ApplicationModule {

    Context cheggApplicationContext;

    public ApplicationModule(Context cheggApplicationContext) {
        this.cheggApplicationContext = cheggApplicationContext;
    }

    @Provides
    @Singleton
    Context provideApplication() {
        return cheggApplicationContext;
    }
}
