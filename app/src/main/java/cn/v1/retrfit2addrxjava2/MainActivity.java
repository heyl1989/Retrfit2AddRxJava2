package cn.v1.retrfit2addrxjava2;

import android.app.Activity;
import android.os.Bundle;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final long TIMEOUT = 30;

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    System.out.println(message);
                }
            }).setLevel(HttpLoggingInterceptor.Level.BASIC))
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build();

    private void retrfitTest() throws IOException {
        //创建一个非常简单的指向GitHub API的REST适配器。
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        //创建我们的GitHub API接口的一个实例。
        GitHub github = retrofit.create(GitHub.class);
        //创建一个调用实例来查找Retrofit贡献者。
        Observable<List<Contributor>> observable = github.getContributors("square", "retrofit");
        observable
                .compose(new ObservableTransformer<List<Contributor>, List<Contributor>>() {

                    @Override
                    public ObservableSource<List<Contributor>> apply(@NonNull Observable<List<Contributor>> observable) {
                        return observable
                                .subscribeOn(Schedulers.io())
                                .doOnSubscribe(new Consumer<Disposable>() {
                                    @Override
                                    public void accept(Disposable disposable) throws Exception {
                                        System.out.println(disposable.isDisposed() + "");
                                    }
                                })
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                })
                .subscribe(new Observer<List<Contributor>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Contributor> contributors) {
                        System.out.println(new Gson().toJson(contributors));
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println(new Gson().toJson(e));
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("已完成");
                    }
                });


    }

    class Contributor {
        public final String login;
        public final int contributions;

        public Contributor(String login, int contributions) {
            this.login = login;
            this.contributions = contributions;
        }
    }

    //https://api.github.com/repos/square/retrofit/contributors
    private final String API_URL = "https://api.github.com";

    interface GitHub {
        @GET("/repos/{owner}/{repo}/contributors")
        Observable<List<Contributor>> getContributors(@Path("owner") String owner,
                                                      @Path("repo") String repo);
    }
}
