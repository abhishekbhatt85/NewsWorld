package com.example.newsworld.feature.newslist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.example.newsworld.R;
import com.example.newsworld.common.arch.ui.BaseFragment;
import com.example.newsworld.feature.newslist.model.News;
import com.example.newsworld.feature.newslist.ui.NewsListView;
import com.google.android.material.snackbar.Snackbar;

public class NewsListFragment extends BaseFragment
    implements NewsListUseCase.Listener, NewsListView.Listener {

  private NewsController controller;
  private NewsListView view;
  private NewsListUseCase newsListUseCase;

  public static NewsListFragment newInstance() {
    return new NewsListFragment();
  }

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {

    controller = getCompositionRoot().getNewsController();
    ItemSelectedListener itemSelectedListener =
        articlesBean -> controller.toNewsDetail(articlesBean);
    view = getCompositionRoot()
            .getViewFactory()
            .getNewsListView(container, itemSelectedListener);
    newsListUseCase = getCompositionRoot().getNewsUsecase();
    controller.bindView(view);
    controller.bindLifeCycle(getLifecycle());
    newsListUseCase.registerListener(this);
    return view.getRootView();
  }

  @Override
  public void onViewCreated(@NonNull View view,
      @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    this.view.showProgressBar();
    newsListUseCase.fetchNewsListing(getString(R.string.country),
        getString(R.string.api_key));
  }

  @Override
  public void onNewsListFailure() {
    Snackbar.make(view.getRootView(), getString(R.string.error_text),
        Snackbar.LENGTH_SHORT).show();
  }

  @Override
  public void onNewsList(News newsResponse) {
    view.bindData(newsResponse);
  }


  @Override
  public void toNewsDetail(News.ArticlesBean articlesItem) {
    controller.toNewsDetail(articlesItem);
  }


  public interface ItemSelectedListener {
    void onItemClicked(News.ArticlesBean articlesBean);
  }
}
