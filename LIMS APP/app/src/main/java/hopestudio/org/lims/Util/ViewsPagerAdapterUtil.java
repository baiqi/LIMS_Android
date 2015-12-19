package hopestudio.org.lims.Util;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by dengzhirong on 15.11.29.
 */
public class ViewsPagerAdapterUtil extends PagerAdapter {
    private List<View> viewList;

    public ViewsPagerAdapterUtil(List<View> viewList) {
        this.viewList = viewList;
    }
    
    /*
    * 返回页卡数量
    * */
    @Override
    public int getCount() {
        return viewList.size();
    }

    /*
    * View是否来自于对象
    * */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    /*
    * 实例化一个页卡
    * */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    /*
    * 销毁一个页卡
    * */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(viewList.get(position));
    }
}
