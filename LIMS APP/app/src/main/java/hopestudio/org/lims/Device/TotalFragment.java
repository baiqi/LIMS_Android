package hopestudio.org.lims.Device;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import hopestudio.org.lims.Device.TotalCategory.DepartmentFragment;
import hopestudio.org.lims.Device.TotalCategory.FunctionFragment;
import hopestudio.org.lims.Device.TotalCategory.PositionFragment;
import hopestudio.org.lims.R;
import hopestudio.org.lims.Util.ViewPagerUtil;

/**
 * Created by dengzhirong on 15.12.18.
 */
public class TotalFragment extends android.support.v4.app.Fragment implements View.OnClickListener {

    private ViewPager viewPager;
    private ArrayList<Fragment> fragmentsList;
    private View newsCategoryView;
    private FragmentManager fragmentManager;

    private TextView departmentBtn;
    private TextView functionBtn;
    private TextView positionBtn;

    public TotalFragment(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        newsCategoryView = inflater.inflate(R.layout.fragment_device_total, container, false);

        departmentBtn = (TextView) newsCategoryView.findViewById(R.id.tab_device_department);
        functionBtn = (TextView) newsCategoryView.findViewById(R.id.tab_device_function);
        positionBtn = (TextView) newsCategoryView.findViewById(R.id.tab_device_position);

        departmentBtn.setOnClickListener(this);
        functionBtn.setOnClickListener(this);
        positionBtn.setOnClickListener(this);

        viewPager = (ViewPager) newsCategoryView.findViewById(R.id.device_total_category_viewPager);

        // 数据填充
        fragmentsList = new ArrayList<Fragment>();
        Fragment fragmentDepartment = new DepartmentFragment();
        Fragment fragmentFunction = new FunctionFragment();
        Fragment fragmentPosition = new PositionFragment();

        fragmentsList.add(fragmentDepartment);
        fragmentsList.add(fragmentFunction);
        fragmentsList.add(fragmentPosition);

        ViewPagerUtil viewPagerUtil = new ViewPagerUtil(fragmentsList, viewPager, fragmentManager) {
            @Override
            public void changeOnPageSelected(int currentItem) {

                // 将字体颜色恢复
                initTab();

                switch(currentItem) {
                    case 0:
                        departmentBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_device_catogary_department_hover, 0, 0);;
                        departmentBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                    case 1:
                        functionBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_device_catogary_function_hover, 0, 0);
                        functionBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                    case 2:
                        positionBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_device_catogary_position_hover, 0, 0);
                        positionBtn.setTextColor(Color.parseColor("#009688"));
                        break;
                }
            }
        };

        // 返回Fragment的View对象
        return newsCategoryView;
    }

    // 恢复Tab hover前的状态
    private void initTab() {
        departmentBtn.setTextColor(Color.parseColor("#666666"));
        functionBtn.setTextColor(Color.parseColor("#666666"));
        positionBtn.setTextColor(Color.parseColor("#666666"));

        departmentBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_device_catogary_department, 0, 0);;
        functionBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_device_catogary_function, 0, 0);
        positionBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.icon_device_catogary_position, 0, 0);
    }

    /* 为Tab按钮添加点击事件 */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_device_department:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tab_device_function:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tab_device_position:
                viewPager.setCurrentItem(2);
                break;
        }
    }
}