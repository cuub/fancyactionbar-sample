package com.cuubonandroid.fancyactionbar.sample;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import com.cuubonandroid.fancyactionbar.ListeningScrollView;

/**
 * 
 * @author <a href="http://www.hugofernandes.pt">Hugo Fernandes</a>
 * 
 */
public class TestActivity extends Activity {

  private Drawable actionBarDrawable;
  private ImageView headerView;
  private Callback callback = new Callback() {
    @Override
    public void invalidateDrawable(Drawable who) {
      getActionBar().setBackgroundDrawable(who);
    }

    @Override
    public void scheduleDrawable(Drawable who, Runnable what, long when) {
    }

    @Override
    public void unscheduleDrawable(Drawable who, Runnable what) {
    }
  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);

    actionBarDrawable = getResources().getDrawable(R.drawable.action_bar_bg);
    actionBarDrawable.setAlpha(0);
    getActionBar().setBackgroundDrawable(actionBarDrawable);
    headerView = (ImageView) findViewById(R.id.imageTop);

    ((ListeningScrollView) findViewById(R.id.scroll_view)).setActionBarBackgroundDrawable(actionBarDrawable,
        (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) ? callback : null);
    ((ListeningScrollView) findViewById(R.id.scroll_view)).setTransparentHeaderView(headerView);
    ((ListeningScrollView) findViewById(R.id.scroll_view)).setActionBarHeight(getActionBar().getHeight());
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.test, menu);
    return true;
  }
}
