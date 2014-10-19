package com.example.cleanandroidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class Menu extends Activity {

	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.menu);
	        
	        GridView gridView= (GridView) findViewById(R.id.gridview);
	        gridView.setAdapter(new ImageAdapter(this));
	        gridView.setOnItemClickListener(new OnItemClickListener() {
	    
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO Auto-generated method stub
					//System.out.println("Welcome Iman !!!");
		        	//Toast.makeText(Menu.this, ""+position, Toast.LENGTH_SHORT).show();
					Toast.makeText(Menu.this, "Welcome Iman !!!", Toast.LENGTH_SHORT).show();
					
						Intent intent = new Intent (Menu.this, MonCompte.class);
			            startActivity(intent);
			        }
			});
	        
	 }
}
