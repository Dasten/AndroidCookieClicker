package com.es.androidcookieclicker;


import java.math.BigDecimal;



import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ListActivity;
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
		
		handler = new CookieHandler(cookiesCount);
		cookieThread = new CookieThread(handler);
		
		ListView listLogicItems = (ListView)findViewById(R.id.itemsList);
		
		//Estos datos lo mejor es que vengan de un json y los cargamos desde aqui
		LogicItems[] items = {
				new LogicItems(1, "Cursor", 0.1, 15, 1.14),
				new LogicItems(1, "Grandma", 1.0, 25, 1.2),
				new LogicItems(1, "Farm", 0.5, 15, 2.0),
				new LogicItems(1, "Factory", 4.0, 15, 2.5),
				new LogicItems(1, "Mine", 5.0, 15, 3.0),
				//new LogicItems(1, "Shipment", 100.0, 40.000, factor)
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
	    		
	    		cps.setText(LogicGame.getCps().toString());
	    		showCookies();
	        };
		});
	}
		

	//@Override
	/*public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}*/
	
	
	public void addCookies(View view) {
		LogicGame.incrementCookies();
		
		showCookies();
	}
	
	private void showCookies() {
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
