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
public class DataReservingViewHolder extends RecyclerView.ViewHolder {


    public ImageView reservingListPic;
    public TextView reservingListTitle;
    public TextView reservingListDuration;
    public TextView reservingListMoney;
    public TextView reservingListTimes;

    public DataReservingViewHolder(View itemView) {
        super(itemView);
        /*
        * 获取装载数据存放的View元素
        * reservingListPic：仪器图片
        * reservingListTitle：仪器名称
        * reservingListDuration：预约时长
        * reservingListMoney：总费用
        * reservingListTimes：预约时间段
        * */
        reservingListPic = (ImageView) itemView.findViewById(R.id.list_item_reserving_pic);
        reservingListTitle = (TextView) itemView.findViewById(R.id.list_item_reserving_title);
        reservingListDuration = (TextView) itemView.findViewById(R.id.list_item_reserving_duration);;
        reservingListMoney = (TextView) itemView.findViewById(R.id.list_item_reserving_money);;
        reservingListTimes = (TextView) itemView.findViewById(R.id.list_item_reserving_times);
    }
}
