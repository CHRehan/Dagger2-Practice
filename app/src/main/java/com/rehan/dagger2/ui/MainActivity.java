package com.rehan.dagger2.ui;
/**
 * Created by rehan on 05/11/2018.
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.rehan.dagger2.MyApp;
import com.rehan.dagger2.R;
import com.rehan.dagger2.model.ObjectManager;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.image) ImageView imageView;
    @Inject ObjectManager objectManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyApp.app().basicComponent().inject(this);
        ButterKnife.bind(this);

        String link = objectManager.get("link", String.class);
        if(link==null){
            link = "http://c0016417.cdn2.cloudfiles.rackspacecloud.com/358974.jpg";
            objectManager.save("link", link);
        }

        Glide.with(this).load(link).into(imageView);
    }
}
