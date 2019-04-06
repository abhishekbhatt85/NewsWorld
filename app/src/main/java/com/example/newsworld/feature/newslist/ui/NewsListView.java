package com.example.newsworld.feature.newslist.ui;

import androidx.annotation.Nullable;
import com.example.newsworld.common.arch.ui.ObservableView;
import com.example.newsworld.feature.newslist.model.News;

public interface NewsListView extends ObservableView<NewsListView.Listener> {

  void showProgressBar();

  void hideProgressBar();

  void bindData(@Nullable News newsResponse);

  public interface Listener {

    void toNewsDetail(News.ArticlesBean articlesItem);
  }
}
