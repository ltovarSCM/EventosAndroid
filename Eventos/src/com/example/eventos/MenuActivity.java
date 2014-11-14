package com.example.eventos;


import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MenuActivity extends Activity implements OnClickListener{

	private ImageButton btnUsusario;
	private ImageButton btnCliente;
	private ImageButton btnEvento;
	private ImageButton btnProgEvento;
	private ImageButton btnValores;
	private ImageButton btnConfig;
	private ImageButton btnImagenes;
	private ImageButton btnSalir;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		this.btnUsusario = (ImageButton) findViewById(R.id.botUsuario);
		this.btnCliente = (ImageButton) findViewById(R.id.botCliente);
		this.btnEvento = (ImageButton) findViewById(R.id.botEventos);
		this.btnProgEvento = (ImageButton) findViewById(R.id.botProgeventos);
		this.btnValores = (ImageButton) findViewById(R.id.botValores);
		this.btnConfig = (ImageButton) findViewById(R.id.botConfig);
		this.btnImagenes = (ImageButton) findViewById(R.id.botImagenes);
		this.btnSalir = (ImageButton) findViewById(R.id.botSalir);
		
		this.btnUsusario.setOnClickListener(this);
		this.btnCliente.setOnClickListener(this);
		this.btnSalir.setOnClickListener(this);
		this.btnValores.setOnClickListener(this);
		this.btnEvento.setOnClickListener(this);
		this.btnImagenes.setOnClickListener(this);
		this.btnConfig.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch(item.getItemId()){
		case R.id.itbd: BaseDatos bd = new BaseDatos(this);
		          SQLiteDatabase db = bd.getWritableDatabase();
	           Toast.makeText(this, "Base de datos creada",Toast.LENGTH_LONG).show();
	            return true;
	               default:
			return super.onOptionsItemSelected(item);
			}

	}

	/**
	 * A placeholder fragment containing a simple view.
	 */


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.botUsuario:
			Intent imenu = new Intent(MenuActivity.this, PerfilActivity.class);
			startActivity(imenu);
			break;
			
		case R.id.botCliente:
			Intent imenu2 = new Intent(MenuActivity.this, ClienteActivity.class);
			startActivity(imenu2);
			break;

		case R.id.botSalir:
			finish();
			break;
			
		case R.id.botValores:
			Intent imenu3 = new Intent (MenuActivity.this, SalonActivity.class);
			startActivity(imenu3);
			break;
		
		case R.id.botEventos:
			Intent imenu4 = new Intent (MenuActivity.this, EventoActivity.class);
			startActivity(imenu4);
			break;
			
		case R.id.botImagenes:
			Intent imenu5 = new Intent (MenuActivity.this, ImagenesActivity.class);
			startActivity(imenu5);
			break;
			
		case R.id.botConfig:
			Intent imenu6 = new Intent (MenuActivity.this, ConfigActivity.class);
			startActivity(imenu6);
			break;
		
		default:
			break;
		}
		
	}

}
