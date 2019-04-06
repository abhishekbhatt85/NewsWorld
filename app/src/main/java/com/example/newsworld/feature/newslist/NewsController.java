package com.example.newsworld.feature.newslist;

import androidx.annotation.NonNull;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.example.com.google.errorprone.annotations.concurrent.LazyInit;
import com.example.newsworld.common.arch.Router;
import com.example.newsworld.feature.newslist.model.News;
import com.example.newsworld.feature.newslist.ui.NewsListView;

public class NewsController implements NewsListView.Listener {
  @LazyInit
  private NewsListView view;

  @NonNull
  private final Router router;


  public NewsController(@NonNull Router router) {
    this.router = router;
  }

  void bindView(NewsListView view) {
    this.view = view;
  }

  void bindLifeCycle(Lifecycle lifecycle) {
    lifecycle.addObserver(new DefaultLifecycleObserver() {
      @Override public void onCreate(@NonNull LifecycleOwner owner) {
        view.registerListener(NewsController.this);
      }

      @Override public void onStart(@NonNull LifecycleOwner owner) {
      }

      @Override public void onStop(@NonNull LifecycleOwner owner) {
        view.unregisterListener(NewsController.this);
      }
    });
  }

  @Override
  public void toNewsDetail(News.ArticlesBean articlesItem) {
    router.toNewsDetailPage(articlesItem);
  }
}
