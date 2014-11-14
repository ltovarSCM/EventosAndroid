package com.example.eventos;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class MainActivity extends Activity {
	
	public int DELAY = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Definir orientacion vertical
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		//Elimina u oculta la barra de titulo
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//Carga el layout correspondiente
		setContentView(R.layout.activity_main);
		//Definimos un timer para controlar el tiempo de la imagen
		TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				// Creamos un enlace a la siguiente actividad
				Intent mainIntent = new Intent().setClass(MainActivity.this, LoguinActivity.class);
				startActivity(mainIntent);
				//Evitamos que se pueda regresar a la actividad
				//Eliminandola de la pila
				finish();
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(task, DELAY);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	
}
