package com.github.fernandodev.daggerplay;

import android.app.Activity;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando on 4/14/15.
 */
@Module(library = true)
public class ActivityModule {
  private Activity activity;

  public void setActivity(Activity activity) {
    this.activity = activity;
  }

  @Provides @WithActivity Context provideActivityContext() {
    return activity;
  }

  @Provides Activity provideActivity() { return activity; }
}
