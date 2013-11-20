package com.es.androidcookieclicker;


import java.math.BigDecimal;



import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class GameActivity extends Activity {
	
	Handler handler;
	CookieThread cookieThread;
	
	TextView cookiesCount;
	
	ArrayAdapter<LogicItems> adapterItemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		cookiesCount = (TextView)findViewById(R.id.numberCookies);
		
		handler = new CookieHandler(cookiesCount);
		cookieThread = new CookieThread(handler);
		
		ListView listLogicItems = (ListView)findViewById(R.id.itemsList);
		
		//Estos datos lo mejor es que vengan de un json y los cargamos desde aqui
		LogicItems[] items = {
				new LogicItems(1, "Cursor", 15, 0.5),
				new LogicItems(1, "Grandma", 15, 0.5),
				new LogicItems(1, "Farm", 15, 0.5),
				new LogicItems(1, "Factory", 15, 0.5),
				new LogicItems(1, "Mine", 15, 0.5)
		};
		
		adapterItemList = new ArrayAdapter<LogicItems>(this,
                android.R.layout.simple_list_item_1, items);
		
		listLogicItems.setAdapter(adapterItemList);	
		
	}

	//@Override
	/*public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}*/
	
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
