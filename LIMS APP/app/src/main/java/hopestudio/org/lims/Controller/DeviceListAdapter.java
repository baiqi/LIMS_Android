package hopestudio.org.lims.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hopestudio.org.lims.Controller.ViewHolder.DataDeviceListViewHolder;
import hopestudio.org.lims.Controller.ViewHolder.DataNewsViewHolder;
import hopestudio.org.lims.Model.DataDeviceListModel;
import hopestudio.org.lims.Model.DataNewsModel;
import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.19.
 */
public class DeviceListAdapter extends RecyclerView.Adapter<DataDeviceListViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<DataDeviceListModel> dataList;

    public DeviceListAdapter(Context context, List<DataDeviceListModel> datas) {
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
    public DataDeviceListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item_device_list, parent, false);

        DataDeviceListViewHolder viewHolder = new DataDeviceListViewHolder(view);
        return viewHolder;
    }

    // 绑定ViewHolder
    @Override
    public void onBindViewHolder(final DataDeviceListViewHolder holder, final int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();

        /*
        * 为ViewHolder设置子项目中数据与View的对应关系
        * deviceListPic：仪器图片
        * deviceListTitle：仪器名称
        * deviceListModel：仪器型号
        * deviceListReservedBtn：仪器预约记录按钮
        * deviceListReservingBtn：仪器预约按钮
        * */
        holder.itemView.setLayoutParams(layoutParams);
        holder.deviceListPic.setImageResource(dataList.get(position).deviceListPic);
        holder.deviceListTitle.setText(dataList.get(position).deviceListTitle);
        holder.deviceListModel.setText(dataList.get(position).deviceListModel);

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