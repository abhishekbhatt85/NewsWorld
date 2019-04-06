package com.example.newsworld.common.arch.ui;

public interface ObservableView<T> extends ViewX {

  void registerListener(T listener);

  void unregisterListener(T listener);
}
