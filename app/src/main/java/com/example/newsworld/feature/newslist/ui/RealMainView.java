package com.example.newsworld.feature.newslist.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import com.example.newsworld.R;
import com.example.newsworld.common.arch.ui.BaseObservableView;

public class RealMainView extends BaseObservableView<MainView.Listener> implements MainView {

  @BindView(R.id.tool_bar)
  Toolbar toolbar;

  @SuppressLint("InflateParams")
  public RealMainView(LayoutInflater inflater) {
    setRootView(inflater.inflate(R.layout.activity_main, null, false));
    initView();
  }

  private void initView() {
    toolbar.setTitle(R.string.app_name);
  }

  public interface BackButtonInteraction {
    void goBack();
  }
}
