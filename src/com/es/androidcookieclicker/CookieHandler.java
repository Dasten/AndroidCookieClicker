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
 *
 */
public class CookieHandler extends Handler {
		
	TextView textViewNoc;
	TextView textViewCps;
	ListView listItems;
	ListView listPowerUps;
	
	
	CookieHandler(TextView textViewNoc, TextView textViewCps, ListView listItems, ListView listPowerUps) {
		this.textViewNoc = textViewNoc;
		this.textViewCps = textViewCps;
		this.listItems = listItems;
		this.listPowerUps = listPowerUps;
		
	}
	
	@Override
	public void handleMessage(Message msg) {
		Double noc = msg.getData().getDouble(LogicGame.noc_string);
		Double cps = msg.getData().getDouble(LogicGame.cps_string);
		
		BigDecimal bd = new BigDecimal(noc);
		
		textViewNoc.setText(LogicGame.formatNumber(((Integer)bd.intValue())));
		
		//Format numero (mostrar solo un decimal)
		DecimalFormat df= new DecimalFormat("#0.0");
		
		textViewCps.setText(df.format(cps));
		
		updateListViewItemsManual();
		updateListViewPowerUpsManual();
	}
	
	private void updateListViewItemsManual() {
		int start = listItems.getFirstVisiblePosition();
		int end = listItems.getLastVisiblePosition();
		for(int i = start; i <=end; i++) {		
	        View view = listItems.getChildAt(i-start);
	        listItems.getAdapter().getView(i, view, listItems);
		}
	}
	
	private void updateListViewPowerUpsManual() {
		int start = listPowerUps.getFirstVisiblePosition();
		int end = listPowerUps.getLastVisiblePosition();
		for(int i = start; i <=end; i++) {		
	        View view = listPowerUps.getChildAt(i-start);
	        listPowerUps.getAdapter().getView(i, view, listPowerUps);
		}
	}
}
