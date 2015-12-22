package hopestudio.org.lims;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public PersonFragmentLogined aaa;

    /*
    * 声明ViewPager和ViewPager的数据集合
    * */
    private List<Fragment> fragmentsList;
    private ViewPager mainViewPager;
    private FragmentPagerAdapter pagerAdapter;

    /* 初始化Tab中项目 */
    private TextView tabNewsBtn;
    private TextView tabLessonBtn;
    private TextView tabDeviceListBtn;
    private TextView tabReserveBtn;
    private TextView tabPersonBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Toolbar设置 */
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setNavigationIcon(R.mipmap.icon_toolbar_back);
        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle the menu item
                Toast.makeText(MainActivity.this, "hhahah", Toast.LENGTH_LONG).show();
                return true;
            }
        });
        mToolbar.inflateMenu(R.menu.toolbar);
        setSupportActionBar(mToolbar);

/*        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this, "action_settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_share:
                        Toast.makeText(MainActivity.this, "action_share", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });*/


        // 初始化页面
        initView();

        // Tab点击
        initEvent();

        /*
        * 将Fragment作为Adapter的数据源
        * */
        fragmentsList = new ArrayList<Fragment>();

        Fragment fragmentNewsList = new NewsListFragment(getSupportFragmentManager());
        Fragment fragmentLesson = new LessonFragment();
        Fragment fragmentDevice = new DeviceListFragment(getSupportFragmentManager());
        Fragment fragmentReserve = new ReserveFragment(getSupportFragmentManager());
        Fragment fragmentPerson = new PersonFragment();

        fragmentsList.add(fragmentNewsList);
        fragmentsList.add(fragmentLesson);
        fragmentsList.add(fragmentDevice);
        fragmentsList.add(fragmentReserve);
        fragmentsList.add(fragmentPerson);

        // 创建ViewPager的Adapter
        pagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentsList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentsList.size();
            }
        };

        // 获取ViewPager的View元素
        mainViewPager = (ViewPager) findViewById(R.id.viewPagerMain);
        // 为ViewPager加载适配器
        mainViewPager.setAdapter(pagerAdapter);

        // 为ViewPager添加滑屏事件
        mainViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            /* 当前页时，切换图标 */
            @Override
            public void onPageSelected(int position) {
                // 初始化未hover状态的tab图标
                initTabImage();

                int currentItem = mainViewPager.getCurrentItem();
                switch(currentItem) {
                    case 0:
                        tabNewsBtn.setTextColor(Color.parseColor("#009688"));
                        tabNewsBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_icon_news_hover, 0, 0);
                        break;
                    case 1:
                        tabLessonBtn.setTextColor(Color.parseColor("#009688"));
                        tabLessonBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_icon_lesson_hover, 0, 0);
                        break;
                    case 2:
                        tabDeviceListBtn.setTextColor(Color.parseColor("#009688"));
                        tabDeviceListBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_icon_device_hover, 0, 0);
                        break;
                    case 3:
                        tabReserveBtn.setTextColor(Color.parseColor("#009688"));
                        tabReserveBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_icon_reserving_hover, 0, 0);
                        break;
                    case 4:
                        tabPersonBtn.setTextColor(Color.parseColor("#009688"));
                        tabPersonBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_icon_person_hover, 0, 0);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /* 初始化页面 */
    private void initView() {
        tabNewsBtn = (TextView) findViewById(R.id.tab_news);
        tabLessonBtn = (TextView) findViewById(R.id.tab_lesson);
        tabDeviceListBtn = (TextView) findViewById(R.id.tab_device);
        tabReserveBtn = (TextView) findViewById(R.id.tab_reserve);
        tabPersonBtn = (TextView) findViewById(R.id.tab_person);
    }

    /* 为Tab初始化点击事件 */
    private void initEvent() {
        tabNewsBtn.setOnClickListener(this);
        tabLessonBtn.setOnClickListener(this);
        tabDeviceListBtn.setOnClickListener(this);
        tabReserveBtn.setOnClickListener(this);
        tabPersonBtn.setOnClickListener(this);
    }

    /* 初始化Tab的图标资源 */
    private void initTabImage() {
        tabNewsBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_icon_news, 0, 0);
        tabLessonBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_icon_lesson, 0, 0);
        tabDeviceListBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_icon_device, 0, 0);
        tabReserveBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_icon_reserving, 0, 0);
        tabPersonBtn.setCompoundDrawablesWithIntrinsicBounds(0, R.mipmap.tab_icon_person, 0, 0);

        tabNewsBtn.setTextColor(Color.parseColor("#999999"));
        tabLessonBtn.setTextColor(Color.parseColor("#999999"));
        tabDeviceListBtn.setTextColor(Color.parseColor("#999999"));
        tabReserveBtn.setTextColor(Color.parseColor("#999999"));
        tabPersonBtn.setTextColor(Color.parseColor("#999999"));
    }

    /* 为Tab按钮添加点击事件 */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tab_news:
                mainViewPager.setCurrentItem(0);
                break;
            case R.id.tab_lesson:
                mainViewPager.setCurrentItem(1);
                break;
            case R.id.tab_device:
                mainViewPager.setCurrentItem(2);
                break;
            case R.id.tab_reserve:
                mainViewPager.setCurrentItem(3);
                break;
            case R.id.tab_person:
                mainViewPager.setCurrentItem(4);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
