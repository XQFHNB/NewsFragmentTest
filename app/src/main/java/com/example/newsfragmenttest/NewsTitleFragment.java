package com.example.newsfragmenttest;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XQF on 2017/1/21.
 */
public class NewsTitleFragment extends Fragment implements AdapterView.OnItemClickListener {
    private List<News> listNews;
    private MyAdapter adapter;
    private ListView listView;
    private boolean isTwoPane;
    private Context context;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = getActivity();
        initListNews();
        adapter = new MyAdapter(context, R.layout.news_item, listNews);
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        listView = (ListView) view.findViewById(R.id.news_title_listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        News news = listNews.get(position);
        if (isTwoPane) {
//            FragmentManager fragmentManager=getSupportFragmentManager();
            NewsContentFragment fragment = (NewsContentFragment) getFragmentManager()
                    .findFragmentById(R.id.news_content_fragment);
            fragment.refresh(news.getTitle(), news.getContent());
        } else {
            NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
        }
    }

    public void initListNews() {
        listNews = new ArrayList<>();
        News news1 = new News("呵呵", "这个新闻略简单");
        News news2 = new News("哈哈哈", "祝大家新年快乐！");
        listNews.add(news1);
        listNews.add(news2);
    }
}
