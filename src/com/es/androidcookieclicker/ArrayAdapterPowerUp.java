package com.es.androidcookieclicker;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ArrayAdapterPowerUp<Object> extends ArrayAdapter<Object> {

	private static LayoutInflater inflater = null;
	private Resources rs;
	private String packageName;
	
	public ArrayAdapterPowerUp(Context context, int resource, Object[] objects) {
		super(context, resource, objects);
		
		inflater = ((Activity)super.getContext()).getLayoutInflater();
		
		rs = context.getResources();
		packageName = context.getPackageName();
	}
	
	/*@Override
	public View getView(int position, View view, ViewGroup vg){

		View vi = view;
		LogicPowerUps powerUp = (LogicPowerUps) getItem(position);
		
		if(vi == null) {
			
			vi = inflater.inflate(R.layout.list_row_powerups, null);
		}
		
		TextView name = (TextView)vi.findViewById(R.id.name_powerup);
		TextView price = (TextView)vi.findViewById(R.id.price_powerup);
		ImageView image = (ImageView)vi.findViewById(R.id.image_powerup);
		
		
		int resId = rs.getIdentifier("image_list_"+powerUp.getId(), "drawable", packageName);
		
		image.setImageResource(resId);
		
		name.setText(powerUp.getName());
		price.setText(powerUp.getPrice()+"");
				
		return vi;
		
	}*/
}


	/*
	@Override
	public boolean isEnabled(int position) {
	    LogicItems item = (LogicItems) getItem(position);
	    
	    
	    
	    LogicPowerUps pUp = (LogicPowerUps) getItem(position);
		
		if(LogicGame.getCookies() >= item.getPrice()){
	        return true;
	    }
		
	    return false;
	}
	*/

