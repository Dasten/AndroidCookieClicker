package com.es.androidcookieclicker;


import java.math.BigDecimal;



import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ListActivity;
import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class GameActivity extends Activity {
	
	Handler handler;
	CookieThread cookieThread;
	
	TextView cookiesCount;
	TextView cps;
	
	ArrayAdapterCookie<LogicItems> adapterItemList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		cookiesCount = (TextView)findViewById(R.id.textNumberCookies);
		cps = (TextView)findViewById(R.id.cpsValue);
		
		
		
		ListView listLogicItems = (ListView)findViewById(R.id.itemsList);
		
		//Estos datos lo mejor es que vengan de un json y los cargamos desde aqui
		LogicItems[] items = {
				new LogicItems(1, "Cursor", 0.1, 15),
				new LogicItems(1, "Grandma", 0.5, 100),
				new LogicItems(1, "Farm", 4.0, 500),
				new LogicItems(1, "Factory", 10.0, 3000),
				new LogicItems(1, "Mine", 40.0, 10000),
				new LogicItems(1, "Shipment", 100.0, 40000),
				new LogicItems(1, "Alchemy Lab", 400.0, 200000),
				new LogicItems(1, "Portal", 6666.0, 1600000),
				new LogicItems(1, "Time Machine", 98765, 123456789),
				new LogicItems(1, "Antimatter Condenser", 999999, 3999999999L)
		};
		
		adapterItemList = new ArrayAdapterCookie<LogicItems>(this,
                android.R.layout.simple_list_item_1, items);
		
		listLogicItems.setAdapter(adapterItemList);
		cps.setText(LogicGame.getCps().toString());
		
		
		listLogicItems.setOnItemClickListener(new OnItemClickListener(){

	        @Override
	        public void onItemClick(AdapterView<?> adapter, View view, int position,
	                long id) {
	        
	        	LogicItems item = (LogicItems) adapter.getItemAtPosition(position);
	    		
	        	LogicGame.decrementCookies(item.getPrice());
	    		LogicGame.incrementCookiesPerSecond(item.getCps());
	    		item.updatePrice();
	    		
	    		adapterItemList.notifyDataSetChanged();
	        };
		});
		
		
		handler = new CookieHandler(cookiesCount, cps, adapterItemList);
		cookieThread = new CookieThread(handler);
	}
		

	//@Override
	/*public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}*/
	
	
	public void addCookies(View view) {
		LogicGame.incrementCookies();
		
		adapterItemList.notifyDataSetChanged();
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
