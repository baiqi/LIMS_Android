package hopestudio.org.lims;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dengzhirong on 15.11.29.
 */
public class LaunchActivity extends AppCompatActivity {

    // 欢迎界面停留时间
    private int LAUNCH_DELAY = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        // 欢迎界面延时关闭
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 创建跳转至MainActivity的Intent
                Intent IntentToMain = new Intent(LaunchActivity.this, MainActivity.class);
                //启动Main界面
                startActivity(IntentToMain);
                // 关闭欢迎页面，避免在MainActivity点击返回键时跳转至欢迎页面
                LaunchActivity.this.finish();
            }
        }, LAUNCH_DELAY);

    }

}
