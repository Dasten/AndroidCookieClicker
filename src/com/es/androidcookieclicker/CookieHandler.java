/**
 * 
 */
package com.es.androidcookieclicker;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * @author pfranco
 *
 */
public class CookieHandler extends Handler {
	
	ArrayAdapterCookie<LogicItems> adapterListItems;
	
	TextView textViewNoc;
	TextView textViewCps;
	
	CookieHandler(TextView textViewNoc, TextView textViewCps, ArrayAdapterCookie<LogicItems> adapterListItems) {
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
		
		//Format numero (mostrar solo un decimal)
		DecimalFormat df= new DecimalFormat("#0.0");
		
		textViewCps.setText(df.format(cps));
		
		adapterListItems.notifyDataSetChanged();
	}
}
