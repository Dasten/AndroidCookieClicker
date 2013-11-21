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
	
	TextView out;
	
	CookieHandler(TextView out) {
		this.out = out;
	}
	
	@Override
	public void handleMessage(Message msg) {
		LogicGame.incrementCookiesPerSecond();
		
		BigDecimal bd = new BigDecimal(LogicGame.getCookies());
		
		out.setText(((Integer)bd.intValue()).toString());
	}
}
