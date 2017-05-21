package quock.component;

import dagger.Component;
import quock.CustomScopeName;
import quock.module.MainModule;
import quock.mvpdagger.MainActivityFragment;

/**
 * Created by altaf.h.shaikh on 5/18/2017.
 */

@CustomScopeName //Need to be consistent with component scop
@Component(dependencies = NetComponent.class, modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivityFragment fragment);
}
