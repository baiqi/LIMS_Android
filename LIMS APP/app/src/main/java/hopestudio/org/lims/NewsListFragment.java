package hopestudio.org.lims;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import hopestudio.org.lims.News.NewsCenterFragment;
import hopestudio.org.lims.News.RuleFragment;
import hopestudio.org.lims.News.ServiceFragment;
import hopestudio.org.lims.News.StructFragment;
import hopestudio.org.lims.Util.ViewPagerUtil;

/**
 * Created by dengzhirong on 15.11.29.
 */
public class NewsListFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentsList;
    private FragmentPagerAdapter pagerAdapter;
    private View newsCategoryView;
    private FragmentManager fragmentManager;

    private TextView newsCenterBtn;
    private TextView ruleBtn;
    private TextView structBtn;
    private TextView serviceBtn;

    public NewsListFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        newsCategoryView = inflater.inflate(R.layout.activity_news_list, container, false);

        newsCenterBtn = (TextView) newsCategoryView.findViewById(R.id.tab_news_newscenter);
        ruleBtn = (TextView) newsCategoryView.findViewById(R.id.tab_news_rule);
        structBtn = (TextView) newsCategoryView.findViewById(R.id.tab_news_struct);
        serviceBtn = (TextView) newsCategoryView.findViewById(R.id.tab_news_service);


        newsCenterBtn.setOnClickListener(this);
        ruleBtn.setOnClickListener(this);
        structBtn.setOnClickListener(this);
        serviceBtn.setOnClickListener(this);

        viewPager = (ViewPager) newsCategoryView.findViewById(R.id.news_category_viewPager);

        // 数据填充
        fragmentsList = new ArrayList<Fragment>();
        Fragment fragmentNewsCenter = new NewsCenterFragment();
        Fragment fragmentRule = new RuleFragment();
        Fragment fragmentStruct = new StructFragment();
        Fragment fragmentService = new ServiceFragment();

        fragmentsList.add(fragmentNewsCenter);
        fragmentsList.add(fragmentRule);
        fragmentsList.add(fragmentStruct);
        fragmentsList.add(fragmentService);

        ViewPagerUtil viewPagerUtil = new ViewPagerUtil(fragmentsList, viewPager, fragmentManager) {
            @Override
            public void changeOnPageSelected(int currentItem) {

                // 将字体颜色恢复
                initTab();

                switch(currentItem) {
                    case 0:
                        newsCenterBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                    case 1:
                        ruleBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                    case 2:
                        structBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                    case 3:
                        serviceBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                }
            }
        };

        // 返回Fragment的View对象
        return newsCategoryView;
    }

    // 恢复Tab hover前的状态
    private void initTab() {
        newsCenterBtn.setTextColor(Color.parseColor("#666666"));
        ruleBtn.setTextColor(Color.parseColor("#666666"));
        structBtn.setTextColor(Color.parseColor("#666666"));
        serviceBtn.setTextColor(Color.parseColor("#666666"));
    }

    /* 为Tab按钮添加点击事件 */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_news_newscenter:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tab_news_rule:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tab_news_struct:
                viewPager.setCurrentItem(2);
                break;
            case R.id.tab_news_service:
                viewPager.setCurrentItem(3);
                break;
        }
    }

}
