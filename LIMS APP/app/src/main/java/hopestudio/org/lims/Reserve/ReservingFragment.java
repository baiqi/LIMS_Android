package hopestudio.org.lims.Reserve;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hopestudio.org.lims.Controller.DeviceCategoryAdapter;
import hopestudio.org.lims.Controller.ReservingAdapter;
import hopestudio.org.lims.Model.DataDeviceCategoryModel;
import hopestudio.org.lims.Model.DataReservingListModel;
import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.18.
 */
public class ReservingFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private List<DataReservingListModel> dataList;
    private ReservingAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View departmentView = inflater.inflate(R.layout.fragment_reserve_reserving, container, false);

        // 获取RecyclerView的元素对象
        recyclerView = (RecyclerView) departmentView.findViewById(R.id.reserving_recyclerView);

        // 填充数据源
        dataList = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            /*
            * reservingListPic：仪器图片
            * reservingListTitle：仪器名称
            * reservingListDuration：预约时长
            * reservingListMoney：总费用
            * reservingListTimes：预约时间段
            * reservingListChangeTimeBtn：更改预约时间
            * reservingListCancel：取消预约
            * */
            DataReservingListModel reservingBean = new DataReservingListModel();
            reservingBean.reservingListPic = R.drawable.pic_device_default;
            reservingBean.reservingListTitle ="正在预约的仪器" + i;
            reservingBean.reservingListDuration ="Duration: " + i + "h";
            reservingBean.reservingListTimes ="2015-12-16 9:" + i + " ~ 2015-12-16 11:30";
            dataList.add(reservingBean);
        }

        // 为Adapter填充数据源
        adapter = new ReservingAdapter(this.getActivity(), dataList);

        // 为recyclerView设置Adapter
        recyclerView.setAdapter(adapter);

        // 设置RecyclerView的布局管理
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // 设置RecyclerView动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // 为每个Item设置点击事件
        adapter.setOnItemClickListener(new ReservingAdapter.OnItemClickListener() {
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