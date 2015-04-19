package com.github.fernandodev.daggerplay;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.IntentService;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by fernando on 10/13/14.
 */
public class ApplicationGraph {
  ObjectGraph graph;
  ApplicationModule applicationModule;
  ActivityModule activityModule;

  public ApplicationGraph(Application application, List registeredModules) {
    applicationModule = new ApplicationModule(application);
    activityModule = new ActivityModule();

    registeredModules.add(applicationModule);
    registeredModules.add(activityModule);

    Object[] modules = registeredModules.toArray();
    graph = ObjectGraph.create(modules);
  }

  public void injectActivity(Activity activity) {
    activityModule.setActivity(activity);
    graph.inject(activity);
  }

  public void injectFragment(Activity activity, Fragment fragment) {
    activityModule.setActivity(activity);
    graph.inject(fragment);
  }

  public void injectSupportFragment(Activity activity, android.support.v4.app.Fragment fragment) {
    activityModule.setActivity(activity);
    graph.inject(fragment);
  }

  public void injectService(IntentService service) {
    graph.inject(service);
  }
}
