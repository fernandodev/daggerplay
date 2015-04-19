package com.github.fernandodev.daggerplaysample;

import android.app.Application;

import com.github.fernandodev.daggerplay.DaggerPlay;

/**
 * Created by fernando on 4/14/15.
 */
public class DaggerPlayApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    DaggerPlay.registerModules(new DaggerPlayModule());
    DaggerPlay.install(this);
  }
}
