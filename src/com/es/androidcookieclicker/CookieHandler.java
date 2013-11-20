/**
 * 
 */
package com.es.androidcookieclicker;

import android.os.Handler;
import android.os.Message;

/**
 * @author pfranco
 *
 */
public class CookieHandler extends Handler {
	
	@Override
	public void handleMessage(Message msg) {
		LogicGame.incrementCookies();
	}
}
