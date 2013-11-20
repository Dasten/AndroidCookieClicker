/**
 * 
 */
package com.es.androidcookieclicker;

import java.util.concurrent.atomic.AtomicBoolean;

import android.os.Handler;

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
				Thread.sleep((long) (1000/LogicGame.getCps()));
				handler.sendMessage(handler.obtainMessage());
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
}
