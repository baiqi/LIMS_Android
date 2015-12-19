package hopestudio.org.lims.Controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import hopestudio.org.lims.Controller.ViewHolder.DataReservedViewHolder;
import hopestudio.org.lims.Controller.ViewHolder.DataReservingViewHolder;
import hopestudio.org.lims.Model.DataReservedListModel;
import hopestudio.org.lims.Model.DataReservingListModel;
import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.19.
 */
public class ReservedAdapter extends RecyclerView.Adapter<DataReservedViewHolder> {

    private LayoutInflater mInflater;
    private Context context;
    private List<DataReservedListModel> dataList;

    public ReservedAdapter(Context context, List<DataReservedListModel> datas) {
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
    public DataReservedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.list_item_reserved, parent, false);

        DataReservedViewHolder viewHolder = new DataReservedViewHolder(view);
        return viewHolder;
    }

    // 绑定ViewHolder
    @Override
    public void onBindViewHolder(final DataReservedViewHolder holder, final int position) {
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
        holder.reservedListPic.setImageResource(dataList.get(position).reservedListPic);
        holder.reservedListTitle.setText(dataList.get(position).reservedListTitle);
        holder.reservedListDuration.setText(dataList.get(position).reservedListDuration);
        holder.reservedListMoney.setText(dataList.get(position).reservedListMoney);
        holder.reservedListTimes.setText(dataList.get(position).reservedListTimes);

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