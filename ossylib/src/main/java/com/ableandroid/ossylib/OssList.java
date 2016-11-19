package com.ableandroid.ossylib;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwolfson on 11/12/16.
 */

public class OssList {
    private List<OssItem> ossList;

    private List<OssItem> getOssList() {
        List<OssItem> items = new ArrayList<>(15);
        items.add(new OssItem("ANDROID","",""));
        items.add(new OssItem("AOSP", OssItem.APACHE_LISC ,"https://source.android.com/"));
        items.add(new OssItem("AppCompat", OssItem.APACHE_LISC,"https://github.com/android/platform_frameworks_support/tree/master/v7/appcompat"));
        items.add(new OssItem("Design", OssItem.APACHE_LISC ,"https://github.com/android/platform_frameworks_support/tree/master/design"));
        items.add(new OssItem("GOOGLE","",""));
        items.add(new OssItem("Gson", OssItem.APACHE_LISC ,"https://github.com/google/gson"));
        items.add(new OssItem("SQUARE","",""));
        items.add(new OssItem("Retrofit", OssItem.APACHE_LISC ,"http://square.github.io/retrofit/"));
        items.add(new OssItem("OKHttp", OssItem.APACHE_LISC ,"http://square.github.io/okhttp/"));
        items.add(new OssItem("Apache", "" ,""));
        items.add(new OssItem("commons-lang", OssItem.APACHE_LISC ,"https://commons.apache.org/proper/commons-lang/"));
        items.add(new OssItem("OTHER", "",""));
        items.add(new OssItem("PrettyTime", OssItem.APACHE_LISC ,"https://github.com/ocpsoft/prettytime "));
        items.add(new OssItem("Glide", OssItem.MISC_LISC ,"https://github.com/bumptech/glide"));
        items.add(new OssItem("Commonsware Loader", OssItem.APACHE_LISC ,"https://github.com/commonsguy/cwac-loaderex"));
        items.add(new OssItem("ViewPagerIndicator", OssItem.APACHE_LISC ,"https://github.com/JakeWharton/ViewPagerIndicator"));



        return items;
    }
//
//    public enum OssProject {
//        AOSP         ("AOSP", OssItem.APACHE_LISC ,"https://source.android.com/"),
//        APP_COMPAT   ("AppCompat", OssItem.APACHE_LISC,"https://github.com/android/platform_frameworks_support/tree/master/v7/appcompat"),
//        App_COMPAT_DESIGN   ("Design", OssItem.APACHE_LISC ,"https://github.com/android/platform_frameworks_support/tree/master/design"),
//        GSON   ("Gson", OssItem.APACHE_LISC ,"https://github.com/google/gson"),
//        RETROFIT ("Retrofit", OssItem.APACHE_LISC ,"http://square.github.io/retrofit/"),
//        OKHTTP  ("OKHttp", OssItem.APACHE_LISC ,"http://square.github.io/okhttp/"),
//        COMMONS_LANG  ("commons-lang", OssItem.APACHE_LISC ,"https://commons.apache.org/proper/commons-lang/"),
//        PRETTY_TIME ("PrettyTime", OssItem.APACHE_LISC ,"https://github.com/ocpsoft/prettytime "),
//        GLIDE ("Glide", OssItem.MISC_LISC ,"https://github.com/bumptech/glide"),
//        COMMONSWARE_LOADER ("Commonsware Loader", OssItem.APACHE_LISC ,"https://github.com/commonsguy/cwac-loaderex"),
//        VIEW_PAGER_INDICATOR ("ViewPagerIndicator", OssItem.APACHE_LISC ,"https://github.com/JakeWharton/ViewPagerIndicator");
//
//        private final String title;   // Name of Lib
//        private final String license;  // License type of Lib
//        private final String url;  // url of home page of lib
//        // in meters
//        OssProject(String titleIn, String liscIn, String urlIn) {
//            this.title = titleIn;
//            this.license = liscIn;
//            this.url = urlIn;
//        }
//        private String title() { return title; }
//        private String lisc() { return license; }
//        private String url() { return url; }
//
//        private OssItem ossItem() {
//            return new OssItem(title, license, url);
//
//        }
//    }
}
