package it.mobimentum.phonegapspinnerplugin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class ProgressActivity extends Activity {
	
	public static final String ACTION_HIDE_PROGRESS = "ProgressActivity.ACTION_HIDE_PROGRESS";
	
	//private static final String TAG = ProgressActivity.class.getSimpleName();
	private static Activity activity;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Remove title bar
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		activity = this;
		// Intent
		Intent intent = getIntent();
		//Log.i(TAG, "Intent: "+intent.getAction()+" / "+intent.hasExtra(ACTION_HIDE_PROGRESS));
		if (intent.hasExtra(ACTION_HIDE_PROGRESS)) {
			finish();
			this.overridePendingTransition(0, 0);
			
			return;
		}

		// ProgressBar
		ProgressBar progressBar = new ProgressBar(this,null,android.R.attr.progressBarStyle);

        TextView textView = new TextView(this,null,android.R.attr.textAppearanceMedium);
        textView.setText("Procesando");
        textView.setTextColor(Color.WHITE);
        LinearLayout.LayoutParams paramsTextView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        paramsTextView.setMargins(0,20,0,0);
        textView.setLayoutParams(paramsTextView);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        RelativeLayout layoutPrincipal = new RelativeLayout(this);
        layoutPrincipal.setBackgroundColor(Color.parseColor("#d9000000"));

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);

        linearLayout.addView(progressBar);
        linearLayout.addView(textView);
        linearLayout.setLayoutParams(params);

        layoutPrincipal.addView(linearLayout);
        setTheme(android.R.style.Theme_Translucent_NoTitleBar);
        setContentView(layoutPrincipal);
	}
	
	public static void detenerLoading(){
		if(activity != null){
			activity.finish();
			activity.overridePendingTransition(0, 0);
			activity = null;
		}
		
	}

	@Override
    public void onBackPressed() {
        //detenerLoading();
    }
}
