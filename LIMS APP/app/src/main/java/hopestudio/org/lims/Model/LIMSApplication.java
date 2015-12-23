package hopestudio.org.lims.Model;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Handler;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.nostra13.universalimageloader.utils.StorageUtils;

import java.io.File;

import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.10.
 */
public class LIMSApplication extends Application {
    public static RequestQueue volleyQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        /* Volley配置 */
        // 建立Volley的Http请求队列
        volleyQueue = Volley.newRequestQueue(getApplicationContext());

        /* Universal-ImageLoader 全局配置 */
        File cacheDir = StorageUtils.getCacheDirectory(this);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                .memoryCacheExtraOptions(480, 800) // 每个缓存文件的长宽
                .diskCacheExtraOptions(480, 800, null) // 保存到硬盘中的每个文件的最大长宽
                .threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY - 2) // 线程池的数量
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024)) // 最大缓存的大小
                .memoryCacheSize(2 * 1024 * 1024)
                .memoryCacheSizePercentage(13) // default
                .diskCache(new UnlimitedDiskCache(cacheDir)) // default
                .diskCacheSize(50 * 1024 * 1024)
                .diskCacheFileCount(100)
                .defaultDisplayImageOptions(getDisplayOptions())
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(this)) // default
                .imageDecoder(new BaseImageDecoder(true)) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs()
                .build();

        //全局初始化此配置
        ImageLoader.getInstance().init(config);
    }

    // 开放Volley的HTTP请求队列接口
    public static RequestQueue getRequestQueue() {
        return volleyQueue;
    }

    /* Universal-ImageLoader 图片显示设置 */
    private DisplayImageOptions getDisplayOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.pic_loading) // 图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.pic_error) // 图片下载出错时显示的图片
                .showImageOnFail(R.drawable.pic_notfound) // 图片下载失败时显示的图片
                .resetViewBeforeLoading(false)  // default
                .delayBeforeLoading(1000)
                .cacheInMemory(false) // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true) // 设置下载的图片是否缓存在SD中
                .considerExifParams(false) // 是否考虑JPFG图像EXIF参数
                .imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2) // 设置图片的编码方式
                .bitmapConfig(Bitmap.Config.ARGB_8888) // 设置图片的解码类型
                .displayer(new SimpleBitmapDisplayer()) // 是否设置为圆角，弧度是多少
                .displayer(new FadeInBitmapDisplayer(100)) // 图片加载好后渐入的动画时间
                .handler(new Handler()) // default
                .build();
        return options;
    }

}
