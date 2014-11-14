package com.example.eventos;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class ClienteActivity extends Activity implements OnClickListener{

	private Button btnguardar, btncancelar,btneliminar,btnbuscar,btnactualizar;
	private EditText codcliente, nombres, telefono,correo, empresa;
	boolean sw=true;
	private ClienteDataSource cls;
	private Cliente cli;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cliente);
		cargarDatos();
		btnguardar = (Button) findViewById(R.id.btnguardarcliente);
		btnguardar.setOnClickListener(this);
		btncancelar = (Button) findViewById(R.id.btncancelarcliente);
		btncancelar.setOnClickListener(this);
		btneliminar= (Button) findViewById(R.id.btneliminarcliente);
		btneliminar.setOnClickListener(this);
		btnbuscar = (Button) findViewById(R.id.btnbuscarcliente);
		btnbuscar.setOnClickListener(this);
		btnactualizar = (Button) findViewById(R.id.btnactualizarcliente);
		btnactualizar.setOnClickListener(this);
		btnactualizar.setEnabled(false);
	}
	
	private void cargarDatos(){
		 codcliente= (EditText) findViewById(R.id.edtdocumento);
		 nombres = (EditText) findViewById(R.id.edtnombre);
		 correo = (EditText) findViewById(R.id.edtcorreo);
		 telefono = (EditText) findViewById(R.id.edttelefono);
		 empresa = (EditText) findViewById(R.id.edtempresa);
		 
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cliente, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		 switch (item.getItemId()) {
		   case R.id.mnuallcliente: Intent ic = new Intent(this,ListadoCliente.class);
		   startActivity(ic);
		   limpiarCampos();
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
		switch(v.getId()){
		case R.id.btnguardarcliente:
		    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);  
			dialogo1.setTitle("Importante");  
			dialogo1.setMessage("¿Desae Guardar Cliente?");            
			dialogo1.setCancelable(false);  
			dialogo1.setPositiveButton("SI", new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialogo1, int id) {  
				//	aceptar()
				if(verificarDatos()){
					Cliente c = new Cliente(codcliente.getText().toString(),
			    	nombres.getText().toString(),telefono.getText().toString(), correo.getText().toString(), 
				    empresa.getText().toString());
	        ClienteDataSource cls = new ClienteDataSource(ClienteActivity.this);
			 cls.open();
			 cls.crearCliente(c);
			 AlertDialog.Builder builder = new AlertDialog.Builder(ClienteActivity.this);
				        builder.setTitle("Exito");
				        builder.setMessage("Registro Realizado");
				        builder.setPositiveButton("OK",null);
				        builder.create();
				        builder.show(); 
				        limpiarCampos();
				        cls.close();
					}
					else{
						sw = false;
					}
							
			}  
				});  
				dialogo1.setNegativeButton("NO", new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialogo1, int id) {  
				}  
					});            
              dialogo1.show();
              if (sw==false){
                  Toast.makeText(this,"Error valor cedula", Toast.LENGTH_LONG).show();
                  sw=true;
                 }
               break;
               
		case R.id.btncancelarcliente: limpiarCampos();
        btnactualizar.setEnabled(false);
        codcliente.setEnabled(true);
        	break;
        	
		case R.id.btneliminarcliente:  cls = new ClienteDataSource(ClienteActivity.this);
		    cls.open();
		    cli = new Cliente();
		    cli.setCodCliente(codcliente.getText().toString());
		    cls.borrarCliente(cli);
		    cls.close();
		    Toast.makeText(this, "Cliente Eliminado",Toast.LENGTH_LONG).show();
		    limpiarCampos();
		    break;
		    
		  case R.id.btnbuscarcliente: cls = new ClienteDataSource(ClienteActivity.this);
			cls.open();
			cli = cls.buscarCliente(codcliente.getText().toString());
			if (cli!=null){
			nombres.setText(cli.getNombre());
			correo.setText(cli.getCorreo());
			telefono.setText(cli.getTelefono());
			empresa.setText(cli.getEmpresa());
			btnactualizar.setEnabled(true);
			codcliente.setEnabled(false);
			Toast.makeText(this, "Cliente Encontrado",Toast.LENGTH_LONG).show();}
			else{
				Toast.makeText(this, "No se encontro el Cliente",Toast.LENGTH_LONG).show();
			}
		    cls.close();
		    break;
		    
		    case R.id.btnactualizarcliente:  cli = new Cliente(codcliente.getText().toString(),
			    	nombres.getText().toString(),telefono.getText().toString(), correo.getText().toString(), 
				    empresa.getText().toString());
		            cls = new ClienteDataSource(ClienteActivity.this);
			        cls.open();
			        if (cls.actualizarCliente(cli)){
						Toast.makeText(this, "Registro Actualizado",Toast.LENGTH_LONG).show();
		    			
			        }
			        else{
			        	Toast.makeText(this, "Error al actualizar",Toast.LENGTH_LONG).show();
		    			
			        }
			        cls.close();
		    		
		    break;
		   
	}

}
	
	private boolean verificarDatos(){
		if (codcliente.getText().toString().equals("")){
			return false;
		}
		else{
			return true;
		}
	}
	
	private void limpiarCampos(){
		 codcliente.setText("");
		 nombres.setText("");
		 correo.setText("");
		 telefono.setText("");
		 empresa.setText("");
		 
	 }
}

	