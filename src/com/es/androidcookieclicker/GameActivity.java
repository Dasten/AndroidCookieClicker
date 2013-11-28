package com.es.androidcookieclicker;


import java.math.BigDecimal;
import java.util.ArrayList;



import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListActivity;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {
	
	Handler handler;
	CookieThread cookieThread;
	
	TextView cookiesCount;
	TextView cps;
	
	Toast toast;
	
	ArrayAdapterCookie<LogicItems> adapterItemList;
	ArrayAdapterPowerUp<LogicPowerUps> adapterBoostList;
	

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		cookiesCount = (TextView)findViewById(R.id.textNumberCookies);
		cps = (TextView)findViewById(R.id.cpsValue);
		
		
		
		ListView listLogicItems = (ListView)findViewById(R.id.itemsList);
		ListView listBoost = (ListView)findViewById(R.id.powerUpsList);
		
		LogicItems[] items = {
				new LogicItems(1, "Cursor", 0.1, 15),
				new LogicItems(2, "Grandma", 0.5, 100),
				new LogicItems(3, "Farm", 4.0, 500),
				new LogicItems(4, "Factory", 10.0, 3000),
				new LogicItems(5, "Mine", 40.0, 10000),
				new LogicItems(6, "Shipment", 100.0, 40000),
				new LogicItems(7, "Alchemy Lab", 400.0, 200000),
				new LogicItems(8, "Portal", 6666.0, 1600000),
				new LogicItems(9, "Time Machine", 98765.0, 123456789),
				new LogicItems(10, "Antimatter Condenser", 999999.0, 3999999999L)
		};		
		
		
		LogicPowerUps[] pUps = {
				new LogicPowerUps(100, "Reinforced index finger", 0, 0.1, 100, 1, 1),
				new LogicPowerUps(101, "Ambidextrous", 1, 2, 10000, 10, 1),
				new LogicPowerUps(102, "Forwards from grandma", 0, 0.3, 1000, 1, 2),
				new LogicPowerUps(103, "Lubricated dentures", 1, 2, 100000, 10, 2),
				new LogicPowerUps(104, "Cheap hoes", 0, 1, 5000, 1, 3),
				new LogicPowerUps(105, "Cookie trees", 1, 2, 500000, 10, 3),
				new LogicPowerUps(106, "Sturdier conveyor belts", 0, 4, 30000, 1, 4),
				new LogicPowerUps(107, "Sweatshop", 1, 2, 3000000, 10, 4),
				new LogicPowerUps(108, "Sugar gas", 0, 10, 100000, 1, 5),
				new LogicPowerUps(109, "Ultradrill", 1, 2, 10000000, 10, 5),
				new LogicPowerUps(110, "Vanilla nebulae", 0, 30, 400000, 1, 6),
				new LogicPowerUps(111, "Frequent flyer", 1, 2, 40000000, 10, 6),
				new LogicPowerUps(112, "Antimony", 0, 100, 2000000, 1, 7),
				new LogicPowerUps(113, "True chocolate", 1, 2, 200000000, 10, 7),
				new LogicPowerUps(114, "Ancient tablet", 0, 1666, 16666660, 1, 8),
				new LogicPowerUps(115, "Soul bond", 1, 2, 1666666000, 10, 8),
				new LogicPowerUps(116, "Flux capacitors", 0, 9876, 1234567890, 1, 9),
				new LogicPowerUps(117, "Quantum conundrum", 1, 2, 98765456789L, 1, 9),
				new LogicPowerUps(118, "Sugar bosons", 0, 99999, 39999999990L, 1, 10),
				new LogicPowerUps(119, "Large macaron collider", 1, 2, 3999999999000L, 10, 10),
				new LogicPowerUps(120, "Sugar cookies", 1, 5, 99999999, 9999999, -1),
				new LogicPowerUps(121, "Double-chip cookies", 1, 10, 99999999999L, 999999999 , -1)
		};
		
		
		/*
		ArrayList<LogicPowerUps> pUps = new ArrayList<LogicPowerUps>();
		pUps.add(new LogicPowerUps(100, "Reinforced index finger", 0, 0.1, 100, 1, 1));
		pUps.add(new LogicPowerUps(101, "Ambidextrous", 1, 2, 10000, 10, 1));
		pUps.add(new LogicPowerUps(102, "Forwards from grandma", 0, 0.3, 1000, 1, 2));
		pUps.add(new LogicPowerUps(103, "Lubricated dentures", 1, 2, 100000, 10, 2));
		pUps.add(new LogicPowerUps(104, "Cheap hoes", 0, 1, 5000, 1, 3));
		pUps.add(new LogicPowerUps(105, "Cookie trees", 1, 2, 500000, 10, 3));
		pUps.add(new LogicPowerUps(106, "Sturdier conveyor belts", 0, 4, 30000, 1, 4));
		pUps.add(new LogicPowerUps(107, "Sweatshop", 1, 2, 3000000, 10, 4));
		pUps.add(new LogicPowerUps(108, "Sugar gas", 0, 10, 100000, 1, 5));
		pUps.add(new LogicPowerUps(109, "Ultradrill", 1, 2, 10000000, 10, 5));
		pUps.add(new LogicPowerUps(110, "Vanilla nebulae", 0, 30, 400000, 1, 6));
		pUps.add(new LogicPowerUps(111, "Frequent flyer", 1, 2, 40000000, 10, 6));
		pUps.add(new LogicPowerUps(112, "Antimony", 0, 100, 2000000, 1, 7));
		pUps.add(new LogicPowerUps(113, "True chocolate", 1, 2, 200000000, 10, 7));
		pUps.add(new LogicPowerUps(114, "Ancient tablet", 0, 1666, 16666660, 1, 8));
		pUps.add(new LogicPowerUps(115, "Soul bond", 1, 2, 1666666000, 10, 8));
		pUps.add(new LogicPowerUps(116, "Flux capacitors", 0, 9876, 1234567890, 1, 9));
		pUps.add(new LogicPowerUps(117, "Quantum conundrum", 1, 2, 98765456789L, 1, 9));
		pUps.add(new LogicPowerUps(118, "Sugar bosons", 0, 99999, 39999999990L, 1, 10));
		pUps.add(new LogicPowerUps(119, "Large macaron collider", 1, 2, 3999999999000L, 10, 10));
		pUps.add(new LogicPowerUps(120, "Sugar cookies", 1, 5, 99999999, 9999999, -1));
		pUps.add(new LogicPowerUps(121, "Double-chip cookies", 1, 10, 99999999999L, 999999999 , -1));
		 */
		
		
		
		
				
		adapterItemList = new ArrayAdapterCookie<LogicItems>(this,
                android.R.layout.simple_list_item_1, items);
				
		adapterBoostList = new ArrayAdapterPowerUp<LogicPowerUps>(this, 
				android.R.layout.simple_list_item_1, pUps);
		
				
		TextView headerListView = new TextView(this);
		headerListView.setText(R.string.text_header_list_items);
		headerListView.setTextColor(Color.WHITE);
		headerListView.setTextSize(20);
		headerListView.setTextColor(Color.BLACK);
		headerListView.setTypeface(null, Typeface.BOLD);
		
		listLogicItems.addHeaderView(headerListView);
		listLogicItems.setAdapter(adapterItemList);
		listLogicItems.setAlpha(0.7f);
		
	
		TextView headerBoostList = new TextView(this);
		headerBoostList.setText(R.string.text_header_list_boost);
		headerBoostList.setTextColor(Color.WHITE);
		headerBoostList.setTextSize(20);
		headerBoostList.setTextColor(Color.BLACK);
		headerBoostList.setTypeface(null, Typeface.BOLD);
		
		listBoost.addHeaderView(headerBoostList);
		listBoost.setAdapter(adapterBoostList);
		listBoost.setAlpha(0.7f);
		
			
		cps.setText(LogicGame.getCps().toString());
		
		listLogicItems.setOnItemClickListener(new OnItemClickListener(){

	        @Override
	        public void onItemClick(AdapterView<?> adapter, View view, int position,
	                long id) {
	        
	        	LogicItems item = (LogicItems) adapter.getItemAtPosition(position);
	    		
	        	LogicGame.decrementCookies(item.getPrice());
	    		LogicGame.incrementCookiesPerSecond(item.getCps());
	    		item.updatePrice();
	    		
	    		//Notificacion
	    		toast = Toast.makeText(getApplicationContext(),
	                    item.getName() + " Comprado!", Toast.LENGTH_SHORT);
	    		
	    		toast.setGravity(Gravity.TOP|Gravity.CENTER,0,0);
	    		toast.show();
	        };
		});
		
		
		listBoost.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view, int position, 
					long id){
				
				LogicPowerUps powerUpSeleccionada = (LogicPowerUps) adapter.getItemAtPosition(position);
				
				if(powerUpSeleccionada.getItemIdToBoost() == -1){
					/* Si el id del item que tenemos que upgradear es -1, el upgrade es sobre las cookies globales(CPS), */
					LogicGame.incrementCookiesPerSecond(((LogicGame.getCps()*(powerUpSeleccionada.getBoost()/100))));
				}else{
				
					LogicItems itemToUpgrade = adapterItemList.getItem(powerUpSeleccionada.getItemIdToBoost()-1);
					
					if(powerUpSeleccionada.getBoostType() == 1){
						/*Si el tipo de boost es 1 lo que hacemos es doblar la productividad del item*/
						itemToUpgrade.setCps(itemToUpgrade.getCps() * powerUpSeleccionada.getBoost());
					}else{
						/*Si el tipo de boost es 0 lo que hacemos es aumentar los Cps del item*/
						itemToUpgrade.setCps((itemToUpgrade.getCps() + powerUpSeleccionada.getBoost()));
					}	
				}	
	
				LogicGame.decrementCookies(powerUpSeleccionada.getPrice());
				//TO-DO Quitamos el elemento de la listview
					
	    		//Notificacion
	    		toast = Toast.makeText(getApplicationContext(),
	                    powerUpSeleccionada.getName() + " Comprado!", Toast.LENGTH_SHORT);
	    		
	    		toast.setGravity(Gravity.TOP|Gravity.CENTER,0,0);
	    		toast.show();
			};
		});
		
		LogicGame.setAdapter(adapterItemList);
		LogicGame.setAdapterPUps(adapterBoostList);
		
		handler = new CookieHandler(cookiesCount, cps, listLogicItems);
		cookieThread = new CookieThread(handler);
	}
	

	public void addCookies(View view) {
		LogicGame.incrementCookies();
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
