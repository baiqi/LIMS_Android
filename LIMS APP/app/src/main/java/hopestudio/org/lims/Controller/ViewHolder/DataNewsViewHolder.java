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
public class DataNewsViewHolder extends RecyclerView.ViewHolder {

    public TextView newsTitle;
    public TextView newsInfoDate;
    public TextView newsInfoAuthor;
    public TextView newsInfoTag;

    public DataNewsViewHolder(View itemView) {
        super(itemView);
        /*
        * 获取装载数据存放的View元素
        * newsTitle：文章标题
        * newsInfoDate：文章日期
        * newsInfoAuthor：文章作者
        * newsInfoTag：文章标签
        * */
        newsTitle = (TextView) itemView.findViewById(R.id.list_item_news_title);
        newsInfoDate = (TextView) itemView.findViewById(R.id.list_item_news_info_date);
        newsInfoAuthor = (TextView) itemView.findViewById(R.id.list_item_news_info_author);
        newsInfoTag = (TextView) itemView.findViewById(R.id.list_item_news_info_tag);
    }
}
