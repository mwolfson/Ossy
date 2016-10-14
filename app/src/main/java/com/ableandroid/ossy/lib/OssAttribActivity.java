package com.ableandroid.ossy.lib;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ableandroid.ossy.R;

import java.util.ArrayList;
import java.util.List;

public class OssAttribActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_attrib);

        setupToolbar();

        RecyclerView rv = (RecyclerView) findViewById(R.id.recyclerview);
        rv.setLayoutManager(new LinearLayoutManager(this));rv.setAdapter(new OssItemAdapter(this, this, getOssList()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        //Set Toolbar title here
        collapsingToolbar.setTitle("Open Source");

        TextView thanksTxt = (TextView) findViewById(R.id.thanks_text);
        //Set Custom text here

        String appName = this.getString(R.string.app_name);
        thanksTxt.setText(appName + " wouldn't be the same without these great libraries, which we \u2764");
    }

    private static final String APACHE_LISC = "Apache 2.0";
    private static final String MISC_LISC = "BSD, MIT, Apache 2.0";


    // List your Project Info here
    // An item without a License or URL will show up as a section header
    private List<OssItem>  getOssList() {
        List<OssItem> items = new ArrayList<>(15);
        items.add(new OssItem("ANDROID","",""));
        items.add(new OssItem("AOSP", APACHE_LISC ,"https://source.android.com/"));
        items.add(new OssItem("AppCompat", APACHE_LISC,"https://github.com/android/platform_frameworks_support/tree/master/v7/appcompat"));
        items.add(new OssItem("Design", APACHE_LISC ,"https://github.com/android/platform_frameworks_support/tree/master/design"));
        items.add(new OssItem("GOOGLE","",""));
        items.add(new OssItem("Gson", APACHE_LISC ,"https://github.com/google/gson"));
        items.add(new OssItem("SQUARE","",""));
        items.add(new OssItem("Retrofit", APACHE_LISC ,"http://square.github.io/retrofit/"));
        items.add(new OssItem("OKHttp", APACHE_LISC ,"http://square.github.io/okhttp/"));
        items.add(new OssItem("Apache", "" ,""));
        items.add(new OssItem("commons-lang", APACHE_LISC ,"https://commons.apache.org/proper/commons-lang/"));
        items.add(new OssItem("OTHER", "",""));
        items.add(new OssItem("PrettyTime", APACHE_LISC ,"https://github.com/ocpsoft/prettytime "));
        items.add(new OssItem("Glide", MISC_LISC ,"https://github.com/bumptech/glide"));
        items.add(new OssItem("Commonsware Loader", APACHE_LISC ,"https://github.com/commonsguy/cwac-loaderex"));
        items.add(new OssItem("ViewPagerIndicator", APACHE_LISC ,"https://github.com/JakeWharton/ViewPagerIndicator"));
        return items;

    }

    private static class OssItemAdapter
            extends RecyclerView.Adapter<OssItemAdapter.ViewHolder> {

        private List<OssItem> mValues;
        private Activity mActivity;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public String mBoundString;

            public final View mView;
            public final TextView libName;
            public final TextView licType;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                libName = (TextView) view.findViewById(R.id.oss_lib_name);
                licType = (TextView) view.findViewById(R.id.oss_license_type);
            }
        }

        public OssItem getValueAt(int position) {
            return mValues.get(position);
        }

        public OssItemAdapter(Activity mActivityIn, Context context, List<OssItem> items) {
            mActivity = mActivityIn;
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.oss_list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mBoundString = mValues.get(position).libName;
            holder.libName.setText(mValues.get(position).libName);
            holder.licType.setText(mValues.get(position).licType);

            if (!mValues.get(position).libUrl.equals("")) {
                // Set this lib name to bold, since it is not a header
                holder.libName.setTypeface(null, Typeface.BOLD);
            } else {
                holder.libName.setTypeface(null, Typeface.NORMAL);
                holder.libName.setTypeface(null, Typeface.ITALIC);
            }

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mValues.get(position).licType.equals("")) {
                        // Ignore this, since this is for a header click
                    } else {
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(mValues.get(position).libUrl));
                        v.getContext().startActivity(i);
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }
    }

    private class OssItem {
        public String libName = "";
        public String licType = "";
        public String libUrl = "";

        private OssItem(String libNameIn, String licTypeIn, String libUrlIn) {
            libName = libNameIn;
            licType = licTypeIn;
            libUrl = libUrlIn;
        }

    }







}
