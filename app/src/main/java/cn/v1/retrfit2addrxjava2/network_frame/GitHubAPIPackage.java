package cn.v1.retrfit2addrxjava2.network_frame;

import java.util.List;

import cn.v1.retrfit2addrxjava2.model.Contributor;
import cn.v1.retrfit2addrxjava2.network_frame.core.ConnectHttp;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Path;

/**
 * Created by qy on 2018/1/31.
 */

public class GitHubAPIPackage {

    /**
     * 获取GitHub仓库贡献者
     *
     * @param owner
     * @param repo
     * @return
     */
    public static Observable<List<Contributor>> getContributors(String owner, String repo) {
        return ConnectHttp.getGitHubAPI().getContributors(owner, repo);
    }


    /**
     * 下载头像
     * @return
     */
    public static Observable<ResponseBody> getcontributorsAvator() {
        return ConnectHttp.getPictureAPI().getcontributorsAvator();
    }
}
