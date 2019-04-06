package com.example.newsworld.common.arch.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.example.com.google.errorprone.annotations.concurrent.LazyInit;
import com.example.newsworld.common.arch.di.CompRootUi;

public class BaseFragment extends Fragment {

  @LazyInit
  private CompRootUi compRoot;

  protected CompRootUi getCompositionRoot() {
    if (compRoot == null) {
      compRoot =
          new CompRootUi((AppCompatActivity) requireActivity());
    }
    return compRoot;
  }
}
