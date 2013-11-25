/**
 * 
 */
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

/**
 * @author pfranco
 *
 */
public class ArrayAdapterCookie<Object> extends ArrayAdapter<Object> {

	private static LayoutInflater inflater = null;
	private Resources rs;
	private String packageName;
	
	public ArrayAdapterCookie(Context context, int resource, Object[] objects) {
		super(context, resource, objects);
		
		inflater = ((Activity)super.getContext()).getLayoutInflater();
		
		rs = context.getResources();
		packageName = context.getPackageName();
	}
	
	@Override
	public View getView(int position, View view, ViewGroup vg){
		/*View row = super.getView(position, view, vg);
		TextView text = (TextView) super.getView(position, view, vg);
		//text.setTypeface(null, Typeface.BOLD);
		
		//Images
		
		
				
		if(isEnabled(position)){
			row.setEnabled(true);
			text.setTextColor(Color.parseColor("#1CBC17"));
	    } else {
	    	row.setEnabled(false);
	    	text.setTextColor(Color.parseColor("#B22626"));
	    }*/
		
		View vi = view;
		LogicItems item = (LogicItems) getItem(position);
		
		if(vi == null) {
			
			vi = inflater.inflate(R.layout.list_row, null);
		}
		
		TextView name = (TextView)vi.findViewById(R.id.name_item);
		TextView price = (TextView)vi.findViewById(R.id.price_item);
		TextView level = (TextView)vi.findViewById(R.id.level_item);
		ImageView image = (ImageView)vi.findViewById(R.id.image_item);
		
		
		int resId = rs.getIdentifier("image_list_"+item.getId(), "drawable", packageName);
		
		image.setImageResource(resId);
		
		name.setText(item.getName());
		price.setText(item.getPrice()+"");
		level.setText(item.getLevel()+"");
		
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
		
		if(LogicGame.getCookies() >= item.getPrice()){
	        return true;
	    }
		
	    return false;
	}
}
