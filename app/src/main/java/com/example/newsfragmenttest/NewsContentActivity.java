package com.example.newsfragmenttest;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by XQF on 2017/1/21.
 */
public class NewsContentActivity extends Activity {

    public static void actionStart(Context context, String title, String content) {
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("content", content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.news_content);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String content = intent.getStringExtra("content");
        NewsContentFragment fragment = (NewsContentFragment) getFragmentManager()
                .findFragmentById(R.id.news_content_fragment);
        fragment.refresh(title, content);
    }
}
