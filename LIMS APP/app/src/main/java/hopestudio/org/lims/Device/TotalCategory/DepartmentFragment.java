package hopestudio.org.lims.Device.TotalCategory;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hopestudio.org.lims.Controller.DeviceCategoryAdapter;
import hopestudio.org.lims.Controller.NewsAdapter;
import hopestudio.org.lims.Model.DataDeviceCategoryModel;
import hopestudio.org.lims.Model.DataNewsModel;
import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.19.
 */
public class DepartmentFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private List<DataDeviceCategoryModel> dataList;
    private DeviceCategoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View departmentView = inflater.inflate(R.layout.fragment_device_total_department, container, false);

        // 获取RecyclerView的元素对象
        recyclerView = (RecyclerView) departmentView.findViewById(R.id.device_total_department_recyclerView);

        // 填充数据源
        dataList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            DataDeviceCategoryModel deviceCategoryBean = new DataDeviceCategoryModel();

            deviceCategoryBean.deviceCategoryTitle = "部门" + i;
            deviceCategoryBean.deviceCategoryCount ="(" + i + ")";
            dataList.add(deviceCategoryBean);
        }

        // 为Adapter填充数据源
        adapter = new DeviceCategoryAdapter(this.getActivity(), dataList);

        // 为recyclerView设置Adapter
        recyclerView.setAdapter(adapter);

        // 设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // 设置RecyclerView动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // 为每个Item设置点击事件
        adapter.setOnItemClickListener(new DeviceCategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Toast.makeText(NewsCenterFragment.this.getActivity(), "short Click: " + position + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        // 返回Fragment的View对象
        return departmentView;
    }
}