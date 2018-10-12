package com.zfg.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zfg.test.R;
import com.zfg.test.entity.ExpandGroupBean;

import java.security.acl.Group;
import java.util.List;

/**
 * Created by zfg on 2018/10/12
 * expandliseview适配器
 */
public class MyExpandAdapter extends BaseExpandableListAdapter {
    private List<ExpandGroupBean> mGroupList;
    private Context mContext;

    public MyExpandAdapter(List<ExpandGroupBean> groupList, Context context) {
        mGroupList = groupList;
        mContext = context;
    }

    @Override
    public int getGroupCount() {
        return mGroupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mGroupList.get(groupPosition).getChildBeans().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mGroupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mGroupList.get(groupPosition).getChildBeans().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        HolderGroup group = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_expand_group, null);
            group = new HolderGroup(convertView);
            convertView.setTag(group);
        } else {
            group = (HolderGroup) convertView.getTag();
        }
        group.tv.setText(mGroupList.get(groupPosition).getGroupName());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        HolderChild child = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_expand_child, null);
            child = new HolderChild(convertView);
            convertView.setTag(child);
        } else {
            child = (HolderChild) convertView.getTag();
        }
        child.tv.setText(mGroupList.get(groupPosition).getChildBeans().get(childPosition).getChildName());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    class HolderGroup {
        TextView tv;

        public HolderGroup(View convertView) {
            tv = convertView.findViewById(R.id.item_group_tv);
        }
    }

    class HolderChild {
        TextView tv;

        public HolderChild(View convertView) {
            tv = convertView.findViewById(R.id.item_child_tv);
        }
    }
}
