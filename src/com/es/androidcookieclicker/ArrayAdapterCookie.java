/**
 * 
 */
package com.es.androidcookieclicker;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
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
	public View getView(int position, View view, ViewGroup vg){
		/*int countElements = vg.getChildCount();
		
		for(int i = 0; i < countElement)*/
		
		View row = super.getView(position, view, vg);
		
		if(!row.isEnabled()) {
			row.setBackgroundColor(2);
		} else {
			row.setBackgroundColor(1);
		}
		
		return row;
		
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
