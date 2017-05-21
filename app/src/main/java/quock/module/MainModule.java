package quock.module;

import dagger.Module;
import dagger.Provides;
import quock.CustomScopeName;
import quock.view.IMainFragment;

/**
 * Created by altaf.h.shaikh on 5/19/2017.
 */

@Module
public class MainModule {

    private final IMainFragment.View mView;

    public MainModule(IMainFragment.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScopeName
    IMainFragment.View provideMainView() {
        return mView;
    }
}
