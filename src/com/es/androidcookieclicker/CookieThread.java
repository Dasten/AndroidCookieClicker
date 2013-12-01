/**
 * 
 */
package com.es.androidcookieclicker;

import java.util.concurrent.atomic.AtomicBoolean;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * @author pfranco
 * @author Carlos B
 *
 */
public class CookieThread implements Runnable {

	private Handler handler;
	public AtomicBoolean isRunning;
	
	CookieThread(Handler hd) {
		isRunning = new AtomicBoolean(false);
		
		this.handler = hd;
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(100);
				
				//Logic game
				LogicGame.tick();
				
				Message msg = handler.obtainMessage();
				
				Bundle bundle = msg.getData();
				
				
				//Send all data to handler
				bundle.putDouble(LogicGame.noc_string, LogicGame.getCookies());
				bundle.putDouble(LogicGame.cps_string, LogicGame.getCps());
				bundle.putDouble(LogicGame.cpc_string, LogicGame.getCpc());
				
				handler.sendMessage(msg);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
