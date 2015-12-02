package org.cchao.cordovafragment;

import android.os.Bundle;

import org.apache.cordova.CordovaActivity;

public class Main2Activity extends CordovaActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadUrl("file:///android_asset/www/fragment2.html");
    }
}
