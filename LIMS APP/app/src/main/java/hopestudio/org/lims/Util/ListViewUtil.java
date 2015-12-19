package hopestudio.org.lims.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dengzhirong on 15.12.10.
 */
public class ListViewUtil {

}

/*
* 将JSON数据返回值传递给BaseAdapter
* */
class NewsAdapter extends BaseAdapter {

    // 声明用于装载JSON数据返回值
    private List<NewsBean> mList;

    // 声明Inflater，用于将Layout转为View
    private LayoutInflater mInflater;

    private int itemLayoutResId;

    /*
    *  将JSON返回的数据传递给BaseAdapter
    * */
    public NewsAdapter(Context context, List<NewsBean> data, int itemLayoutResId) {
        this.mList = data;
        this.mInflater = LayoutInflater.from(context);
        this.itemLayoutResId = itemLayoutResId;
    }

    /*
    * 返回ListView中Adapter的数据长度
    * */
    @Override
    public int getCount() {
        return mList.size();
    }

    /*
    * 返回当前索引Adapter数据
    * */
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    /*
    * 返回当前Adapter数据的索引
    * */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
    * 更改当前ListView
    * */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
        * 为ListView中的数据定义装载的View容器
        * */
        ViewHolder viewHolder = null;
        if(convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(itemLayoutResId, null);

/*            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tvDate = (TextView) convertView.findViewById(R.id.tv_date);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);*/

            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /*
        * 将Adapter中的数据添加到View容器中
        * */
        viewHolder.tvDate.setText(mList.get(position).newsDate);
        viewHolder.tvTitle.setText(mList.get(position).newsTitle);
        viewHolder.tvContent.setText(mList.get(position).newsContent);

        return convertView;
    }

    /*
    * 定义Adapter数据类型
    * */
    class ViewHolder {
        public TextView tvTitle, tvContent, tvDate;
    }
}

/*
* 声明用JSON获取的数据源
* */
class NewsBean {
    public String newsTitle;
    public String newsDate;
    public String newsContent;
}