package hopestudio.org.lims.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hopestudio.org.lims.Model.DataNewsInfo;
import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.11.
 */
public class NewsAdapter extends RecyclerView.Adapter<personalCenterViewHolder> {

    private LayoutInflater inflater;
    private Context context;
    private List<DataNewsInfo> datas;
    private OnItemClickListener onItemClickListener;

    // RecyclerView中列表项的样式文件
    private final int newsRecyclerViewLayoutResId = R.layout.list_item_news_list;

    public NewsAdapter(Context context, List<DataNewsInfo> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    /*
    * 提供项目点击的事件监听接口
    * */
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

/*    public void addData(String<DataNewsInfo> insertOne, int position) {
        mDatas.add(insertOne);
        notifyItemInserted(position);
    }

    public void deleteData(int position) {
        mDatas.remove(position);
        notifyItemRemoved(position);
    }*/

    @Override
    public int getItemCount() {
        return datas.size();
    }

    // 创建ViewHolder
    @Override
    public personalCenterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(newsRecyclerViewLayoutResId, parent, false);
        personalCenterViewHolder viewHolder = new personalCenterViewHolder(view);
        return viewHolder;
    }

    // 绑定ViewHolder
    @Override
    public void onBindViewHolder(final personalCenterViewHolder holder, final int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        holder.itemView.setLayoutParams(layoutParams);

        /*
        * 为ViewHolder中的View绑定数据显示
        * */
        holder.newsTitle.setText(datas.get(position).newsTitle);
        holder.newsColumn.setText(datas.get(position).newsColumn);
        holder.newsTime.setText(datas.get(position).newsTime);
        holder.newsAuthor.setText(datas.get(position).newsAuthor);

        if(onItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, layoutPosition);
                }

            });
        }

        // longclick
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int layoutPosition = holder.getLayoutPosition();
                onItemClickListener.onItemLongClick(holder.itemView, layoutPosition);
                return false;
            }
        });
    }
}

/*
* 使用：
* */

/*
private RecyclerView rv;
private List<String> mDatas;
private mSimpleAdapter mAdapter;
private void initDatas() {
    mDatas = new ArrayList<String>();
    for(int i = 'A'; i <= 'z'; i++) {
        mDatas.add("" + (char)i);
    }

}
private void initViews() {
    rv = (RecyclerView) findViewById(R.id.recyclerView);
}

initDatas();

initViews();
mAdapter = new mSimpleAdapter(this, mDatas);
    rv.setAdapter(mAdapter);

    // 设置RecyclerView的布局管理
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
    rv.setLayoutManager(linearLayoutManager);

    // 设置RecyclerView动画
    rv.setItemAnimator(new DefaultItemAnimator());

    mAdapter.setOnItemClickListener(new mSimpleAdapter.OnItemClickListener() {
@Override
public void onItemClick(View view, int position) {
    Toast.makeText(MainActivity.this, "short Click: " + position + "", Toast.LENGTH_SHORT).show();
    }

@Override
public void onItemLongClick(View view, int position) {
    Toast.makeText(MainActivity.this, "long Click: " + position + "", Toast.LENGTH_SHORT).show();
    }
});



/*NewsBean newsBean;

jsonObject = new JSONObject(jsonString);
JSONArray jsonArray = jsonObject.getJSONArray("data");

*//*
* 逐行解析JSON数据
* *//*
for(int i = 0; i < jsonArray.length(); i++) {

jsonObject = jsonArray.getJSONObject(i);

newsBean = new NewsBean();

newsBean.newsTitle = jsonObject.getString("name");

newsBean.newsDate = jsonObject.getString("date");

newsBean.newsContent = jsonObject.getString("content");

newsBeanList.add(newsBean);
}*/