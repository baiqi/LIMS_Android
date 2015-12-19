package hopestudio.org.lims;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hopestudio.org.lims.Device.StarFragment;
import hopestudio.org.lims.Device.TotalFragment;
import hopestudio.org.lims.Device.UsualFragment;
import hopestudio.org.lims.Reserve.ReservedFragment;
import hopestudio.org.lims.Reserve.ReservingFragment;
import hopestudio.org.lims.Util.ViewPagerUtil;

/**
 * Created by dengzhirong on 15.11.29.
 */
public class ReserveFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentsList;
    private View newsCategoryView;
    private FragmentManager fragmentManager;

    private TextView reservingBtn;
    private TextView reservedBtn;

    public ReserveFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
//        this.fragmentManager = ReserveFragment.this.getActivity().getSupportFragmentManager();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        newsCategoryView = inflater.inflate(R.layout.activity_reserve, container, false);

        reservingBtn = (TextView) newsCategoryView.findViewById(R.id.tab_reserve_resering);
        reservedBtn = (TextView) newsCategoryView.findViewById(R.id.tab_reserve_resered);

        reservingBtn.setOnClickListener(this);
        reservedBtn.setOnClickListener(this);

        viewPager = (ViewPager) newsCategoryView.findViewById(R.id.reserve_category_viewPager);

        // 数据填充
        fragmentsList = new ArrayList<Fragment>();
        Fragment fragmentReserving = new ReservingFragment();
        Fragment fragmentReserved = new ReservedFragment();

        fragmentsList.add(fragmentReserving);
        fragmentsList.add(fragmentReserved);

        ViewPagerUtil viewPagerUtil = new ViewPagerUtil(fragmentsList, viewPager, fragmentManager) {
            @Override
            public void changeOnPageSelected(int currentItem) {

                // 将字体颜色恢复
                initTab();

                switch(currentItem) {
                    case 0:
                        reservingBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                    case 1:
                        reservedBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                }
            }
        };

        // 返回Fragment的View对象
        return newsCategoryView;
    }

    // 恢复Tab hover前的状态
    private void initTab() {
        reservingBtn.setTextColor(Color.parseColor("#666666"));
        reservedBtn.setTextColor(Color.parseColor("#666666"));
    }

    /* 为Tab按钮添加点击事件 */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_reserve_resering:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tab_reserve_resered:
                viewPager.setCurrentItem(1);
                break;
        }
    }
}
