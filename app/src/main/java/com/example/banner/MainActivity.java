package com.example.banner;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] news={"http://img.club.pchome.net/upload/club/other/2009/9/28/pics_summor_1254135850.jpg"
            ,"http://file03.16sucai.com/2017/1100/16sucai_p20161117116.JPG",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1530148203&di=f76108132220d420f20e670007cbfc7c&imgtype=jpg&er=1&src=http%3A%2F%2Ff10.topitme.com%2Fo042%2F10042332873d775e7b.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529553529652&di=b620d433ed2c93c296e1bf5434594399&imgtype=0&src=http%3A%2F%2Fgame.ahgame.com%2Fuploads%2Fallimg%2F171120%2F1-1G120102133.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529553594735&di=4133e5bb6f4221acbc673d0518e34ed6&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D1706558701%2C1505343713%26fm%3D214%26gp%3D0.jpg"
    };
    private List<String>  list=new ArrayList<>();
  private Banner banner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i <news.length ; i++) {
     list.add(news[i]);
        }
        banner=findViewById(R.id.banner);
               banner.setImageLoader(new ImageLoader() {
                   @Override
                   public void displayImage(Context context, Object path, ImageView imageView) {
                       Glide.with(context).load(path).into(imageView);
                   }
               });
               banner.setImages(list);
               banner.setDelayTime(2000);
               banner.isAutoPlay(true);
               banner.setBannerAnimation(Transformer.DepthPage);
               banner.start();
    }
}
