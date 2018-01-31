package cn.v1.retrfit2addrxjava2.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import java.util.List;

import cn.v1.retrfit2addrxjava2.R;
import cn.v1.retrfit2addrxjava2.model.Contributor;
import cn.v1.retrfit2addrxjava2.model.WuLiuInfoData;
import cn.v1.retrfit2addrxjava2.network_frame.core.BaseObserver;
import cn.v1.retrfit2addrxjava2.network_frame.core.ConnectHttp;
import cn.v1.retrfit2addrxjava2.network_frame.GitHubAPIPackage;
import cn.v1.retrfit2addrxjava2.network_frame.WuLiuAPIPackage;
import cn.v1.retrfit2addrxjava2.network_frame.core.FileUtil;
import okhttp3.ResponseBody;

public class MainActivity extends Activity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        getRetrofitContributors();
    }

    private void getRetrofitContributors() {

        /**
         * 查询retrofit贡献者
         */
        ConnectHttp.connect(GitHubAPIPackage.getContributors("square", "retrofit"),
                new BaseObserver<List<Contributor>>(context) {
                    @Override
                    public void onResponse(List<Contributor> contributors) {

                    }
                });


        /**
         * 下载文件
         */
        ConnectHttp.connect(GitHubAPIPackage.getcontributorsAvator(),
                new BaseObserver<ResponseBody>(context) {
                    @Override
                    public void onResponse(ResponseBody responseBody) {
                        FileUtil.writeResponseBodyToDisk(context,responseBody);
                    }
                });


        /**
         * 查询快递单号
         */
        ConnectHttp.connect(WuLiuAPIPackage.getWuLiuInfo("yuantong", "11111111111"),
                new BaseObserver<WuLiuInfoData>(context)

                {
                    @Override
                    public void onResponse(WuLiuInfoData wuLiuInfoData) {

                    }
                });

    }

}
