package hopestudio.org.lims.Util;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by dengzhirong on 15.12.10.
 */

/*
* 使用LruCache缓存图片
* */
public class BitmapCache implements ImageLoader.ImageCache {
    public LruCache<String, Bitmap> lruCahche;
    public int max = 10 * 1024 * 1024;

    public BitmapCache() {
        lruCahche = new LruCache<String, Bitmap>(max) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight();
            }
        };
    }

    @Override
    public void putBitmap(String s, Bitmap bitmap) {
        lruCahche.put(s, bitmap);
    }

    @Override
    public Bitmap getBitmap(String s) {
        return lruCahche.get(s);
    }
}