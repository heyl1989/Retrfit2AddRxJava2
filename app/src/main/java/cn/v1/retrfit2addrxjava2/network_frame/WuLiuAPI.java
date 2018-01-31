package cn.v1.retrfit2addrxjava2.network_frame;

import java.util.List;

import cn.v1.retrfit2addrxjava2.model.Contributor;
import cn.v1.retrfit2addrxjava2.model.WuLiuInfoData;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by qy on 2018/1/31.
 */

public interface WuLiuAPI {

    @FormUrlEncoded
    @POST("/query")
    Observable<WuLiuInfoData> getWuLiuInfo(@Field("type") String type, @Field("postid") String postid);

}
