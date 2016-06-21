package com.example.administrator.glidedemo.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.example.administrator.glidedemo.R;

/**
 * Created by Administrator on 2016/6/20.
 */

public class ImageListAdapter extends ArrayAdapter{

    private Context context;
    private LayoutInflater inflater;

    private String[] imageUrls;

    public ImageListAdapter(Context context, String[] imageUrls) {
        super(context, R.layout.item_main, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == convertView) {
            convertView = inflater.inflate(R.layout.item_main, parent, false);
        }

        Glide.with(context)
                .load(imageUrls[position])
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .override(600, 200) // resizes the image to these dimensions (in pixel)
                .centerCrop()
//                .skipMemoryCache(true)//跳过内存缓存
                .thumbnail(0.1f)//缩小十分之一
                .animate(animationObject)//自定义类实现动画
                .into((ImageView) convertView);

        return convertView;
    }

    ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
        @Override
        public void animate(View view) {
            // if it's a custom view class, cast it here
            // then find subviews and do the animations
            // here, we just use the entire view for the fade animation
            view.setAlpha( 0f );

            ObjectAnimator fadeAnim = ObjectAnimator.ofFloat( view, "alpha", 0f, 1f );
            fadeAnim.setDuration( 2500 );

            fadeAnim.start();
        }
    };

}
