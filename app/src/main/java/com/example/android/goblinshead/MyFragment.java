package com.example.android.goblinshead;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {
    public static final String LAYOUT_RESOURCE = "LAYOUT_RESOURCE";


    public static final MyFragment newInstance(int layoutResource) {
        MyFragment f = new MyFragment();
        Bundle bdl = new Bundle();
        bdl.putInt(LAYOUT_RESOURCE, layoutResource);
        f.setArguments(bdl);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        int layoutResourceId = getArguments().getInt(LAYOUT_RESOURCE);
        View view = inflater.inflate(layoutResourceId, container, false);
        TextView textView = (TextView) view.findViewById(com.example.android.goblinshead.R.id.info_text_view);
        String text = (String) textView.getText();
        textView.setText((Html.fromHtml(text)));
        return view;

    }
}
