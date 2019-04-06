package com.example.newsworld.feature.newsdetails;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsworld.common.arch.ui.BaseFragment;
import com.example.newsworld.feature.newsdetails.ui.NewsDetailView;
import com.example.newsworld.feature.newslist.model.News;

import static com.example.newsworld.common.utils.Constant.ARTICLE;

public class NewsDetailFragment extends BaseFragment {

  private News.ArticlesBean articlesBean;

  private NewsDetailView view;

  public NewsDetailFragment() {
    // Required empty public constructor
  }

  /**
   * @return A new instance of fragment NewsDetailFragment.
   */
  public static NewsDetailFragment newInstance(News.ArticlesBean articlesBean) {
    NewsDetailFragment fragment = new NewsDetailFragment();
    Bundle args = new Bundle();
    args.putParcelable(ARTICLE, articlesBean);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null) {
      articlesBean = getArguments().getParcelable(ARTICLE);
    }
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    view = getCompositionRoot()
        .getViewFactory()
        .getNewsDetailView(container, articlesBean);
    return view.getRootView();
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }
}
