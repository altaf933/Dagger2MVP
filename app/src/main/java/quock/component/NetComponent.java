package quock.component;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import quock.module.AppModule;
import quock.module.NetModule;
import retrofit2.Retrofit;

/**
 * Created by altaf.h.shaikh on 5/17/2017.
 */

    @Singleton
    @Component(modules = {AppModule.class, NetModule.class})
    public interface NetComponent {
        Retrofit retrofit();
        OkHttpClient okkOkHttpClient();
    }

