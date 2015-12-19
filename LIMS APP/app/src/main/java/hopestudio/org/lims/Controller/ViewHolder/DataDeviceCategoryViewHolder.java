package hopestudio.org.lims.Controller.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.19.
 */ /*
* 声明“新闻公告”列表的内容页ViewHolder
* */
public class DataDeviceCategoryViewHolder extends RecyclerView.ViewHolder {

    public TextView deviceCategoryTitle;
    public TextView deviceCategoryCount;

    public DataDeviceCategoryViewHolder(View itemView) {
        super(itemView);
        /*
        * 获取装载数据存放的View元素
        * deviceCategoryTitle：仪器分类
        * deviceCategoryCount：分类下的仪器数量
        * */
        deviceCategoryTitle = (TextView) itemView.findViewById(R.id.list_item_device_category_title);
        deviceCategoryCount = (TextView) itemView.findViewById(R.id.list_item_device_category_count);
    }
}
