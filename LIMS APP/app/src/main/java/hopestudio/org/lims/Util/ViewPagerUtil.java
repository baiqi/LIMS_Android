package hopestudio.org.lims.Util;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import java.util.ArrayList;

import hopestudio.org.lims.DeviceListFragment;
import hopestudio.org.lims.LessonFragment;
import hopestudio.org.lims.NewsListFragment;
import hopestudio.org.lims.PersonFragment;
import hopestudio.org.lims.R;
import hopestudio.org.lims.ReserveFragment;

/**
 * Created by dengzhirong on 15.12.10.
 */
public abstract class ViewPagerUtil {

    // 当前Page的点击事件
    public abstract void changeOnPageSelected(int currentItem);

    /*
    * 生成一个RecyclerViewGenerator
    * */

    public ViewPagerUtil(final ArrayList<Fragment> fragmentsList,
                              final ViewPager viewPager,
                         FragmentManager fragmentManager) {



        // 创建ViewPager的Adapter
        FragmentPagerAdapter pagerAdapter = new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return fragmentsList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentsList.size();
            }
        };

       // 为ViewPager加载适配器
        viewPager.setAdapter(pagerAdapter);

        // 为ViewPager添加滑屏事件
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            // 当前页时，切换图标
            @Override
            public void onPageSelected(int position) {
                int currentItem = viewPager.getCurrentItem();
                 changeOnPageSelected(currentItem);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }
}


