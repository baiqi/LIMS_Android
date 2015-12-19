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
public class DataPersonListViewHolder extends RecyclerView.ViewHolder {

    public TextView personCenterTitle;

    public DataPersonListViewHolder(View itemView) {
        super(itemView);
        /*
        * 获取装载数据存放的View元素
        * deviceCategoryTitle：项目标题
        * */
        personCenterTitle = (TextView) itemView.findViewById(R.id.list_item_person_title);
    }
}
