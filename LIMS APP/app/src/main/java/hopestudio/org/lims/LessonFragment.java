package hopestudio.org.lims;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import hopestudio.org.lims.Util.WebViewUtil;

/**
 * Created by dengzhirong on 15.11.29.
 */
public class LessonFragment extends android.support.v4.app.Fragment {

    private WebView webView;
    private WebViewUtil webViewUtil;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View lessonView = inflater.inflate(R.layout.activity_lesson, container, false);

        String lessonUrl = "http://ce.sysu.edu.cn";
        webView = (WebView) lessonView.findViewById(R.id.lesson_content);

        // 往WebView中加载页面
        webViewUtil = new WebViewUtil();
        webViewUtil.loadWebView(webView, lessonUrl);

        return lessonView;
    }

}
