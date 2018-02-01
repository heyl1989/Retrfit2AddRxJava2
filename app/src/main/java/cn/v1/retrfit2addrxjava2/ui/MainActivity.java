package cn.v1.retrfit2addrxjava2.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.v1.retrfit2addrxjava2.R;
import cn.v1.retrfit2addrxjava2.model.Contributor;
import cn.v1.retrfit2addrxjava2.model.WuLiuInfoData;
import cn.v1.retrfit2addrxjava2.network_frame.GitHubAPIPackage;
import cn.v1.retrfit2addrxjava2.network_frame.WuLiuAPIPackage;
import cn.v1.retrfit2addrxjava2.network_frame.core.BaseObserver;
import cn.v1.retrfit2addrxjava2.network_frame.core.ConnectHttp;
import cn.v1.retrfit2addrxjava2.network_frame.core.FileUtil;
import okhttp3.ResponseBody;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tv_github, R.id.tv_wuliu, R.id.tv_download})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_github:
                goNewActivity(RetrofitContributionsActivity.class);
                break;
            case R.id.tv_wuliu:
                goNewActivity(WuLiuQueryActivity.class);
                break;
            case R.id.tv_download:
                goNewActivity(DownLoadActivity.class);
                break;
        }
    }


}
