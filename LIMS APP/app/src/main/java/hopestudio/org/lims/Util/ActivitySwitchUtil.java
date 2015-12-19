package hopestudio.org.lims.Util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by dengzhirong on 15.12.10.
 */
public class ActivitySwitchUtil {

    /*
    * 简单的Activity跳转，无数据传递
    * */
    public void ActivitySwitch(Activity activity, Class nextPage) {
        Intent intent = new Intent(activity, nextPage);
        activity.startActivity(intent);
    }

    /*
    * 简单的Activity跳转，有数据传递
    * */
    public void ActivitySwitch(Activity activity, Class nextPage, Bundle bundle) {
        Intent intent = new Intent(activity, nextPage);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    /*
    * 带转场效果的Activity动效，无数据传递
    * 其中，第三个参数为入场动画，第四个参数是退场动画
    * */
    public void ActivitySwitch(Activity activity, Class nextPage, int enterAnimResId, int exitAnimResId) {
        Intent intent = new Intent();
        intent.setClass(activity, nextPage);
        activity.startActivity(intent);
        activity.overridePendingTransition(enterAnimResId, exitAnimResId);
    }

}