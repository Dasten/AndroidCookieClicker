package com.es.androidcookieclicker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;

public class TeamWorkActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_team_work);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.team_work, menu);
		return true;
	}

	public void loadingActivity(){
		try {
			Thread.sleep (10000);
			} catch (Exception e) {
			System.out.println("Error de espera en el activity de TeamWork");
		}
		
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
	}
}
