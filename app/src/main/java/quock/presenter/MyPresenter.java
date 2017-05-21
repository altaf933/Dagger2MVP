package quock.presenter;

import android.util.Log;

import java.util.ArrayList;

import javax.inject.Inject;

import quock.Repository;
import quock.view.IMainFragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by altaf.h.shaikh on 5/17/2017.
 */

public class MyPresenter implements IMainFragment.Presenter {
    Retrofit retrofit;
    IMainFragment.View mView;

    @Inject
    public MyPresenter(Retrofit retrofit, IMainFragment.View view) {
        this.retrofit = retrofit;
        this.mView = view;
    }

    @Override
    public void loadData() {
        GitHubApiInterface github = retrofit.create(GitHubApiInterface.class);
        github.getRepository("altaf933")
                .enqueue(new Callback<ArrayList<Repository>>() {
            @Override
            public void onResponse
                    (Call<ArrayList<Repository>> call,
                      Response<ArrayList<Repository>> response) {

                ArrayList<Repository> body = response.body();
                for (int i = 0; i < body.size(); i++) {
                    Log.d("response", body.get(i).getName());
                }
            }
            @Override
            public void onFailure
                    (Call<ArrayList<Repository>> call, Throwable t) {
            }
        });
    }

    public interface GitHubApiInterface {
        @GET("/users/{users}/repos")
        Call<ArrayList<Repository>> getRepository(@Path("users") String orgName);
    }
}
