/**
 * 
 */
package com.es.androidcookieclicker;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author pfranco
 * @author Carlos B
 *
 */
public class CookieHandler extends Handler {
		
	TextView textViewNoc;
	TextView textViewCps;
	TextView textViewCpc;
	ListView listItems;
	ListView listPowerUps;
	
	/**
	 * Instantiates a new cookie handler.
	 *
	 * @param textViewNoc the text view noc
	 * @param textViewCps the text view cps
	 * @param textViewCpc the text view cpc
	 * @param listItems the list items
	 * @param listPowerUps the list power ups
	 */
	CookieHandler(TextView textViewNoc, TextView textViewCps, TextView textViewCpc, ListView listItems, ListView listPowerUps) {
		this.textViewNoc = textViewNoc;
		this.textViewCps = textViewCps;
		this.textViewCpc = textViewCpc;
		this.listItems = listItems;
		this.listPowerUps = listPowerUps;	
	}
	
	@Override
	public void handleMessage(Message msg) {
		//Restore all data from thread
		Double noc = msg.getData().getDouble(LogicGame.noc_string);
		Double cps = msg.getData().getDouble(LogicGame.cps_string);
		Double cpc = msg.getData().getDouble(LogicGame.cpc_string);
		
		BigDecimal bd = new BigDecimal(noc);
		
		//Show number of cookies
		textViewNoc.setText(LogicGame.formatNumber(((Integer)bd.intValue())));
		
		//Format number (show only one decimal)
		DecimalFormat df= new DecimalFormat("#0.0");
		
		//Show cps and cpc
		textViewCps.setText(df.format(cps));
		textViewCpc.setText(df.format(cpc));
		
		//Manual update all rows of listviews
		updateListViewItemsManual();
		updateListViewPowerUpsManual();
	}
	
	/**
	 * Update list view items manual.
	 */
	private void updateListViewItemsManual() {
		int start = listItems.getFirstVisiblePosition();
		int end = listItems.getLastVisiblePosition();
		for(int i = start; i <=end; i++) {		
	        View view = listItems.getChildAt(i-start);
	        listItems.getAdapter().getView(i, view, listItems);
		}
	}
	
	/**
	 * Update list view power ups manual.
	 */
	private void updateListViewPowerUpsManual() {
		int start = listPowerUps.getFirstVisiblePosition();
		int end = listPowerUps.getLastVisiblePosition();
		for(int i = start; i <=end; i++) {		
	        View view = listPowerUps.getChildAt(i-start);
	        listPowerUps.getAdapter().getView(i, view, listPowerUps);
		}
	}
}
