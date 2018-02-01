package cn.v1.retrfit2addrxjava2.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.v1.retrfit2addrxjava2.R;
import cn.v1.retrfit2addrxjava2.model.WuLiuInfoData;
import cn.v1.retrfit2addrxjava2.network_frame.WuLiuAPIPackage;
import cn.v1.retrfit2addrxjava2.network_frame.core.BaseObserver;
import cn.v1.retrfit2addrxjava2.network_frame.core.ConnectHttp;

public class WuLiuQueryActivity extends BaseActivity {

    @Bind(R.id.recycleview)
    RecyclerView recycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wu_liu_query);
        ButterKnife.bind(this);
        initData();
    }

    /**
     * 查询快递单号
     */
    private void initData() {

        ConnectHttp.connect(WuLiuAPIPackage.getWuLiuInfo("yuantong", "11111111111"),
                new BaseObserver<WuLiuInfoData>(context) {
                    @Override
                    public void onResponse(WuLiuInfoData wuLiuInfoData) {
                        if(TextUtils.equals("ok",wuLiuInfoData.getMessage())){
                            recycleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                            recycleview.setAdapter(new WuliuAdapter(wuLiuInfoData));
                        }else{
                            showTost(wuLiuInfoData.getMessage()+"");
                        }
                    }
                });
    }


    class WuliuAdapter extends RecyclerView.Adapter <WuliuAdapter.ViewHolder>{

        private WuLiuInfoData wuLiuInfoData;

        public WuliuAdapter(WuLiuInfoData wuLiuInfoData) {
            this.wuLiuInfoData = wuLiuInfoData;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder( LayoutInflater.from(context).inflate(R.layout.item_wuliu, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.tvInfo.setText(wuLiuInfoData.getData().get(position).getContext()
                    + "\n"
                    + wuLiuInfoData.getData().get(position).getTime());
        }

        @Override
        public int getItemCount() {
            return null != wuLiuInfoData.getData() ? wuLiuInfoData.getData().size() : 0;
        }

        class ViewHolder extends RecyclerView.ViewHolder{
            @Bind(R.id.tv_info)
            TextView tvInfo;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }

}
