package hopestudio.org.lims.Util;

import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.File;

/**
 * Created by dengzhirong on 15.12.10.
 */
public class WebViewUtil {

    /*
    * 往WebView中载入url中的内容
    * */
    public void loadWebView(WebView webview, String url) {
        // 打开网页
        webview.loadUrl(url);

        // 设置WebView中的JavaScript可用
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // 将WebKit内核嵌入到本应用中
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                // 不采用系统默认浏览器加载URL
                view.loadUrl(url);

                // 当返回true时，控制网页在WebView中打开
                // 当返回false时，控制网页在系统自带的或第三方的浏览器中打开
                return true;
            }
        });
    }

    /*
    * 打开本地HTML文件，并将其渲染到WebView中
    * */
    public void loadWebViewFromFile(WebView webView, File file) {

    }


    /*
    * 将HTML文本渲染到WebView中
    * */
    public void loadWebViewFromHtml(WebView webView, String htmlString) {
        // 或者使用loadDataWithBaseURL()
        webView.loadDataWithBaseURL(null, htmlString, "text/html", "utf-8", null);
    }
}