/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package org.cchao.cordovafragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener{

    private Fragment1 mFragment1;
    private Fragment2 mFragment2;
    private Fragment3 mFragment3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefaultFragment();
        this.findViewById(R.id.text1).setOnClickListener(this);
        this.findViewById(R.id.text2).setOnClickListener(this);
        this.findViewById(R.id.text3).setOnClickListener(this);
    }

    private void setDefaultFragment() {
        mFragment1 = new Fragment1();
        FragmentManager mFragmentManager = getFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.framelayout, mFragment1);
        mFragmentTransaction.commit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text1:
                mFragment1 = new Fragment1();
                FragmentManager mFragmentManager = getFragmentManager();
                FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.framelayout, mFragment1);
                mFragmentTransaction.commit();
                break;
            case R.id.text2:
                mFragment2 = new Fragment2();
                FragmentManager m2FragmentManager = getFragmentManager();
                FragmentTransaction m2FragmentTransaction = m2FragmentManager.beginTransaction();
                m2FragmentTransaction.replace(R.id.framelayout, mFragment2);
                m2FragmentTransaction.commit();
                break;
            case R.id.text3:
                mFragment3 = new Fragment3();
                FragmentManager m3FragmentManager = getFragmentManager();
                FragmentTransaction m3FragmentTransaction = m3FragmentManager.beginTransaction();
                m3FragmentTransaction.replace(R.id.framelayout, mFragment3);
                m3FragmentTransaction.commit();
                break;
            default:
                break;
        }
    }
}
