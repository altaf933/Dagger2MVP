package quock;

import android.app.Application;

import quock.component.DaggerNetComponent;
import quock.component.NetComponent;
import quock.module.AppModule;
import quock.module.NetModule;

/**
 * Created by altaf.h.shaikh on 5/17/2017.
 */

public class MyApplication extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerNetComponent.builder().
                appModule(new AppModule(this)).
                netModule(new NetModule("https://api.github.com")).build();
    }

    public NetComponent getmNetComponent() {
        if (mNetComponent != null)
            return mNetComponent;
        else
            return null;
   }
}
