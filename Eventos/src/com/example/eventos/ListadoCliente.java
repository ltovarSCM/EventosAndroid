package com.example.eventos;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ListadoCliente extends Activity {

	ListView lista;
	SimpleCursorAdapter sca;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_cliente);
		lista = (ListView) findViewById(R.id.lvconferencista);
		ClienteDataSource cls = new ClienteDataSource(this);
		cls.open();
		Cursor c = cls.listaCliente2();
		if (c.getCount()>0){
		String[] from = new String[]{"_id",ManejadorBD.TCliente.NOMBRE, ManejadorBD.TCliente.TELEFONO, ManejadorBD.TCliente.CORREO,
				ManejadorBD.TCliente.EMPRESA};
		int[] to = new int[]{R.id.txvcodcliente, R.id.txvnombre,R.id.txvtelefono,R.id.txvcorreo, R.id.txvempresa};
		sca = new SimpleCursorAdapter(this, R.layout.item_cliente, c, from, to,0);
		lista.setAdapter(sca);
		}
		else{
			Toast.makeText(this, "No hay datos de Datos de Cliente",Toast.LENGTH_LONG).show();
		}
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.listado_cliente, menu);
		return true;
	}

	
}
