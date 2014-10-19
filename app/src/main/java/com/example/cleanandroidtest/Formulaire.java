package com.example.cleanandroidtest;

//import java.io.FileInputStream;
//import java.io.FileOutputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import android.widget.Toast;

public class Formulaire extends Activity {

	// private String nom_data, prenom_data, portable_data,
	// email_data,password_data;
	// private String file="user_data";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.formulaire);

		// define the email pattern by using the regular expression
		final String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		final Button btnRegister = (Button) findViewById(R.id.btn_register);
		btnRegister.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				// Intent i1= new Intent(Formulaire.this,Connexion.class);
				// startActivity(i1);

				// First verification
				// to verify that the phone number is only 10 characters
				EditText phoneNb = (EditText) findViewById(R.id.edt_portable);
				if (phoneNb.length() == 10) {
					phoneNb.getText();
				} else {
					System.out.println("Invalid phone number");
				}

				// Second verification
				// to verify that the password is the same in the confirmation
				// field
				EditText password = (EditText) findViewById(R.id.edt_password);
				EditText repassword = (EditText) findViewById(R.id.edt_repassword);
				if (repassword.getText().equals(password.getText())) {
					System.out.println("same password right ");
				} else {
					System.out.println("your password is not confirmed ");
				}

				// Third verification
				// to verify the email
				EditText email = (EditText) findViewById(R.id.edt_email);
				if (email.getText().equals(emailPattern)) {
					System.out.println("Valid mail");
					// here we'll take this mail and save it into the user class
				} else {
					System.out.println("Invalid mail");
				}
				EditText nom= (EditText) findViewById(R.id.edt_nom); 
				EditText prenom= (EditText) findViewById(R.id.edt_prenom); 
				EditText portable= (EditText)findViewById(R.id.edt_portable); 
				User u = new User(); 
				u.setNom(nom.getText().toString()); 
				u.setPrenom(prenom.getText().toString()); 
				u.setPassword(password.getText().toString()); 
				
				new LongTask().execute(u); 
			
				/*Intent authentification = new Intent(Formulaire.this,
						Authentification.class);
				startActivity(authentification);
				*/ 
				
			}
		});
	}

	/*
	 * EditText nom= (EditText) findViewById(R.id.edt_nom); EditText prenom=
	 * (EditText) findViewById(R.id.edt_prenom); EditText portable= (EditText)
	 * findViewById(R.id.edt_portable); EditText email= (EditText)
	 * findViewById(R.id.edt_email); EditText password=(EditText)
	 * findViewById(R.id.edt_password);
	 * 
	 * public void save(View view){ nom_data= nom.getText().toString();
	 * prenom_data=prenom.getText().toString();
	 * portable_data=portable.getText().toString();
	 * email_data=email.getText().toString();
	 * password_data=password.getText().toString();
	 * 
	 * try{ FileOutputStream fOut= openFileOutput(file, MODE_WORLD_READABLE);
	 * fOut.write(nom_data.getBytes()); fOut.write(prenom_data.getBytes());
	 * fOut.write(portable_data.getBytes()); fOut.write(email_data.getBytes());
	 * fOut.write(password_data.getBytes()); fOut.close();
	 * 
	 * Toast.makeText(getBaseContext(), "file saved",
	 * Toast.LENGTH_SHORT).show(); } catch (Exception e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * public void read(View view){ try{ FileInputStream fin =
	 * openFileInput(file); int c; String temp=""; while( (c = fin.read()) !=
	 * -1){ temp = temp + Character.toString((char)c); } nom.setText(temp);
	 * prenom.setText(temp); portable.setText(temp); email.setText(temp);
	 * password.setText(temp);
	 * 
	 * Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
	 * 
	 * } catch(Exception e){
	 * 
	 * } }
	 */

	protected class LongTask extends AsyncTask<User, Void, String> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Avant l'execution du processus long (Thread principal)
		}

		@Override
		protected void onPostExecute(String resp) {
			super.onPostExecute(resp);
			Toast.makeText(Formulaire.this, resp, Toast.LENGTH_LONG).show(); 
		}

		@Override
	protected String doInBackground(User... arg0) { 
			try {
				return sendPost(arg0[0]);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null; 
		}
		
		private String sendPost(User user) throws Exception {  
			   String url ="http://92.243.14.22/person/";
			   
	        HttpClient client = new DefaultHttpClient();  
	        HttpPost post = new HttpPost(url);  
	   
	        // add header  
	          
	                post.setHeader("Content-Type", "application/json");  
	                JSONObject obj = new JSONObject();   
	                obj.put("prenom", user.getPrenom());   
	                obj.put("nom", user.getNom());   
	                obj.put("passwrod", user.getPassword()); 
	                StringEntity entity = new StringEntity(obj.toString());  
	   
	        post.setEntity(entity);  
	   
	        HttpResponse response = client.execute(post);  
	        System.out.println("\nSending 'POST' request to URL : " + url);  
	        System.out.println("Post parameters : " + post.getEntity());  
	        System.out.println("Response Code : " +   
	                                    response.getStatusLine().getStatusCode());  
	   
	        BufferedReader rd = new BufferedReader(  
	                        new InputStreamReader(response.getEntity().getContent()));  
	                  
	        StringBuffer result = new StringBuffer();  
	        String line = "";  
	        while ((line = rd.readLine()) != null) {  
	            result.append(line);  
	        }  
	   
	        System.out.println(result.toString());  
	        return result.toString(); 
	   
	    }  
		
		
		//to connect the user on the server 
		/*private String connectOnServer(User user) throws Exception {  
			   String url ="http://92.243.14.22/person/login";
			   
	        HttpClient client = new DefaultHttpClient();  
	        HttpPost post = new HttpPost(url);  
	   
	        // add header  
	          
	                post.setHeader("Content-Type", "application/json");  
	                JSONObject obj = new JSONObject();   
	                obj.put("email", user.getEmail());    
	                obj.put("passwrod", user.getPassword());   
	                StringEntity entity = new StringEntity(obj.toString());  
	   
	        post.setEntity(entity);  
	   
	        HttpResponse response = client.execute(post);  
	        System.out.println("\nSending 'POST' request to URL : " + url);  
	        System.out.println("Post parameters : " + post.getEntity());  
	        System.out.println("Response Code : " +   
	                                    response.getStatusLine().getStatusCode());  
	   
	        BufferedReader rd = new BufferedReader(  
	                        new InputStreamReader(response.getEntity().getContent()));  
	                  
	        StringBuffer result = new StringBuffer();  
	        String line = "";  
	        while ((line = rd.readLine()) != null) {  
	            result.append(line);  
	        }  
	   
	        System.out.println(result.toString());  
	        return result.toString(); 
	   
	    }  
	}*/
	}
}
