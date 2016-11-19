package com.ableandroid.ossylib;

/**
 * Created by mwolfson on 11/12/16.
 */

public class OssItem {

    public String libName = "";
    public String licType = "";
    public String libUrl = "";

    public static final String APACHE_LISC = "Apache 2.0";
    public static final String MISC_LISC = "BSD, MIT, Apache 2.0";

    public OssItem(String libNameIn, String licTypeIn, String libUrlIn) {
        libName = libNameIn;
        licType = licTypeIn;
        libUrl = libUrlIn;
    }

}

