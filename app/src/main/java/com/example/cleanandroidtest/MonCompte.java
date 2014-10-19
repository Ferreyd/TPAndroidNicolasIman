package com.example.cleanandroidtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MonCompte extends Activity {
	 
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.moncompte); 
	        
	        TextView lastName= (TextView) findViewById(R.id.last_name);
	        TextView firstName= (TextView) findViewById(R.id.first_name);
	        TextView tel= (TextView) findViewById(R.id.tel);
	        TextView sexe= (TextView) findViewById(R.id.sexe);
	        TextView email= (TextView) findViewById(R.id.email);
	        TextView password= (TextView) findViewById(R.id.pass);

	 }

}
