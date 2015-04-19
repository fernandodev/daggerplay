package com.github.fernandodev.daggerplay;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import dagger.Module;
import dagger.Provides;

/**
 * Created by fernando on 10/13/14.
 */
@Module(library = true)
public class ApplicationModule {
  private Application application;

  public ApplicationModule(Application application) {
    this.application = application;
  }

  @Provides @WithApplication Context provideApplicationContext() {
    return application;
  }

  @Provides Resources provideResources() {
    return application.getResources();
  }

  @Provides Application provideApplication() {
    return application;
  }
}
