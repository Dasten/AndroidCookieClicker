package com.es.androidcookieclicker;


import java.util.ArrayList;
import java.util.List;



import android.os.Bundle;
import android.os.Handler;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends Activity {
	
	Handler handler;
	CookieThread cookieThread;
	
	TextView cookiesCount;
	TextView cps;
	
	Toast toast;
	
	ArrayAdapterCookie adapterItemList;
	ArrayAdapterPowerUp adapterBoostList;
	

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		
		cookiesCount = (TextView)findViewById(R.id.textNumberCookies);
		cps = (TextView)findViewById(R.id.cpsValue);
		
		
		
		ListView listLogicItems = (ListView)findViewById(R.id.itemsList);
		ListView listBoost = (ListView)findViewById(R.id.powerUpsList);
		
		List<LogicItems> items = new ArrayList<LogicItems>();
		
		items.add(new LogicItems(1, "Cursor", 0.1, 15, "Autoclicks once every 10 seconds."));
		items.add(new LogicItems(2, "Grandma", 0.5, 100, "A nice grandma to bake more cookies."));
		items.add(new LogicItems(3, "Farm", 4.0, 500, "Grows cookie plants from cookie seeds."));
		items.add(new LogicItems(4, "Factory", 10.0, 3000, "Produces large quantities of cookies."));
		items.add(new LogicItems(5, "Mine", 40.0, 10000, "Mines out cookie dough and chocolate chips."));
		items.add(new LogicItems(6, "Shipment", 100.0, 40000, "Brings in fresh cookies from the cookie planet."));
		items.add(new LogicItems(7, "Alchemy Lab", 400.0, 200000, "Turns gold into cookies!"));
		items.add(new LogicItems(8, "Portal", 6666.0, 1600000, "Opens a door to the cookieverse"));
		items.add(new LogicItems(9, "Time Machine", 98765.0, 123456789, "Brings cookies from the past, before they were even eaten."));
		items.add(new LogicItems(10, "Antimatter Condenser", 999999.0, 3999999999L, "Condenses the antimatter in the universe into cookies."));
		
		LogicGame.setItems(items);
	
		
		List<LogicPowerUps> pUps = new ArrayList<LogicPowerUps>();
		
		pUps.add(new LogicPowerUps(100, "Reinforced index finger", 0, 0.1, 10, 1, 1));		
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
		
		LogicGame.setPups(pUps);		
		
				
		adapterItemList = new ArrayAdapterCookie(this,
                android.R.layout.simple_list_item_1, LogicGame.getItems());
						
		adapterBoostList = new ArrayAdapterPowerUp(this, 
				android.R.layout.simple_list_item_1, LogicGame.getPupsAvailable());
		
		
		
				
		TextView headerListView = new TextView(this);
		headerListView.setText(R.string.text_header_list_items);
		headerListView.setTextColor(Color.WHITE);
		headerListView.setTextSize(20);
		headerListView.setTextColor(Color.BLACK);
		headerListView.setTypeface(null, Typeface.BOLD);
		
		listLogicItems.addHeaderView(headerListView, null, false);
		listLogicItems.setAdapter(adapterItemList);
		listLogicItems.setAlpha(0.7f);
		
	
		TextView headerBoostList = new TextView(this);
		headerBoostList.setText(R.string.text_header_list_boost);
		headerBoostList.setTextColor(Color.WHITE);
		headerBoostList.setTextSize(20);
		headerBoostList.setTextColor(Color.BLACK);
		headerBoostList.setTypeface(null, Typeface.BOLD);
		
		listBoost.addHeaderView(headerBoostList, null, false);
		listBoost.setAdapter(adapterBoostList);
		listBoost.setAlpha(0.7f);
		
			
		cps.setText(LogicGame.getCps().toString());
		
		listLogicItems.setOnItemClickListener(new OnItemClickListener(){

	        @Override
	        public void onItemClick(AdapterView<?> adapter, View view, int position,
	                long id) {
	        
	        	LogicItems item = (LogicItems) adapter.getItemAtPosition(position);
	        	
	        	if(item.isPurchasable()) {
	    		
		        	LogicGame.decrementCookies(item.getPrice());
		    		LogicGame.incrementCookiesPerSecond(item.getCps());
		    		item.incrementLevel();
		    		item.updatePrice();
		    		
		    		//Notificacion
		    		showNotification(item.getName() + " Comprado!");
		    		
	        	}
	        };
	    });
		
		listLogicItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			 public boolean onItemLongClick(AdapterView<?> adapter, View view,
                    int position, long id) {
	        	
	        	final LogicItems item = (LogicItems) adapter.getItemAtPosition(position);
                
	        	Builder alert = createDialogFromActivity(item.getName()+" ("+ item.getLevel(), item.getDescription());
	        	
	        	alert.setPositiveButton("Sell(1)",
	        			new DialogInterface.OnClickListener() {
		        			public void onClick(DialogInterface dialog, int which) {
		        				
        				if(item.getLevel() > 0) {
		                	item.decrementLevel();
		                	double refund = item.getPrice()/2;
		                	LogicGame.incrementCookies(refund);
		                	item.updatePrice();
		                	
		                	showNotification(item.getName()+" Vendido! (+" + refund + " cookies)");
	                    } else {
	                    	showNotification("No tienes ninguna copia de este item! (grrr)");
	                    }
	                    
	                    dialog.dismiss();
	                }});
	        	
	        	alert.setNegativeButton("Close", new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
	        		
	        	});
                
	        	alert.create().show();
	        	
                return true;
            }
			
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
				
				powerUpSeleccionada.setRemoved(true);
					
	    		//Notificacion
				showNotification(powerUpSeleccionada.getName() + " Comprado!");
			};
		});
				
		handler = new CookieHandler(cookiesCount, cps, listLogicItems, listBoost);
		cookieThread = new CookieThread(handler);
		
	}
	

	public void addCookies(View view) {
		LogicGame.incrementCookies();
	}
	
	public void showNotification(String message) {
		toast = Toast.makeText(getApplicationContext(),
                message, Toast.LENGTH_SHORT);
		
		toast.setGravity(Gravity.TOP|Gravity.CENTER,0,0);
		toast.show();
	}
	
	public Builder createDialogFromActivity(String title, String message) {
		Builder alert = new AlertDialog.Builder(this);
		alert.setTitle(title);
		alert.setMessage(message);	
		
		return alert;
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
