package com.example.newsworld;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.example.newsworld.common.arch.ui.BaseActivity;
import com.example.newsworld.common.arch.ui.FragmentContainer;
import com.example.newsworld.feature.newsdetails.NewsDetailFragment;
import com.example.newsworld.feature.newslist.NewsListFragment;
import com.example.newsworld.feature.newslist.ui.MainView;

public class MainActivity extends BaseActivity implements FragmentContainer {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    MainView view = getCompositionRoot().getViewFactory().getMainView(getLayoutInflater());
    setContentView(view.getRootView());
    getCompositionRoot().getRouter().toNewsListPage();
  }

  @Override
  public FrameLayout getContainer() {
    return findViewById(R.id.container);
  }

  @Override
  public void onBackPressed() {
    if (getCompositionRoot().getRouter().getCurrentFragment() instanceof NewsDetailFragment) {
      getCompositionRoot().getRouter().toNewsListPage();
    } else if (getCompositionRoot().getRouter().getCurrentFragment() instanceof NewsListFragment) {
      super.onBackPressed();
    } else {
      super.onBackPressed();
    }
  }
}
