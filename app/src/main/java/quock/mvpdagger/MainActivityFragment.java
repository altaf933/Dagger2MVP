package quock.mvpdagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import quock.MyApplication;
import quock.component.DaggerMainComponent;
import quock.module.MainModule;
import quock.presenter.MyPresenter;
import quock.view.IMainFragment;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment
        extends Fragment implements IMainFragment.View {

    @Inject
    MyPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerMainComponent.builder().
                netComponent(((MyApplication) this.getActivity().
                        getApplicationContext()).getmNetComponent()).
                mainModule(new MainModule(this)).build().inject(this);

        presenter.loadData();
    }

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public boolean isShow() {
        return false;
    }

    @Override
    public boolean isHide() {
        return false;
    }
}
