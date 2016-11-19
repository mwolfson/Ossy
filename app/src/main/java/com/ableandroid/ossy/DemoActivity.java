package com.ableandroid.ossy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ableandroid.ossylib.OssAttribActivity;
import com.ableandroid.ossylib.OssItem;
import com.ableandroid.ossylib.OssProject;

import java.util.ArrayList;
import java.util.List;

public class DemoActivity extends AppCompatActivity {
    private Activity mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        mainActivity = this;

        // List your Project Info here
        // An item without a License or URL will show up as a section header
        Button btn = (Button) findViewById(R.id.demo_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<OssItem> items = new ArrayList<>(16);
                items.add(new OssItem("ANDROID","",""));
                items.add(OssProject.AOSP.toOssItem());
                items.add(OssProject.APP_COMPAT.toOssItem());
                items.add(OssProject.App_COMPAT_DESIGN.toOssItem());
                items.add(new OssItem("GOOGLE","",""));
                items.add(OssProject.GSON.toOssItem());
                items.add(new OssItem("SQUARE","",""));
                items.add(OssProject.RETROFIT.toOssItem());
                items.add(OssProject.OKHTTP.toOssItem());
                items.add(new OssItem("Apache", "" ,""));
                items.add(OssProject.COMMONS_LANG.toOssItem());
                items.add(new OssItem("OTHER", "",""));
                items.add(OssProject.PRETTY_TIME.toOssItem());
                items.add(OssProject.GLIDE.toOssItem());
                items.add(OssProject.COMMONSWARE_LOADER.toOssItem());
                items.add(OssProject.VIEW_PAGER_INDICATOR.toOssItem());

                Intent intent = new Intent(getApplicationContext(), OssAttribActivity.class);
//                intent.putExtra(OssAttribActivity.XTRA_APPNAME, "MikesCoolApp");
//                intent.putExtra(OssAttribActivity.XTRA_TOOLBAR, "MikesToolbarTitle");
//                intent.putExtra(OssAttribActivity.XTRA_TEXT, "I am the coolest, and that is the truth");
                startActivity(intent);
            }
        });
    }


}
