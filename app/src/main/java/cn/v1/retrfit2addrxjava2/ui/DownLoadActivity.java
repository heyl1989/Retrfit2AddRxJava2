package cn.v1.retrfit2addrxjava2.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.v1.retrfit2addrxjava2.R;
import cn.v1.retrfit2addrxjava2.network_frame.GitHubAPIPackage;
import cn.v1.retrfit2addrxjava2.network_frame.core.BaseObserver;
import cn.v1.retrfit2addrxjava2.network_frame.core.ConnectHttp;
import cn.v1.retrfit2addrxjava2.network_frame.core.FileUtil;
import okhttp3.ResponseBody;

public class DownLoadActivity extends BaseActivity {

    @Bind(R.id.img_test)
    ImageView imgTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_down_load);
        ButterKnife.bind(this);
        initData();
    }


    /**
     * 下载文件
     */
    private void initData() {

        ConnectHttp.connect(GitHubAPIPackage.getcontributorsAvator(),
                new BaseObserver<ResponseBody>(context) {
                    @Override
                    public void onResponse(ResponseBody responseBody) {
                        FileUtil.writeResponseBodyToDisk(context, responseBody);
                        Glide.with(context).load("file://" + getExternalFilesDir(null) + File.separator + "Future Studio Icon.png").into(imgTest);
                    }
                });
    }

}
