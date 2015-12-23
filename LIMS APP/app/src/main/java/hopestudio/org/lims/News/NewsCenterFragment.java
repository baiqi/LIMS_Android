package hopestudio.org.lims.News;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hopestudio.org.lims.Controller.NewsAdapter;
import hopestudio.org.lims.Model.DataNewsModel;
import hopestudio.org.lims.R;
import hopestudio.org.lims.Util.DividerItemDecoration;

/**
 * Created by dengzhirong on 15.12.18.
 */

public class NewsCenterFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private List<DataNewsModel> dataList;
    private NewsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View newsCenterView = inflater.inflate(R.layout.fragment_news_newscenter, container, false);

        // 获取RecyclerView的元素对象
        recyclerView = (RecyclerView) newsCenterView.findViewById(R.id.news_center_recyclerView);

        // 填充数据源
        dataList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            DataNewsModel newsBean = new DataNewsModel();
            newsBean.newsTitle = "新闻中心" + i;
            newsBean.newsInfoDate = "2015-12-16";
            newsBean.newsInfoAuthor = "小凳子";
            newsBean.newsInfoTag = "安全";
            dataList.add(newsBean);
        }

        // 为Adapter填充数据源
        adapter = new NewsAdapter(this.getActivity(), dataList);

        // 为recyclerView设置Adapter
        recyclerView.setAdapter(adapter);

        // 设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // 为RecyclerView添加分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(this.getActivity(), DividerItemDecoration.VERTICAL_LIST));

        // 设置RecyclerView动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // 为每个Item设置点击事件
        adapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Toast.makeText(NewsCenterFragment.this.getActivity(), "short Click: " + position + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        // 返回Fragment的View对象
        return newsCenterView;
    }
}
