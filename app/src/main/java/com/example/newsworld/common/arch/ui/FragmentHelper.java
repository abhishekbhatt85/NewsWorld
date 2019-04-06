package com.example.newsworld.common.arch.ui;

import android.app.Activity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentHelper {

  private final Activity activity;
  private final FragmentContainer frameWrapper;
  private final FragmentManager fragmentManager;

  public FragmentHelper(Activity activity, FragmentContainer fragmentContainer,
      FragmentManager fragmentManager) {
    this.activity = activity;
    frameWrapper = fragmentContainer;
    this.fragmentManager = fragmentManager;
  }

  public void replaceFragment(Fragment newFragment) {
    replaceFragment(newFragment, true);
  }

  public void replaceFragment(Fragment newFragment, boolean addToBackStack) {
    replaceFragment(newFragment, addToBackStack, false);
  }

  public void replaceFragment(Fragment newFragment, boolean addToBackStack,
      boolean clearBackStack) {
    if (clearBackStack) {
      if (fragmentManager.isStateSaved()) {
        return;
      }
      fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

    FragmentTransaction ft = fragmentManager.beginTransaction();

    if (addToBackStack) {
      ft.addToBackStack(null);
    }

    ft.replace(getFragmentFrameId(), newFragment, null);

    if (fragmentManager.isStateSaved()) {
      ft.commitAllowingStateLoss();
    } else {
      ft.commit();
    }
  }

  public Fragment getCurrentFragment() {
    return fragmentManager.findFragmentById(getFragmentFrameId());
  }

  private void removeCurrentFragment() {
    FragmentTransaction ft = fragmentManager.beginTransaction();
    ft.remove(getCurrentFragment());
    ft.commit();
  }

  private int getFragmentFrameId() {
    return frameWrapper.getContainer().getId();
  }

}
