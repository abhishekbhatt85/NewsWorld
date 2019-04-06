package com.example.newsworld.feature.newslist;

import com.example.newsworld.common.arch.ui.BaseObservable;
import com.example.newsworld.common.networks.NewsApi;
import com.example.newsworld.feature.newslist.model.News;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListUseCase extends BaseObservable<NewsListUseCase.Listener> {

  private final NewsApi newsApi;
  private Call<News> newsCall;
  private final int PAGE_COUNT = 50;
  public NewsListUseCase(NewsApi newsApi) {
    this.newsApi = newsApi;
  }

  public void fetchNewsListing(String country, String api_key) {
    newsCall = newsApi.topNews(country, api_key, PAGE_COUNT);
    newsCall.enqueue(new Callback<News>() {
      @Override
      public void onResponse(Call<News> call, Response<News> response) {
        if (!response.isSuccessful()) {
          newsCall = call.clone();
          newsCall.enqueue(this);
          return;
        }
        if (response.body() == null) {
          return;
        }
       notifySuccess(response.body());
      }

      @Override
      public void onFailure(Call<News> call, Throwable t) {
        notifyFailure();
      }
    });

  }

  private void notifyFailure() {
    for (Listener listener : getListeners()) {
      listener.onNewsListFailure();
    }
  }

  private void notifySuccess(News newsResponse) {
    for (NewsListUseCase.Listener listener : getListeners()) {
      listener.onNewsList(newsResponse);
    }
  }

  public interface Listener {

    void onNewsListFailure();

    void onNewsList(News newsResponse);

  }
}
