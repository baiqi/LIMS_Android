package hopestudio.org.lims;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hopestudio.org.lims.Device.StarFragment;
import hopestudio.org.lims.Device.TotalFragment;
import hopestudio.org.lims.Device.UsualFragment;
import hopestudio.org.lims.News.NewsCenterFragment;
import hopestudio.org.lims.News.RuleFragment;
import hopestudio.org.lims.News.ServiceFragment;
import hopestudio.org.lims.News.StructFragment;
import hopestudio.org.lims.Util.ViewPagerUtil;

/**
 * Created by dengzhirong on 15.11.29.
 */
public class DeviceListFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentsList;
    private View newsCategoryView;
    private FragmentManager fragmentManager;

    private TextView deviceTotalBtn;
    private TextView deviceUsualBtn;
    private TextView deviceStarBtn;

    public DeviceListFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        newsCategoryView = inflater.inflate(R.layout.activity_device_list, container, false);

        deviceTotalBtn = (TextView) newsCategoryView.findViewById(R.id.tab_device_total);
        deviceUsualBtn = (TextView) newsCategoryView.findViewById(R.id.tab_device_usual);
        deviceStarBtn = (TextView) newsCategoryView.findViewById(R.id.tab_device_star);

        deviceTotalBtn.setOnClickListener(this);
        deviceUsualBtn.setOnClickListener(this);
        deviceStarBtn.setOnClickListener(this);

        viewPager = (ViewPager) newsCategoryView.findViewById(R.id.device_category_viewPager);

        // 数据填充
        fragmentsList = new ArrayList<Fragment>();
        Fragment fragmentTotal = new TotalFragment(fragmentManager);
        Fragment fragmentUsual = new UsualFragment();
        Fragment fragmentStar = new StarFragment();

        fragmentsList.add(fragmentTotal);
        fragmentsList.add(fragmentUsual);
        fragmentsList.add(fragmentStar);

        ViewPagerUtil viewPagerUtil = new ViewPagerUtil(fragmentsList, viewPager, fragmentManager) {
            @Override
            public void changeOnPageSelected(int currentItem) {

                // 将字体颜色恢复
                initTab();

                switch(currentItem) {
                    case 0:
                        deviceTotalBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                    case 1:
                        deviceUsualBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                    case 2:
                        deviceStarBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                }
            }
        };

        // 返回Fragment的View对象
        return newsCategoryView;
    }

    // 恢复Tab hover前的状态
    private void initTab() {
        deviceTotalBtn.setTextColor(Color.parseColor("#666666"));
        deviceUsualBtn.setTextColor(Color.parseColor("#666666"));
        deviceStarBtn.setTextColor(Color.parseColor("#666666"));
    }

    /* 为Tab按钮添加点击事件 */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_device_total:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tab_device_usual:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tab_device_star:
                viewPager.setCurrentItem(2);
                break;
        }
    }
}
