package it.mobimentum.phonegapspinnerplugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.R.bool;
import android.app.Activity;
import android.os.Handler;
import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SpinnerPlugin extends CordovaPlugin {
	
	private static final String PARAM_SHOW_OVERLAY = "overlay";
	private static final String PARAM_SHOW_TIMEOUT = "timeout";
	private static final String PARAM_IS_FULLSCREEN = "fullscreen";
	private static Activity activity;
	private static Dialog dialog;
	
	private boolean isShown = false;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

		activity = this.cordova.getActivity();
		
		if (action.equals("show"))
		{
			if( !isShown )
			{
				isShown = true;

				// Show
				show(activity);
			}
			
			callbackContext.success();
			return true;
		}
		else if (action.equals("hide"))
		{
			if( isShown )
			{
				isShown = false;
				
				// Hide
				hide(activity);
			}
			
			callbackContext.success();
			return true;
		}
		
		callbackContext.error("Spinner received invalid action '"+action+"'");
		return false;
	}
	
	private boolean show(final Activity activity) {
		// Loading spinner
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				dialog = new Dialog(activity,android.R.style.Theme_Translucent_NoTitleBar);
                ProgressBar progressBar = new ProgressBar(activity,null,android.R.attr.progressBarStyle);

                TextView textView = new TextView(activity,null,android.R.attr.textAppearanceMedium);
                textView.setText("Procesando");
                textView.setTextColor(Color.WHITE);
                LinearLayout.LayoutParams paramsTextView = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                paramsTextView.setMargins(0,20,0,0);
                textView.setLayoutParams(paramsTextView);

                LinearLayout linearLayout = new LinearLayout(activity);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                RelativeLayout layoutPrincipal = new RelativeLayout(activity);
                layoutPrincipal.setBackgroundColor(Color.parseColor("#d9000000"));

                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params.addRule(RelativeLayout.CENTER_IN_PARENT);

                linearLayout.addView(progressBar);
                linearLayout.addView(textView);
                linearLayout.setLayoutParams(params);

                layoutPrincipal.addView(linearLayout);

                dialog.setContentView(layoutPrincipal);
                dialog.show();
			}
	  	});
		
		return true;
	}
	
	private boolean hide(Activity context) {
		// Loading spinner
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				dialog.hide();
			}
	  	});
		
		
		return true;
	}

	@Override
    public void onBackPressed() {
        //detenerLoading();
    }
}
