package com.demo.aty;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.binioter.guideview.Component;
import com.binioter.guideview.Guide;
import com.binioter.guideview.GuideBuilder;
import com.demo.component.SimpleComponent;
import com.demo.guide.R;

public class MainActivity extends Activity {


    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);

        imageView.post(new Runnable() {
            @Override
            public void run() {
                showGuideView();
            }
        });
    }


    public void showGuideView() {
        GuideBuilder builder = new GuideBuilder();
        builder.setTargetView(imageView)
                .setHighTargetGraphStyle(Component.FIT_END)
                .setHighTargetPadding(30)
                .setAlpha(150);
        builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override
            public void onShown() {
            }

            @Override
            public void onDismiss() {

            }
        });

        builder.addComponent(new SimpleComponent());
        Guide guide = builder.createGuide();
        guide.show(MainActivity.this);
    }
}
