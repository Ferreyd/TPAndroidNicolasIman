package com.example.cleanandroidtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {
	
	private Context mContext;
	private String[] menuValues;
	private Integer[] mThumIds;
	
	public ImageAdapter (Context c){
		mContext= c; 
		menuValues =mContext.getResources().getStringArray(R.array.menu);
		mThumIds= new Integer[]{
				R.drawable.android,R.drawable.user,
		};
		
	}
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mThumIds.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	//create an ImageView for each item referenced by the Adapter 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View gridView; 
		if(convertView == null){
			gridView= new View(mContext);
             
            gridView = inflater.inflate(R.layout.layout_menu_model, null);  
            // set value into textview  
            TextView textView = (TextView) gridView  
                    .findViewById(R.id.grid_item_label_1);  
            textView.setText(menuValues[position]);  
            // set image based on selected text  
            ImageView imageView = (ImageView) gridView  
                    .findViewById(R.id.grid_item_image_1);  
                imageView.setImageResource(mThumIds[position]);  
        } else {  
            gridView = (View) convertView;  
		}
		return gridView;
	}
	

}
