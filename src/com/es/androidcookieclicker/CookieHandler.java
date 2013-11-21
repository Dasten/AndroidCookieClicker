/**
 * 
 */
package com.es.androidcookieclicker;

import java.math.BigDecimal;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * @author pfranco
 *
 */
public class CookieHandler extends Handler {
	
	ArrayAdapterCookie adapterListItems;
	
	TextView textViewNoc;
	TextView textViewCps;
	
	CookieHandler(TextView textViewNoc, TextView textViewCps, ArrayAdapterCookie adapterListItems) {
		this.textViewNoc = textViewNoc;
		this.textViewCps = textViewCps;
		this.adapterListItems = adapterListItems;
		
	}
	
	@Override
	public void handleMessage(Message msg) {
		Double noc = msg.getData().getDouble(LogicGame.noc_string);
		Double cps = msg.getData().getDouble(LogicGame.cps_string);
		
		BigDecimal bd = new BigDecimal(noc);
		
		textViewNoc.setText(((Integer)bd.intValue()).toString());
		textViewCps.setText(cps.toString());
		
		adapterListItems.notifyDataSetChanged();
	}
}
