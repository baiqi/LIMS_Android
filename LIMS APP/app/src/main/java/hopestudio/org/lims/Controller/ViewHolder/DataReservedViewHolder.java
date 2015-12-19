package hopestudio.org.lims.Controller.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.19.
 */ /*
* 声明“新闻公告”列表的内容页ViewHolder
* */
public class DataReservedViewHolder extends RecyclerView.ViewHolder {

    public ImageView reservedListPic;
    public TextView reservedListTitle;
    public TextView reservedListDuration;
    public TextView reservedListMoney;
    public TextView reservedListTimes;

    public DataReservedViewHolder(View itemView) {
        super(itemView);
        /*
        * 获取装载数据存放的View元素
        * reservingListPic：仪器图片
        * reservingListTitle：仪器名称
        * reservingListDuration：预约时长
        * reservingListMoney：总费用
        * reservingListTimes：预约时间段
        * */
        reservedListPic = (ImageView) itemView.findViewById(R.id.list_item_reserved_pic);
        reservedListTitle = (TextView) itemView.findViewById(R.id.list_item_reserved_title);
        reservedListDuration = (TextView) itemView.findViewById(R.id.list_item_reserved_duration);;
        reservedListMoney = (TextView) itemView.findViewById(R.id.list_item_reserved_money);;
        reservedListTimes = (TextView) itemView.findViewById(R.id.list_item_reserved_times);
    }
}
