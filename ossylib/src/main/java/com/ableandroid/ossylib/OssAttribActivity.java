package com.ableandroid.ossylib;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OssAttribActivity extends AppCompatActivity {
    public static final String XTRA_APPNAME = "appNameExtra";
    public static final String XTRA_TEXT = "textExtra";
    public static final String XTRA_TOOLBAR = "toolbarTitleExtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_attrib);

        Intent intent = getIntent();

        String appName = "We";
        String extraAppName = intent.getStringExtra(XTRA_APPNAME);
        if (extraAppName == null) {
            try {
                appName = getApplicationName(getApplicationContext());
            } catch (Exception e) {
                appName = "We";
            }
        } else {
            appName = extraAppName;
        }

        String appTitle = "Open Source";  // default
        String extraToolbar = intent.getStringExtra(XTRA_TOOLBAR);
        if (extraToolbar != null) {
            appTitle = extraToolbar;
        }

        String appText = appName + " wouldn't be the same without these great libraries, which we \u2764";
        String extraText = intent.getStringExtra(XTRA_TEXT);
        if (extraText != null) {
            appText = extraText;
        }

        setupToolbar(appTitle, appText);

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

    private void setupToolbar(String appTitle, String appText) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        //Set Toolbar title here

        collapsingToolbar.setTitle(appTitle);

        //Set AppName here
        TextView thanksTxt = (TextView) findViewById(R.id.thanks_text);
        thanksTxt.setText(appText);

        //Set Icon Here
        ImageView iv = (ImageView) findViewById(R.id.launcher);
        iv.setBackground(getFullResDefaultActivityIcon());
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

    private String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int stringId = applicationInfo.labelRes;
        return stringId == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(stringId);
    }

    private Drawable getLauncherIcon(Context context) {
        Drawable launcherIcon = null;

        List<PackageInfo> pack = context.getPackageManager().getInstalledPackages(0);

        for(PackageInfo p : pack){
            launcherIcon = p.applicationInfo.loadIcon(getPackageManager());
        }
        return launcherIcon;
    }

    public Drawable getFullResDefaultActivityIcon() {
        return getFullResIcon(Resources.getSystem(), android.R.mipmap.sym_def_app_icon);
    }

    public Drawable getFullResIcon(Resources resources, int iconId) {
        Drawable d;
        try {
            ActivityManager activityManager = (ActivityManager) getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
            int iconDpi = activityManager.getLauncherLargeIconDensity();
            d = resources.getDrawableForDensity(iconId, iconDpi);
        } catch (Resources.NotFoundException e) {
            d = null;
        }

        return (d != null) ? d : getFullResDefaultActivityIcon();
    }

    private static class OssItemAdapter
            extends RecyclerView.Adapter<OssItemAdapter.ViewHolder> {

        private List<OssItem> mValues;
        private Activity mActivity;

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public String mBoundString;

            public final View mView;
            public final LinearLayout ossLayout;
            public final TextView libName;
            public final TextView licType;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                ossLayout = (LinearLayout) view.findViewById(R.id.oss_item_layout);
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
                holder.ossLayout.setBackgroundColor(ContextCompat.getColor(mActivity, R.color.white));
                holder.libName.setTypeface(null, Typeface.NORMAL);
                holder.libName.setTypeface(null, Typeface.ITALIC);
                holder.libName.setAllCaps(false);
            } else {
                holder.ossLayout.setBackgroundColor(ContextCompat.getColor(mActivity, R.color.offwhite));
                holder.libName.setTypeface(null, Typeface.BOLD);
                holder.libName.setAllCaps(true);
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

}
