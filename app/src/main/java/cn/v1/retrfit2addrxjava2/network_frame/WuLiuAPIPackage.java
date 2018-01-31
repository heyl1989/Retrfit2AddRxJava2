package cn.v1.retrfit2addrxjava2.network_frame;

import cn.v1.retrfit2addrxjava2.model.WuLiuInfoData;
import cn.v1.retrfit2addrxjava2.network_frame.core.ConnectHttp;
import io.reactivex.Observable;

/**
 * Created by qy on 2018/1/31.
 */

public class WuLiuAPIPackage {
    /**
     * 获取物流订单信息
     * @param type
     * @param postid
     * @return
     */
    public static Observable<WuLiuInfoData> getWuLiuInfo(String type, String postid) {
        return ConnectHttp.getWuLiuAPI().getWuLiuInfo(type, postid);
    }

}
