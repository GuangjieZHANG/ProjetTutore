package com.example.ressources;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by 张广洁 on 2018/3/15.
 */

public class SortActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sort);
        ImageView gotoApp = (ImageView)findViewById(R.id.gotoApp);
        ImageView gotoRessource = (ImageView)findViewById(R.id.gotoRessource);
        //We will go to the page app
        gotoApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //Click this image, we will goto the page ressource
        gotoRessource.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
