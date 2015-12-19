package hopestudio.org.lims.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hopestudio.org.lims.Controller.ViewHolder.DataDeviceListViewHolder;
import hopestudio.org.lims.Controller.ViewHolder.DataReservingViewHolder;
import hopestudio.org.lims.Model.DataDeviceListModel;
import hopestudio.org.lims.Model.DataReservingListModel;
import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.19.
 */
public class ReservingAdapter extends RecyclerView.Adapter<DataReservingViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<DataReservingListModel> dataList;

    public ReservingAdapter(Context context, List<DataReservingListModel> datas) {
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
    public DataReservingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item_reserving, parent, false);

        DataReservingViewHolder viewHolder = new DataReservingViewHolder(view);
        return viewHolder;
    }

    // 绑定ViewHolder
    @Override
    public void onBindViewHolder(final DataReservingViewHolder holder, final int position) {
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();

        /*
        * reservingListPic：仪器图片
        * reservingListTitle：仪器名称
        * reservingListDuration：预约时长
        * reservingListMoney：总费用
        * reservingListTimes：预约时间段
        * reservingListChangeTimeBtn：更改预约时间
        * reservingListCancel：取消预约
        * */
        holder.itemView.setLayoutParams(layoutParams);
        holder.reservingListPic.setImageResource(dataList.get(position).reservingListPic);
        holder.reservingListTitle.setText(dataList.get(position).reservingListTitle);
        holder.reservingListDuration.setText(dataList.get(position).reservingListDuration);
        holder.reservingListMoney.setText(dataList.get(position).reservingListMoney);
        holder.reservingListTimes.setText(dataList.get(position).reservingListTimes);

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