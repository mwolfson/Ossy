package com.ableandroid.ossylib;

/**
 * Created by mwolfson on 11/12/16.
 */

public enum OssProject {
    AOSP("AOSP", OssItem.APACHE_LISC, "https://source.android.com/"),
    APP_COMPAT("AppCompat", OssItem.APACHE_LISC, "https://github.com/android/platform_frameworks_support/tree/master/v7/appcompat"),
    App_COMPAT_DESIGN("Design", OssItem.APACHE_LISC, "https://github.com/android/platform_frameworks_support/tree/master/design"),
    COMMONS_LANG("commons-lang", OssItem.APACHE_LISC, "https://commons.apache.org/proper/commons-lang/"),
    COMMONSWARE_LOADER("Commonsware Loader", OssItem.APACHE_LISC, "https://github.com/commonsguy/cwac-loaderex"),
    GLIDE("Glide", OssItem.MISC_LISC, "https://github.com/bumptech/glide"),
    GSON("Gson", OssItem.APACHE_LISC, "https://github.com/google/gson"),
    OKHTTP("OKHttp", OssItem.APACHE_LISC, "http://square.github.io/okhttp/"),
    PRETTY_TIME("PrettyTime", OssItem.APACHE_LISC, "https://github.com/ocpsoft/prettytime "),
    RETROFIT("Retrofit", OssItem.APACHE_LISC, "http://square.github.io/retrofit/"),
    VIEW_PAGER_INDICATOR("ViewPagerIndicator", OssItem.APACHE_LISC, "https://github.com/JakeWharton/ViewPagerIndicator");

    private final String title;   // Name of Lib
    private final String license;  // License type of Lib
    private final String url;  // url of home page of lib

    // in meters
    OssProject(String titleIn, String liscIn, String urlIn) {
        this.title = titleIn;
        this.license = liscIn;
        this.url = urlIn;
    }

    private String title() {
        return title;
    }

    private String lisc() {
        return license;
    }

    private String url() {
        return url;
    }

    public OssItem toOssItem() {
        OssItem ossItem = new OssItem(title, license, url);

        return ossItem;

    }
}
