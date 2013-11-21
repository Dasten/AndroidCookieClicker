/**
 * 
 */
package com.es.androidcookieclicker;

import android.content.Context;
import android.widget.ArrayAdapter;

/**
 * @author pfranco
 *
 */
public class ArrayAdapterCookie<Object> extends ArrayAdapter<Object> {

	

	public ArrayAdapterCookie(Context context, int resource, Object[] objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isEnabled(int position) {
	    LogicItems item = (LogicItems) getItem(position);
		
		if(LogicGame.getCookies() >= item.getPrice()){
	        return true;
	    }
		
	    return false;
	}
}
