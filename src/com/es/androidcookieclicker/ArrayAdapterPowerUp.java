package com.es.androidcookieclicker;


import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class ArrayAdapterPowerUp extends ArrayAdapter<LogicPowerUps> {

	private static LayoutInflater inflater = null;
	private Resources rs;
	private String packageName;
	
	public ArrayAdapterPowerUp(Context context, int resource, List<LogicPowerUps> objects) {
		super(context, resource, objects);
		
		inflater = ((Activity)super.getContext()).getLayoutInflater();
		
		rs = context.getResources();
		packageName = context.getPackageName();
	}
	
	@Override
	public View getView(int position, View view, ViewGroup vg){

		View vi = view;
		LogicPowerUps powerUp = getItem(position);
		
		if(!powerUp.isRemoved()) {
		
			if(vi == null) {
				
				vi = inflater.inflate(R.layout.list_row_powerups, null);
			}
			
			
			TextView name = (TextView)vi.findViewById(R.id.name_powerup);
			TextView price = (TextView)vi.findViewById(R.id.price_powerup);	
			ImageView image = (ImageView)vi.findViewById(R.id.image_powerup);
			
			
			int resId = rs.getIdentifier("image_list_up"+powerUp.getId(), "drawable", packageName);
						
			image.setImageResource(resId);
			
			name.setText(powerUp.getName());
			price.setText(LogicGame.formatNumber(powerUp.getPrice())+"");
					
			if(isEnabled(position)){
				vi.setEnabled(true);
				price.setTextColor(Color.parseColor("#1CBC17"));
		    } else {
		    	vi.setEnabled(false);
		    	price.setTextColor(Color.parseColor("#B22626"));
		    }
			
		} else {
			LogicGame.getPupsAvailable().remove(position);
		}
		
		return vi;
	}
	
	@Override
	public boolean isEnabled(int position) {
	    LogicPowerUps powerUp = (LogicPowerUps) getItem(position);
		
		return (powerUp.isPurchasable());
	}
}

