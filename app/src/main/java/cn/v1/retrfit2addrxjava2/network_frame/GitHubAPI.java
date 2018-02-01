package cn.v1.retrfit2addrxjava2.network_frame;

import java.util.List;

import cn.v1.retrfit2addrxjava2.model.Contributor;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by qy on 2018/1/31.
 */

public interface GitHubAPI {

    //https://api.github.com/repos/square/retrofit/contributors
    @GET("/repos/{owner}/{repo}/contributors")
    Observable<List<Contributor>> getContributors(@Path("owner") String owner,
                                                  @Path("repo") String repo);

    @GET("/timg?image&quality=80&size=b9999_10000&sec=1517483557140&di=8ef2706c558749c2c9ae999e4401651d&imgtype=0&src=http%3A%2F%2Fimg5.niutuku.com%2Fphone%2F1301%2F5651%2F5651-niutuku.com-446980.jpg")
    Observable<ResponseBody> getcontributorsAvator();

    // !!! 当心大文件，当是大文件时
    @Streaming
    @GET
    Observable<ResponseBody> downloadFileWithDynamicUrlAsync(@Url String fileUrl);

}
