package cn.v1.retrfit2addrxjava2.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.v1.retrfit2addrxjava2.R;
import cn.v1.retrfit2addrxjava2.model.Contributor;
import cn.v1.retrfit2addrxjava2.network_frame.GitHubAPIImpl;
import cn.v1.retrfit2addrxjava2.network_frame.core.BaseObserver;
import cn.v1.retrfit2addrxjava2.network_frame.core.ConnectHttp;

public class RetrofitContributionsActivity extends BaseActivity {


    @Bind(R.id.recycleview)
    RecyclerView recycleview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_contributions);
        ButterKnife.bind(this);
        initData();
    }

    /**
     * 查询retrofit贡献者
     */
    private void initData() {

        ConnectHttp.connect(new GitHubAPIImpl().getContributors("square", "retrofit"),
                new BaseObserver<List<Contributor>>(context) {
                    @Override
                    public void onResponse(List<Contributor> contributors) {
                        recycleview.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
                        recycleview.setAdapter(new ContributorsAdapter(contributors));
                    }
                });
    }


    class ContributorsAdapter extends RecyclerView.Adapter<ContributorsAdapter.ViewHolder> {

        private List<Contributor> datas = new ArrayList<>();

        public ContributorsAdapter(List<Contributor> contributors) {
            this.datas = contributors;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_contributors, null));
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            Glide.with(context).load(datas.get(position).getAvatarUrl()).into(holder.imgAvator);
            holder.tvName.setText(datas.get(position).getLogin());
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            @Bind(R.id.img_avator)
            ImageView imgAvator;
            @Bind(R.id.tv_name)
            TextView tvName;

            ViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }
    }


}
