package com.example.administrator.glidedemo.utlis;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by Administrator on 2016/6/20.
 */
public class CustomCachingGlideModule implements GlideModule {

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {

//        .setMemoryCache(MemoryCache memoryCache)
//                .setBitmapPool(BitmapPool bitmapPool)
//                .setDiskCache(DiskCache.Factory diskCacheFactory)
//                .setDiskCacheService(ExecutorService service)
//                .setResizeService(ExecutorService service)
//                .setDecodeFormat(DecodeFormat decodeFormat)

// set size & external vs. internal
        int cacheSize100MegaBytes = 104857600;

//        builder.setDiskCache(new InternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));

        //builder.setDiskCache(new ExternalCacheDiskCacheFactory(context, cacheSize100MegaBytes));


        // or any other path
        String downloadDirectoryPath = Environment.getDownloadCacheDirectory().getPath();
//      builder.setDiskCache( new DiskLruCacheFactory( downloadDirectoryPath, cacheSize100MegaBytes ));

// In case you want to specify a cache sub folder (i.e. "glidecache"):
        builder.setDiskCache(new DiskLruCacheFactory(downloadDirectoryPath, "glidecache", cacheSize100MegaBytes));

    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
