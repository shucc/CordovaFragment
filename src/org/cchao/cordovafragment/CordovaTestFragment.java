package org.cchao.cordovafragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import org.apache.cordova.ConfigXmlParser;
import org.apache.cordova.CordovaInterfaceImpl;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaWebViewImpl;
import org.apache.cordova.PluginEntry;

import java.util.ArrayList;

/**
 * Created by chenchao on 15/12/2.
 */
public class CordovaTestFragment extends Fragment{

    private CordovaWebView webView;

    // Read from config.xml:
    protected CordovaPreferences preferences;
    protected String launchUrl;
    protected ArrayList<PluginEntry> pluginEntries;
    protected CordovaInterfaceImpl cordovaInterface;

    protected void loadConfig() {
        ConfigXmlParser parser = new ConfigXmlParser();
        parser.parse(getActivity());
        preferences = parser.getPreferences();
        preferences.setPreferencesBundle(getActivity().getIntent().getExtras());
        //preferences.copyIntoIntentExtras(getActivity());
        launchUrl = parser.getLaunchUrl();
        pluginEntries = parser.getPluginEntries();
        // Config.parser = parser;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_main_fragment_cordova, container, false);
        cordovaInterface =  new CordovaInterfaceImpl(getActivity());
        if(savedInstanceState != null)
            cordovaInterface.restoreInstanceState(savedInstanceState);

        loadConfig();

        webView = new CordovaWebViewImpl(CordovaWebViewImpl.createEngine(getActivity(), preferences));

        //webView.getView().setId(100);
        RelativeLayout.LayoutParams wvlp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        //wvlp.addRule(RelativeLayout.BELOW,R.id.DialogTopBar);
        webView.getView().setLayoutParams(wvlp);

        if (!webView.isInitialized()) {
            webView.init(cordovaInterface, pluginEntries, preferences);
        }
        cordovaInterface.onCordovaInit(webView.getPluginManager());
        // webView = (SystemWebView)v.findViewById(R.id.myWebView);

        // Config.init(getActivity());
        ((RelativeLayout)v).addView(webView.getView());
        webView.loadUrl("file:///android_asset/www/cordovatest.html");
        return v;
    }
}
