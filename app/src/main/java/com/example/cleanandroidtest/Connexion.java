package com.example.cleanandroidtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.cleanandroidtest.MainActivity;

public class Connexion extends Activity {
	
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.connexion);
	        
	      //define the email pattern by using the regular expression
	   	 	final String emailPattern ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	   	        		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	   	 
	        Button connect = (Button) findViewById(R.id.btn_connect);
	        connect.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					//to verify the email
					EditText email= (EditText) findViewById(R.id.edt_email);
					if(email.getText().equals(emailPattern)){
						System.out.println("Valid mail");
						//here we'll take this mail and save it into the user class
					}else{
						System.out.println("Invalid mail");
					}
					
					Intent goToMenu= new Intent(Connexion.this, Menu.class);
					startActivity(goToMenu);
				}
			});
	        
	    }

}
