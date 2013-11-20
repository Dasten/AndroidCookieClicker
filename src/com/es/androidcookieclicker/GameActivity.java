package com.es.androidcookieclicker;


import java.math.BigDecimal;



import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class GameActivity extends Activity {
	
	Handler handler;
	CookieThread cookieThread;
	
	TextView cookiesCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		cookiesCount = (TextView)findViewById(R.id.numberCookies);
		
		handler = new CookieHandler(cookiesCount);
		cookieThread = new CookieThread(handler);
		
		/*
		setListAdapter(new ArrayAdapter<String>(this,
												android.R.layout.itemsList,
												items));
												*/		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}
	
	public void addCookies(View view) {
		LogicGame.incrementCookies();
		
		BigDecimal bd = new BigDecimal(LogicGame.getCookies());
		
		cookiesCount.setText(((Integer)bd.intValue()).toString());
	}
	
	public void onStart() {
		super.onStart();
		
		Thread backgroud = new Thread(cookieThread);
		cookieThread.isRunning.set(true);
		backgroud.start();
	}
	
	public void onStop() {
		super.onStop();
		cookieThread.isRunning.set(false);
	}

}
