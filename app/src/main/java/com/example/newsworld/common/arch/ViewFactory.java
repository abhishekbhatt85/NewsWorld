package com.example.newsworld.common.arch;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.newsworld.MainActivity;
import com.example.newsworld.feature.newsdetails.ui.NewsDetailView;
import com.example.newsworld.feature.newsdetails.ui.RealNewsDetailView;
import com.example.newsworld.feature.newslist.NewsListFragment;
import com.example.newsworld.feature.newslist.model.News;
import com.example.newsworld.feature.newslist.ui.MainView;
import com.example.newsworld.feature.newslist.ui.NewsListView;
import com.example.newsworld.feature.newslist.ui.RealMainView;
import com.example.newsworld.feature.newslist.ui.RealNewsListView;

public class ViewFactory {

  private final LayoutInflater layoutInflater;

  public ViewFactory(LayoutInflater layoutInflater) {
    this.layoutInflater = layoutInflater;
  }

  public NewsListView getNewsListView(@Nullable ViewGroup parent, @NonNull
      NewsListFragment.ItemSelectedListener itemSelectedListener) {
    return new RealNewsListView(layoutInflater, parent, itemSelectedListener);
  }

  public MainView getMainView(LayoutInflater layoutInflater) {
    return new RealMainView(layoutInflater);
  }

  public NewsDetailView getNewsDetailView(@Nullable ViewGroup parent, News.ArticlesBean articlesBean) {
    return new RealNewsDetailView(layoutInflater, parent,  articlesBean);
  }
}
