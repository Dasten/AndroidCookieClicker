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
	
	CookieHandler(TextView textViewNoc, TextView textViewCps, ListView listItems) {
		this.textViewNoc = textViewNoc;
		this.textViewCps = textViewCps;
		this.listItems = listItems;
		
	}
	
	@Override
	public void handleMessage(Message msg) {
		Double noc = msg.getData().getDouble(LogicGame.noc_string);
		Double cps = msg.getData().getDouble(LogicGame.cps_string);
		
		BigDecimal bd = new BigDecimal(noc);
		
		textViewNoc.setText(((Integer)bd.intValue()).toString());
		
		//Format numero (mostrar solo un decimal)
		DecimalFormat df= new DecimalFormat("#0.0");
		
		textViewCps.setText(df.format(cps));
		
		//Notificar para actualizar el listView
		//LogicGame.getAdapter().notifyDataSetChanged();
		
		updateListViewItemsManual();
	}
	
	private void updateListViewItemsManual() {
		int start = listItems.getFirstVisiblePosition();
		int end = listItems.getLastVisiblePosition();
		for(int i = start; i <=end; i++) {		
	        View view = listItems.getChildAt(i-start);
	        listItems.getAdapter().getView(i, view, listItems);
		}
		
	}
}
