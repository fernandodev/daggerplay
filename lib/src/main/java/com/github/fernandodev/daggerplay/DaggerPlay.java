package com.github.fernandodev.daggerplay;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.IntentService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fernando on 4/14/15.
 */
public class DaggerPlay {
  public static final DaggerPlay sharedInstance = new DaggerPlay();

  private ApplicationGraph applicationGraph;
  private List modules = new ArrayList(3);

  /**
   * Install Dagger
   *
   * @param application
   */
  public static void install(Application application) {
    sharedInstance.applicationGraph = new ApplicationGraph(application, sharedInstance.modules);
  }

  /**
   * Register possible modules that application has
   *
   * MUST BE CALLED BEFORE @see DaggerPlay#install
   *
   * @param modules
   */
  public static void registerModules(Object... modules) {

    for(Object module : modules)
      sharedInstance.modules.add(module);
  }

  public static void injectActivity(Activity activity) {
    sharedInstance.applicationGraph.injectActivity(activity);
  }

  public static void injectFragment(Activity activity, Fragment fragment) {
    sharedInstance.applicationGraph.injectFragment(activity, fragment);
  }

  public static void injectSupportFragment(Activity activity, android.support.v4.app.Fragment fragment) {
    sharedInstance.applicationGraph.injectSupportFragment(activity, fragment);
  }

  public static void injectService(IntentService service) {
    sharedInstance.applicationGraph.injectService(service);
  }
}
