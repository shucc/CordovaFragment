package org.cchao.cordovafragment.plugins;

import android.util.Log;
import android.widget.Toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by chenchao on 15/12/2.
 */
public class BridgePlugin extends CordovaPlugin{

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("toast")) {
            Log.i("cordovafragment", "toast");
            Toast.makeText(cordova.getActivity(), "hehe", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
