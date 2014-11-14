package com.example.eventos;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoguinActivity extends ActionBarActivity implements OnClickListener {

	private EditText edtLoguin;
	private EditText edtPassword;
	private Button btnAceptar;
	private Button btnCancelar;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loguin);
		this.edtLoguin = (EditText) findViewById(R.id.edtloguin);
		this.edtPassword = (EditText) findViewById(R.id.editpassword);
		this.btnAceptar = (Button) findViewById(R.id.btniniciosesion);
		this.btnCancelar = (Button) findViewById(R.id.btncancelarsesion);
		this.btnAceptar.setOnClickListener(this);
		this.btnCancelar.setOnClickListener(this);
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btniniciosesion:
			String loguin = edtLoguin.getText().toString();
			String password = edtPassword.getText().toString();
			if(loguin.equals("a") && password.equals("a")){
				Intent imenu = new Intent(LoguinActivity.this, MenuActivity.class);
				startActivity(imenu);
				finish();
			}
			else{
			Toast.makeText(this, "Usuario Incorrecto", Toast.LENGTH_LONG).show();
		}
			break;
		
		case R.id.btncancelarsesion:
			edtLoguin.setText("");
			edtPassword.setText("");
			break;
		
		}
	}



}
