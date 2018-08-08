package com.lonelypluto.testspinner.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.lonelypluto.testspinner.R;
import com.lonelypluto.testspinner.bean.CityBean;

import java.util.List;

/**
 * @Description: 自定义BaseAdapter
 * @author: ZhangYW
 * @time: 2018/8/7 15:04
 */
public class SpinnerBaseAdapter extends BaseAdapter implements SpinnerAdapter{
    private List<CityBean> mList;// cityList
    private Context mContext;//

    public SpinnerBaseAdapter(Context mContext, List<CityBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 返回选中项： spinner_base_item选中项样式
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.spinner_base_item, null);
            holder.tv = (TextView) view.findViewById(R.id.spinner_base_item_tv);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.tv.setText(mList.get(i).getName() + " " + mList.get(i).getId());
        return view;
    }

    /**
     * 返回下拉项：spinner_base_dropdown_item下拉列表样式
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.spinner_base_dropdown_item, null);
            holder.tv = (TextView) convertView.findViewById(R.id.spinner_base_dropdown_item_tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv.setText(mList.get(position).getName() + " " + mList.get(position).getId());
        return convertView;
    }

    /**
     * @Description: 定义viewHolder
     * @author: ZhangYW
     * @time: 2018/8/7 15:06
     */
    public class ViewHolder{
        public TextView tv;// 城市名
    }
}
