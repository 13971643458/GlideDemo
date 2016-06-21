package com.example.administrator.glidedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.administrator.glidedemo.adapter.ImageListAdapter;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    public static String[] eatFoodyImages = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(new ImageListAdapter(MainActivity.this, eatFoodyImages));
    }


//    Glide.with(context).load(urls.get(i).getUrl()).fitCenter().into(new ImageViewTarget<GlideDrawable>(imageViewHolder.image) {
//        @Override
//        protected void setResource(GlideDrawable resource) {
//            imageViewHolder.image.setImageDrawable(resource);
//        }
//
//        @Override
//        public void setRequest(Request request) {
//            imageViewHolder.image.setTag(i);
//            imageViewHolder.image.setTag(R.id.glide_tag_id,request);
//        }
//
//        @Override
//        public Request getRequest() {
//            return (Request) imageViewHolder.image.getTag(R.id.glide_tag_id);
//        }
//    });
//
//    imageViewHolder.image.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            int position = (int) v.getTag();
//            Toast.makeText(context, urls.get(position).getWho(), Toast.LENGTH_SHORT).show();
//        }
//    });
}
