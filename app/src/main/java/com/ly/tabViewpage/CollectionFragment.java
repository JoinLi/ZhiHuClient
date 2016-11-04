package com.ly.tabViewpage;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
     * @Auther: Joinli
     * @Date: 2016/7/9.
     * @description: 分区界面
     */
    public class CollectionFragment extends Fragment {

        public static final String TITLE = "歌单";

        public static CollectionFragment newInstance() {
            CollectionFragment fragment = new CollectionFragment();
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View parentView = inflater.inflate(R.layout.fragment_album, container, false);
            TextView text= (TextView) parentView.findViewById(R.id.text);
            text.setText(TITLE);
            return parentView;
        }


    }
