package hopestudio.org.lims.Device;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hopestudio.org.lims.Controller.DeviceCategoryAdapter;
import hopestudio.org.lims.Controller.DeviceListAdapter;
import hopestudio.org.lims.Model.DataDeviceCategoryModel;
import hopestudio.org.lims.Model.DataDeviceListModel;
import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.18.
 */
public class UsualFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private List<DataDeviceListModel> dataList;
    private DeviceListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View deviceUsualView = inflater.inflate(R.layout.fragment_device_usual, container, false);

        // 获取RecyclerView的元素对象
        recyclerView = (RecyclerView) deviceUsualView.findViewById(R.id.device_usual_recyclerView);

        // 填充数据源
        dataList = new ArrayList<>();

        for(int i = 0; i < 11; i++) {
            DataDeviceListModel deviceCategoryBean = new DataDeviceListModel();
            /*
            * deviceListPic：仪器图片
            * deviceListTitle：仪器名称
            * deviceListModel：仪器型号
            * deviceListReservedBtn：仪器预约记录按钮
            * deviceListReservingBtn：仪器预约按钮
            * */
            deviceCategoryBean.deviceListPicUrl = "http://7xinb0.com1.z0.glb.clouddn.com/skin/HopeRebuild/dist/images/logo/logo_40.png";
            deviceCategoryBean.deviceListPic = R.drawable.pic_device_default;
            deviceCategoryBean.deviceListTitle = "常用仪器" + i;
            deviceCategoryBean.deviceListModel = "型号" + i;
            dataList.add(deviceCategoryBean);
        }

        // 为Adapter填充数据源
        adapter = new DeviceListAdapter(this.getActivity(), dataList);

        // 为recyclerView设置Adapter
        recyclerView.setAdapter(adapter);

        // 设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getActivity(), 2));

        // 设置RecyclerView动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // 为每个Item设置点击事件
        adapter.setOnItemClickListener(new DeviceListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                // Toast.makeText(NewsCenterFragment.this.getActivity(), "short Click: " + position + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        // 返回Fragment的View对象
        return deviceUsualView;
    }
}