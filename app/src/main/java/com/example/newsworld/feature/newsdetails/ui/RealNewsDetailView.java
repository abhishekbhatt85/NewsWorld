package com.example.newsworld.feature.newsdetails.ui;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import butterknife.BindView;
import com.bumptech.glide.Glide;
import com.example.newsworld.R;
import com.example.newsworld.common.arch.ui.BaseObservableView;
import com.example.newsworld.feature.newslist.model.News;

public class RealNewsDetailView extends
    BaseObservableView<NewsDetailView.Listener> implements NewsDetailView {

  @BindView(R.id.detailsTitleTextView)
  AppCompatTextView detailsTitleTextView;
  @BindView(R.id.detailsDescTextView)
  AppCompatTextView detailsDescTextView;
  @BindView(R.id.detailsImageView)
  AppCompatImageView detailsImageView;

  private final News.ArticlesBean articlesBean;

  @SuppressLint("InflateParams")
  public RealNewsDetailView(LayoutInflater inflater, ViewGroup parent, News.ArticlesBean articlesBean) {
    setRootView(inflater.inflate(R.layout.fragment_news_detail, null, false));
    this.articlesBean = articlesBean;
    initView();
  }

  private void initView() {
    detailsTitleTextView.setText(articlesBean.getTitle());
    detailsDescTextView.setText(articlesBean.getDescription() + " " + articlesBean.getContent());
    if (articlesBean.getUrlToImage() == null) {
      detailsImageView.setImageResource(R.drawable.no_image_available);
    } else
      Glide.with(getRootView())
          .asBitmap()
          .load(articlesBean.getUrlToImage())
          .into(detailsImageView);

  }
}
