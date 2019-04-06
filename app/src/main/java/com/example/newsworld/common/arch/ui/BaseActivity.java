package com.example.newsworld.common.arch.ui;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import com.example.com.google.errorprone.annotations.concurrent.LazyInit;
import com.example.newsworld.common.arch.di.CompRootUi;

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {

  @LazyInit
  private CompRootUi compRoot;

  protected CompRootUi getCompositionRoot() {
    if (compRoot == null) {
      compRoot = new CompRootUi(this);
    }
    return compRoot;
  }
}
