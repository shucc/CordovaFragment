package org.cchao.cordovafragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by chenchao on 15/12/2.
 */
public class TestFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_main_fragment, container, false);
        ((TextView) rootView.findViewById(R.id.fragment_text)).setText(TempData.temp.toString());
        return rootView;
    }
}
