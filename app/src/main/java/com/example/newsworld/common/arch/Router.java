package com.example.newsworld.common.arch;

import androidx.fragment.app.Fragment;
import com.example.newsworld.common.arch.ui.FragmentHelper;
import com.example.newsworld.feature.newsdetails.NewsDetailFragment;
import com.example.newsworld.feature.newslist.model.News;
import com.example.newsworld.feature.newslist.NewsListFragment;

public class Router {
  private final FragmentHelper frameHelper;

  public Router(FragmentHelper fragmentHelper) {
    frameHelper = fragmentHelper;
  }

  public void toNewsListPage() {
    frameHelper.replaceFragment(NewsListFragment.newInstance(),
        false, false);
  }

  public void toNewsDetailPage(News.ArticlesBean articlesBean) {
    frameHelper.replaceFragment(NewsDetailFragment.newInstance(articlesBean),
        false, false);
  }

  public Fragment getCurrentFragment() {
    return frameHelper.getCurrentFragment();
  }
}
