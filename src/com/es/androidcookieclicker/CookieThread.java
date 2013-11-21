/**
 * 
 */
package com.es.androidcookieclicker;

import java.util.concurrent.atomic.AtomicBoolean;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * @author pablo.fernandez
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
				
				bundle.putDouble(LogicGame.noc_string, LogicGame.getCookies());
				
				handler.sendMessage(msg);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
