package com.example.newsworld.feature.newslist.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import com.example.newsworld.R;
import com.example.newsworld.common.arch.ui.BaseObservableView;
import com.example.newsworld.feature.newslist.NewsListFragment;
import com.example.newsworld.feature.newslist.model.News;
import com.example.newsworld.feature.newslist.adaptor.NewsAdaptor;

public class RealNewsListView extends BaseObservableView<NewsListView
    .Listener> implements NewsListView {

  @BindView(R.id.recyclerViewNewsList)
  RecyclerView newsRecyclerView;

  @BindView(R.id.progressBar)
  ProgressBar progressBar;

  @Nullable
  private NewsAdaptor newsAdaptor;

  private final NewsListFragment.ItemSelectedListener itemSelectedListener;

  public RealNewsListView(LayoutInflater inflater, @Nullable ViewGroup parent, @NonNull
      NewsListFragment.ItemSelectedListener itemSelectedListener) {
    setRootView(inflater.inflate(R.layout.newslist_fragment, parent, false));
    this.itemSelectedListener = itemSelectedListener;
    initViews();
  }

  private void initViews() {
    newsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
  }

  @Override
  public void showProgressBar() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideProgressBar() {
    progressBar.setVisibility(View.GONE);
    newsRecyclerView.setVisibility(View.VISIBLE);
  }

  @Override
  public void bindData(@Nullable News news) {
    if (news != null) {
      hideProgressBar();
      newsAdaptor = new NewsAdaptor(getContext(), news.getArticles(), itemSelectedListener);
      newsRecyclerView.setAdapter(newsAdaptor);
    }
  }

  public interface OnBasketInteraction {
    void goBack();
  }
}
