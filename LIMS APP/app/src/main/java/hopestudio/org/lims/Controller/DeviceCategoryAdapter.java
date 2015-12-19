package hopestudio.org.lims.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hopestudio.org.lims.Controller.ViewHolder.DataDeviceCategoryViewHolder;
import hopestudio.org.lims.Controller.ViewHolder.DataNewsViewHolder;
import hopestudio.org.lims.Model.DataDeviceCategoryModel;
import hopestudio.org.lims.Model.DataNewsModel;
import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.19.
 */
public class DeviceCategoryAdapter extends RecyclerView.Adapter<DataDeviceCategoryViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<DataDeviceCategoryModel> dataList;

    public DeviceCategoryAdapter(Context context, List<DataDeviceCategoryModel> datas) {
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
    public DataDeviceCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 为ViewHolder指定Device Category的layout
        View view = mInflater.inflate(R.layout.list_item_device_category, parent, false);

        DataDeviceCategoryViewHolder viewHolder = new DataDeviceCategoryViewHolder(view);
        return viewHolder;
    }

    // 绑定ViewHolder
    @Override
    public void onBindViewHolder(final DataDeviceCategoryViewHolder holder, final int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();

        /*
        * 为ViewHolder设置子项目中数据与View的对应关系
        * deviceCategoryTitle：仪器分类
        * deviceCategoryCount：仪器分类下的仪器数量
        * */
        holder.itemView.setLayoutParams(layoutParams);
        holder.deviceCategoryTitle.setText(dataList.get(position).deviceCategoryTitle);
        holder.deviceCategoryCount.setText(dataList.get(position).deviceCategoryCount);

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