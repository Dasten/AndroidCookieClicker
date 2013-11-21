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
	
	TextView textViewNoc;
	
	CookieHandler(TextView out) {
		this.textViewNoc = out;
	}
	
	@Override
	public void handleMessage(Message msg) {
		Double noc = msg.getData().getDouble(LogicGame.noc_string);
		
		BigDecimal bd = new BigDecimal(noc);
		
		textViewNoc.setText(((Integer)bd.intValue()).toString());
	}
}
