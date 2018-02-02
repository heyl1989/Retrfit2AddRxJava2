package cn.v1.retrfit2addrxjava2.network_frame;

import java.util.List;
import cn.v1.retrfit2addrxjava2.model.Contributor;
import cn.v1.retrfit2addrxjava2.network_frame.core.ConnectHttp;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * Created by qy on 2018/1/31.
 */

public class GitHubAPIImpl implements GitHubAPI {

    /**
     * 获取GitHub仓库贡献者
     *
     * @param owner 仓库所有者
     * @param repo  仓库名称
     * @return  Observable
     */
    @Override
    public Observable<List<Contributor>> getContributors(@Path("owner") String owner, @Path("repo") String repo) {
        return ConnectHttp.getGitHubAPI().getContributors(owner, repo);
    }

    /**
     * 下载头像
     *
     * @return void
     */
    @Override
    public Observable<ResponseBody> getcontributorsAvator() {
        return ConnectHttp.getPictureAPI().getcontributorsAvator();
    }

    @Override
    public Observable<ResponseBody> downloadFileWithDynamicUrlAsync(@Url String fileUrl) {
        return null;
    }
}
