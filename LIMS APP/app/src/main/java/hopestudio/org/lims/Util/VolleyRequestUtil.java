package hopestudio.org.lims.Util;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

import hopestudio.org.lims.Model.LIMSApplication;

/**
 * Created by dengzhirong on 15.12.10.
 */
public class VolleyRequestUtil {

    public static StringRequest stringRequest;
    public static Context context;

    /*
    * 获取GET请求内容
    * 参数：context：当前上下文；url：请求的url地址；tag：当前请求的标签；volleyListenerInterface：VolleyListenerInterface接口
    * */
    public static void RequestGet(Context context, String url, String tag, VolleyListenerInterface volleyListenerInterface) {
        // 清除请求队列中的tag标记请求
        LIMSApplication.getRequestQueue().cancelAll(tag);
        // 创建当前的请求，获取字符串内容
        stringRequest = new StringRequest(Request.Method.GET, url, volleyListenerInterface.responseListener(), volleyListenerInterface.errorListener());
        // 为当前请求添加标记
        stringRequest.setTag(tag);
        // 将当前请求添加到请求队列中
        LIMSApplication.getRequestQueue().add(stringRequest);
        // 重启当前请求队列
        LIMSApplication.getRequestQueue().start();
    }

    /*
    * 获取POST请求内容（请求的代码为Map）
    * 参数：context：当前上下文；url：请求的url地址；tag：当前请求的标签；params：POST请求内容；volleyListenerInterface：VolleyListenerInterface接口
    * */
    public static void RequestPost(Context context, String url, String tag, final Map<String, String> params, VolleyListenerInterface volleyListenerInterface) {
        // 清除请求队列中的tag标记请求
        LIMSApplication.getRequestQueue().cancelAll(tag);
        // 创建当前的POST请求，并将请求内容写入Map中
        stringRequest = new StringRequest(Request.Method.POST, url, volleyListenerInterface.responseListener(), volleyListenerInterface.errorListener()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        // 为当前请求添加标记
        stringRequest.setTag(tag);
        // 将当前请求添加到请求队列中
        LIMSApplication.getRequestQueue().add(stringRequest);
        // 重启当前请求队列
        LIMSApplication.getRequestQueue().start();
    }

    /*
* 获取POST请求内容（请求的代码为Map）
* 参数：context：当前上下文；url：请求的url地址；tag：当前请求的标签；params：POST请求内容；volleyListenerInterface：VolleyListenerInterface接口
* */
/*    public static void RequestPost(Context context, String url, String tag, final Map<String, String> params, VolleyListenerInterface volleyListenerInterface) {
        // 清除请求队列中的tag标记请求
        LIMSApplication.getRequestQueue().cancelAll(tag);
        // 创建当前的POST请求，并将请求内容写入Map中
        stringRequest = new StringRequest(url, volleyListenerInterface.responseListener(), volleyListenerInterface.errorListener()){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        // 为当前请求添加标记
        stringRequest.setTag(tag);
        // 将当前请求添加到请求队列中
        LIMSApplication.getRequestQueue().add(stringRequest);
        // 重启当前请求队列
        LIMSApplication.getRequestQueue().start();
    }*/


}