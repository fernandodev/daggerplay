package com.github.fernandodev.daggerplaysample;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by fernando on 4/14/15.
 */
public class UsefulHelper {

  private Context mContext;

  public UsefulHelper(Context context) {
    mContext = context;
  }

  public void doSomething() {
    Log.d("DaggerPlay", "UsefulHelper with " + mContext);
  }

  public void updateTextViewMessage(TextView textView) {
    textView.setText("UsefulHelper injected");
  }
}
