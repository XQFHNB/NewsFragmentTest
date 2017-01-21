package com.example.newsfragmenttest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by XQF on 2017/1/21.
 */
public class MyAdapter extends ArrayAdapter<News> {
    private int resourceId;
    private Context context;

    public MyAdapter(Context context, int resourceId, List<News> listNews) {
        super(context, resourceId, listNews);
        this.context = context;
        this.resourceId = resourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(resourceId, null);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.news_item);
            convertView.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.textView.setText(news.getTitle());
        return convertView;
    }

    class ViewHolder {
        TextView textView;
    }
}
