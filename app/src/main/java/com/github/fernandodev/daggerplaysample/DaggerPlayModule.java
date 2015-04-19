package com.github.fernandodev.daggerplaysample;

import android.content.Context;

import com.github.fernandodev.daggerplay.WithActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando on 4/14/15.
 */
@Module(
    injects = {
        MainActivity.class
    },
    library = true,
    complete = false,
    overrides = false
)
public class DaggerPlayModule {

  @Provides UsefulHelper provideUsefulHelper(@WithActivity Context context) {
    return new UsefulHelper(context);
  }
}
