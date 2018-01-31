package cn.v1.retrfit2addrxjava2.network_frame.core;

import cn.v1.retrfit2addrxjava2.network_frame.GitHubAPI;
import cn.v1.retrfit2addrxjava2.network_frame.WuLiuAPI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by qy on 2018/1/31.
 */

public class ConnectHttp<T> {

    //创建 GitHub API 接口的一个实例。
    public static GitHubAPI getGitHubAPI() {
        return RetrofitConfigure.githubRetrofit.create(GitHubAPI.class);
    }

    //创建  WuLiu API 口的一个实例。
    public static WuLiuAPI getWuLiuAPI() {
        return RetrofitConfigure.wuLiuRetrofit.create(WuLiuAPI.class);
    }

    //创建  WuLiu API 口的一个实例。
    public static GitHubAPI getPictureAPI() {
        return RetrofitConfigure.pictureRetrofit.create(GitHubAPI.class);
    }

    /**
     * 连接网络
     * @param observable
     * @param baseObserver
     */
    public static <T> void connect(Observable<T> observable, BaseObserver<T> baseObserver) {
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((baseObserver));
    }
}
