package com.android.benben.myviewdraghelper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

/**
 * Time      2017/5/17 16:23 .
 * Author   : LiYuanXiong.
 * Content  :
 */

public class MyExpandableListViewAdapter  extends BaseExpandableListAdapter {
    private Map<String, List<String>> dataset;
    private String[] parentList;
    private Context mContext;
    private LayoutInflater mInflater;

    public MyExpandableListViewAdapter(String[] parentList, Map<String, List<String>> dataset, Activity activity) {
        this.mContext = activity;
        this.parentList = parentList;
        this.dataset = dataset;
        mInflater = LayoutInflater.from(mContext);

    }


    //  获得某个父项的某个子项
    @Override
    public Object getChild(int parentPos, int childPos) {
        return dataset.get(parentList[parentPos]).get(childPos);
    }

    //  获得父项的数量
    @Override
    public int getGroupCount() {
        return dataset.size();
    }

    //  获得某个父项的子项数目
    @Override
    public int getChildrenCount(int parentPos) {
        return dataset.
                get(parentList[parentPos])
                .size();
    }

    //  获得某个父项
    @Override
    public Object getGroup(int parentPos) {
        return dataset.get(parentList[parentPos]);
    }

    //  获得某个父项的id
    @Override
    public long getGroupId(int parentPos) {
        return parentPos;
    }

    //  获得某个父项的某个子项的id
    @Override
    public long getChildId(int parentPos, int childPos) {
        return childPos;
    }

    //  按函数的名字来理解应该是是否具有稳定的id，这个方法目前一直都是返回false，没有去改动过
    @Override
    public boolean hasStableIds() {
        return false;
    }

    //  获得父项显示的view
    @Override
    public View getGroupView(int parentPos, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mInflater.inflate(R.layout.item_text, null);
        }
        view.setTag(R.layout.item_text, parentPos);
        TextView text1 = (TextView) view.findViewById(R.id.text1);
        text1.setText(parentList[parentPos]);
        return view;
    }

    //  获得子项显示的view
    @Override
    public View getChildView(int parentPos, int childPos, boolean b, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mInflater.inflate(R.layout.item_text, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.text1);
        final String name=dataset.get(parentList[parentPos]).get(childPos);
        textView.setText(dataset.get(parentList[parentPos]).get(childPos));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "你点击了"+name, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    //  子项是否可选中，如果需要设置子项的点击事件，需要返回true
    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
