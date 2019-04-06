package com.example.newsworld.common.arch.di;

import android.content.Context;
import android.view.LayoutInflater;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.example.newsworld.common.arch.Router;
import com.example.newsworld.common.arch.ViewFactory;
import com.example.newsworld.common.arch.ui.FragmentContainer;
import com.example.newsworld.common.arch.ui.FragmentHelper;
import com.example.newsworld.common.networks.ApiClient;
import com.example.newsworld.common.networks.NewsApi;
import com.example.newsworld.feature.newslist.NewsController;
import com.example.newsworld.feature.newslist.NewsListUseCase;

public class CompRootUi {

  private final AppCompatActivity activity;

  public CompRootUi(AppCompatActivity activity) {
    this.activity = activity;
  }

  private AppCompatActivity getActivity() {
    return activity;
  }

  private Context getContext() {
    return activity;
  }

  private LayoutInflater getLayoutInflater() {
    return LayoutInflater.from(getContext());
  }

  public ViewFactory getViewFactory() {
    return new ViewFactory(getLayoutInflater());
  }

  private FragmentContainer getFragmentFrameWrapper() {
    return (FragmentContainer) getActivity();
  }

  private FragmentManager getFragmentManager() {
    return getActivity().getSupportFragmentManager();
  }

  private FragmentHelper getFragmentFrameHelper() {
    return new FragmentHelper(getActivity(), getFragmentFrameWrapper(), getFragmentManager());
  }

  public Router getRouter() {
    return new Router(getFragmentFrameHelper());
  }

  public NewsListUseCase getNewsUsecase() {
    return new NewsListUseCase(getNewsApi());
  }

  private NewsApi getNewsApi() {
    return ApiClient.getClient().create(NewsApi.class);
  }

  public NewsController getNewsController() {
    return new NewsController(getRouter());
  }
}
