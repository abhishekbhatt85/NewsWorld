package com.example.newsworld.feature.newslist.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.newsworld.R;
import com.example.newsworld.feature.newslist.NewsListFragment;
import com.example.newsworld.feature.newslist.model.News;
import java.util.List;

public class NewsAdaptor extends RecyclerView.Adapter<NewsAdaptor.NewsViewHolder> {
  private Context ctx;
  private List<News.ArticlesBean> newsList;
  private final NewsListFragment.ItemSelectedListener itemSelectedListener;
  public NewsAdaptor(Context ctx, List<News.ArticlesBean> articlesItemList,
      NewsListFragment.ItemSelectedListener itemSelectedListener) {
    this.ctx = ctx;
    this.newsList = articlesItemList;
    this.itemSelectedListener = itemSelectedListener;
  }

  @NonNull
  @Override
  public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
      int viewType) {
    View view = LayoutInflater.from(ctx)
        .inflate(R.layout.news_list_item, parent, false);
    return new NewsViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
    holder.title.setText(newsList.get(position).getTitle());
    holder.articlesBean = newsList.get(position);
    if (newsList.get(position).getUrlToImage() == null) {
      holder.displayImage.setImageResource(R
          .drawable.no_image_available);
    } else {
      Glide.with(ctx)
          .asBitmap()
          .load(newsList.get(position).getUrlToImage())
          .into(holder.displayImage);
    }
  }


  @Override
  public int getItemCount() {
    return newsList.size();
  }

  /**
   * View Holder Class
   */
  class NewsViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    ImageView displayImage;
    CardView cardView;
    News.ArticlesBean articlesBean;
    NewsViewHolder(final View itemView) {
      super(itemView);
      title = itemView.findViewById(R.id.itemTextView);
      displayImage = itemView.findViewById(R.id.itemImageView);
      cardView = itemView.findViewById(R.id.listCardView);
      cardView.setOnClickListener(v -> itemSelectedListener.onItemClicked(articlesBean));
    }
  }
}

