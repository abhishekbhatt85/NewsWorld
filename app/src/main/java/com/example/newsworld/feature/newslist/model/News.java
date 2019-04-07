package com.example.newsworld.feature.newslist.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

public class News implements Parcelable {

  private String status;
  private int totalResults;
  private List<ArticlesBean> articles;

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public int getTotalResults() {
    return totalResults;
  }

  public void setTotalResults(int totalResults) {
    this.totalResults = totalResults;
  }

  public List<ArticlesBean> getArticles() {
    return articles;
  }

  public void setArticles(List<ArticlesBean> articles) {
    this.articles = articles;
  }

  public static class ArticlesBean implements Parcelable {

    private SourceBean source;
    private String author;
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private String publishedAt;
    private String content;

    public SourceBean getSource() {
      return source;
    }

    public void setSource(SourceBean source) {
      this.source = source;
    }

    public String getAuthor() {
      return author;
    }

    public void setAuthor(String author) {
      this.author = author;
    }

    public String getTitle() {
      return title;
    }

    public void setTitle(String title) {
      this.title = title;
    }

    public String getDescription() {
      return description;
    }

    public void setDescription(String description) {
      this.description = description;
    }

    public String getUrl() {
      return url;
    }

    public void setUrl(String url) {
      this.url = url;
    }

    public String getUrlToImage() {
      return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
      this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
      return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
      this.publishedAt = publishedAt;
    }

    public String getContent() {
      return content;
    }

    public void setContent(String content) {
      this.content = content;
    }

    public static class SourceBean implements Parcelable {
      private String id;
      private String name;

      public String getId() {
        return id;
      }

      public void setId(String id) {
        this.id = id;
      }

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }

      @Override public int describeContents() {
        return 0;
      }

      @Override public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
      }

      public SourceBean() {
      }

      protected SourceBean(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
      }

      public static final Creator<SourceBean> CREATOR = new Creator<SourceBean>() {
        @Override public SourceBean createFromParcel(Parcel source) {
          return new SourceBean(source);
        }

        @Override public SourceBean[] newArray(int size) {
          return new SourceBean[size];
        }
      };
    }

    @Override public int describeContents() {
      return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
      dest.writeParcelable(this.source, flags);
      dest.writeString(this.author);
      dest.writeString(this.title);
      dest.writeString(this.description);
      dest.writeString(this.url);
      dest.writeString(this.urlToImage);
      dest.writeString(this.publishedAt);
      dest.writeString(this.content);
    }

    public ArticlesBean() {
    }

    protected ArticlesBean(Parcel in) {
      this.source = in.readParcelable(SourceBean.class.getClassLoader());
      this.author = in.readString();
      this.title = in.readString();
      this.description = in.readString();
      this.url = in.readString();
      this.urlToImage = in.readString();
      this.publishedAt = in.readString();
      this.content = in.readString();
    }

    public static final Creator<ArticlesBean> CREATOR = new Creator<ArticlesBean>() {
      @Override public ArticlesBean createFromParcel(Parcel source) {
        return new ArticlesBean(source);
      }

      @Override public ArticlesBean[] newArray(int size) {
        return new ArticlesBean[size];
      }
    };
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.status);
    dest.writeInt(this.totalResults);
    dest.writeList(this.articles);
  }

  public News() {
  }

  protected News(Parcel in) {
    this.status = in.readString();
    this.totalResults = in.readInt();
    this.articles = new ArrayList<ArticlesBean>();
    in.readList(this.articles, ArticlesBean.class.getClassLoader());
  }

  public static final Parcelable.Creator<News> CREATOR = new Parcelable.Creator<News>() {
    @Override public News createFromParcel(Parcel source) {
      return new News(source);
    }

    @Override public News[] newArray(int size) {
      return new News[size];
    }
  };
}
