package com.yourtask.app.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yourtask.app.R;
import com.yourtask.app.model.DrawerItem;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class DrawerAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<DrawerItem> navDrawerItems;
    private LayoutInflater mInflater;

    public DrawerAdapter(Context context, ArrayList<DrawerItem> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

        ViewHolder holder = new ViewHolder(convertView);
        holder.icon.setImageResource(navDrawerItems.get(position).getIcon());
        holder.mTitle.setText(navDrawerItems.get(position).getTitle());

        if(navDrawerItems.get(position).getCounterVisibility()){
            holder.mCounter.setText(navDrawerItems.get(position).getCount());
        }else{
            // hide the counter view
            holder.mCounter.setVisibility(View.GONE);
        }

        return convertView;
    }

    class ViewHolder {
        @InjectView(R.id.icon)
        ImageView icon;
        @InjectView(R.id.title)
        TextView mTitle;
        @InjectView(R.id.counter)
        TextView mCounter;

        ViewHolder(View view){
            ButterKnife.inject(this, view);
        }
    }
}
