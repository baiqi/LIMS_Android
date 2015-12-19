package hopestudio.org.lims.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hopestudio.org.lims.Controller.ViewHolder.DataNewsViewHolder;
import hopestudio.org.lims.Model.DataNewsModel;
import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.19.
 */
public class NewsAdapter extends RecyclerView.Adapter<DataNewsViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<DataNewsModel> dataList;

    public NewsAdapter(Context context, List<DataNewsModel> datas) {
        this.context = context;
        this.dataList = datas;
        mInflater = LayoutInflater.from(context);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    // 创建ViewHolder
    @Override
    public DataNewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.list_item_news_list, parent, false);
        DataNewsViewHolder viewHolder = new DataNewsViewHolder(view);
        return viewHolder;
    }

    // 绑定ViewHolder
    @Override
    public void onBindViewHolder(final DataNewsViewHolder holder, final int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();

        /*
        * 为ViewHolder设置子项目中数据与View的对应关系
        * newsTitle：文章标题
        * newsInfoDate：文章日期
        * newsInfoAuthor：文章作者
        * newsInfoTag：文章标签
        * */
        holder.itemView.setLayoutParams(layoutParams);
        holder.newsTitle.setText(dataList.get(position).newsTitle);
        holder.newsInfoDate.setText(dataList.get(position).newsInfoDate);
        holder.newsInfoAuthor.setText(dataList.get(position).newsInfoAuthor);
        holder.newsInfoTag.setText(dataList.get(position).newsInfoTag);

        if(mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, layoutPosition);
                }

            });

            // longclick
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int layoutPosition = holder.getLayoutPosition();
                    mOnItemClickListener.onItemLongClick(holder.itemView, layoutPosition);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}