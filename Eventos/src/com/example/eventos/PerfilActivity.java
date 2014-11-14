package com.example.eventos;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class PerfilActivity extends ActionBarActivity implements OnClickListener{

	private EditText nombreUsu;
	private EditText telefonoUsu;
	private EditText correoUsu;
	private EditText claveUsu;
	private Button botAddUsuario;
	private Button botCancelUsuario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_perfil);
		this.nombreUsu = (EditText) findViewById(R.id.textNombreUsu);
		this.telefonoUsu = (EditText) findViewById(R.id.textTelefonoUsu);
		this.correoUsu = (EditText) findViewById(R.id.textCorreoUsu);
		this.claveUsu = (EditText) findViewById(R.id.textClaveUsu);
		this.botAddUsuario = (Button) findViewById(R.id.butAddUsu);
		this.botCancelUsuario = (Button) findViewById(R.id.butCancelUsu);
		
		this.botAddUsuario.setOnClickListener(this);
		this.botCancelUsuario.setOnClickListener(this);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.perfil, menu);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */


}
