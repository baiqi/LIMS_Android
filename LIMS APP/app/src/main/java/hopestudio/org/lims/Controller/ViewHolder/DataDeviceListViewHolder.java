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
public class DataDeviceListViewHolder extends RecyclerView.ViewHolder {

    public ImageView deviceListPic;
    public TextView deviceListTitle;
    public TextView deviceListModel;
    public TextView deviceListReservedBtn;
    public TextView deviceListReservingBtn;

    public DataDeviceListViewHolder(View itemView) {
        super(itemView);
        /*
        * 获取装载数据存放的View元素
        * deviceListPic：仪器图片
        * deviceListTitle：仪器名称
        * deviceListModel：仪器型号
        * deviceListReservedBtn：仪器预约记录按钮
        * deviceListReservingBtn：仪器预约按钮
        * */
        deviceListPic = (ImageView) itemView.findViewById(R.id.list_item_device_pic);
        deviceListTitle = (TextView) itemView.findViewById(R.id.list_item_device_title);
        deviceListModel = (TextView) itemView.findViewById(R.id.list_item_device_model);;
        deviceListReservedBtn = (TextView) itemView.findViewById(R.id.list_item_device_reserved_log);;
        deviceListReservingBtn = (TextView) itemView.findViewById(R.id.list_item_device_reserving);
    }
}
