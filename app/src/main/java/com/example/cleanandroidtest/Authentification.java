package com.example.cleanandroidtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Authentification extends Activity {
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.authentification);
	        
	        EditText nom=(EditText) findViewById(R.id.edt_nom);
	        TextView auth_user=(TextView) findViewById(R.id.auth_user);
	        
	        String userName= nom.getText().toString();
		     
		     auth_user.setText("Welcome"+userName);
	 }

}
