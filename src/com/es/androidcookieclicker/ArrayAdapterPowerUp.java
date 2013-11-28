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
	
	@Override
	public View getView(int position, View view, ViewGroup vg){

		View vi = view;
		LogicPowerUps powerUp = (LogicPowerUps) getItem(position);
		
		if(vi == null) {
			
			vi = inflater.inflate(R.layout.list_row, null);
		}
		
		TextView name = (TextView)vi.findViewById(R.id.name_item);
		TextView price = (TextView)vi.findViewById(R.id.price_item);
		ImageView image = (ImageView)vi.findViewById(R.id.image_item);
		
		
		int resId = rs.getIdentifier("image_list_"+powerUp.getId(), "drawable", packageName);
		
		image.setImageResource(resId);
		
		name.setText(powerUp.getName());
		price.setText(powerUp.getPrice()+"");
		
		if(isEnabled(position)){
			vi.setEnabled(true);
			price.setTextColor(Color.parseColor("#1CBC17"));
	    } else {
	    	vi.setEnabled(false);
	    	price.setTextColor(Color.parseColor("#B22626"));
	    }
		
		return vi;
		
	}

	@Override
	public boolean isEnabled(int position) {
	    LogicItems item = (LogicItems) getItem(position);
	    LogicPowerUps pUp = (LogicPowerUps) getItem(position);
		
		if(LogicGame.getCookies() >= item.getPrice()){
	        return true;
	    }
		
	    return false;
	}
}
