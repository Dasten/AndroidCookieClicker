/**
 * 
 */
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

/**
 * @author pfranco
 * @author Carlos B
 *
 */
public class ArrayAdapterCookie extends ArrayAdapter<LogicItems> {

	private static LayoutInflater inflater = null;
	private Resources rs;
	private String packageName;
	
	/**
	 * Instantiates a new array adapter cookie.
	 *
	 * @param context the context
	 * @param resource the resource
	 * @param objects the objects
	 */
	public ArrayAdapterCookie(Context context, int resource, List<LogicItems> objects) {
		super(context, resource, objects);
		
		inflater = ((Activity)super.getContext()).getLayoutInflater();
		
		rs = context.getResources();
		packageName = context.getPackageName();
	}
	
	@Override
	public View getView(int position, View view, ViewGroup vg){
		View vi = view;
		LogicItems item = (LogicItems) getItem(position);
		
		if(vi == null) {
			
			vi = inflater.inflate(R.layout.list_row_items, null);
		}
		
		TextView name = (TextView)vi.findViewById(R.id.name_item);
		TextView price = (TextView)vi.findViewById(R.id.price_item);
		TextView level = (TextView)vi.findViewById(R.id.level_item);
		ImageView image = (ImageView)vi.findViewById(R.id.image_item);
		
		
		int resId = rs.getIdentifier("image_list_"+item.getId(), "drawable", packageName);
		
		image.setImageResource(resId);
		
		name.setText(item.getName());
		price.setText(LogicGame.formatNumber(item.getPrice())+"");
		level.setText(item.getLevel()+"");
		
		if(item.isPurchasable()){
			vi.setEnabled(true);
			price.setTextColor(Color.parseColor("#1CBC17"));
	    } else {
	    	vi.setEnabled(false);
	    	price.setTextColor(Color.parseColor("#B22626"));
	    }
		
		return vi;
	}
}
