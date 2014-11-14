package com.example.eventos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SalonActivity extends Activity implements OnClickListener{
	
	private Button btnguardar, btncancelar,btneliminar,btnbuscar,btnactualizar;
	private EditText codsalon, nombre, capacidad, precioHora;
	boolean sw=true;
	private SalonDataSource sls;
	private Salon sal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_salon);
		cargarDatos();
		
		btnguardar = (Button) findViewById(R.id.btnguardarsalon);
		btnguardar.setOnClickListener(this);
		
		btncancelar = (Button) findViewById(R.id.btncancelarsalon);
		btncancelar.setOnClickListener(this);
		
		btneliminar= (Button) findViewById(R.id.btneliminarsalon);
		btneliminar.setOnClickListener(this);
		
		btnbuscar = (Button) findViewById(R.id.btnbuscarsalon);
		btnbuscar.setOnClickListener(this);
		
		btnactualizar = (Button) findViewById(R.id.btnactualizarsalon);
		btnactualizar.setOnClickListener(this);
		btnactualizar.setEnabled(false);
	}
	
	private void cargarDatos(){
		 codsalon= (EditText) findViewById(R.id.txtCodSalon);
		 nombre = (EditText) findViewById(R.id.txtNombreSalon);
		 capacidad = (EditText) findViewById(R.id.txtCapacidadSalon);
		 precioHora = (EditText) findViewById(R.id.txtPrecioSalon);
		 		 
	 }
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnguardarsalon:
		    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);  
			dialogo1.setTitle("Importante");  
			dialogo1.setMessage("¿Desae Guardar Salon?");            
			dialogo1.setCancelable(false);  
			dialogo1.setPositiveButton("SI", new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialogo1, int id) {  
				//	aceptar()
				if(verificarDatos()){
					Salon s = new Salon(codsalon.getText().toString(),nombre.getText().toString(),capacidad.getText().toString(),precioHora.getText().toString());
	        SalonDataSource sls = new SalonDataSource(SalonActivity.this);
	        sls.open();
	        sls.crearSalon(s);
			 AlertDialog.Builder builder = new AlertDialog.Builder(SalonActivity.this);
				        builder.setTitle("Exito");
				        builder.setMessage("Registro de Salon Realizado");
				        builder.setPositiveButton("OK",null);
				        builder.create();
				        builder.show(); 
				        limpiarCampos();
				        sls.close();
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
                  Toast.makeText(this,"Error valor codigo", Toast.LENGTH_LONG).show();
                  sw=true;
                 }
               break;
               
		case R.id.btncancelarsalon: 
		limpiarCampos();
        btncancelar.setEnabled(false);
        codsalon.setEnabled(true);
        	break;
        	
		case R.id.btneliminarsalon: 
			sls = new SalonDataSource(SalonActivity.this);
		    sls.open();
		    sal = new Salon();
		    sal.setCodSalon(codsalon.getText().toString());
		    sls.borrarSalon(sal);
		    sls.close();
		    Toast.makeText(this, "Salon Eliminado",Toast.LENGTH_LONG).show();
		    limpiarCampos();
		    break;
		    
		  case R.id.btnbuscarsalon: 
			sls = new SalonDataSource(SalonActivity.this);
			sls.open();
			sal = sls.buscarSalon(codsalon.getText().toString());
			if (sal!=null){
			nombre.setText(sal.getNombreSalon());
			capacidad.setText(sal.getCapacidadSalon());
			precioHora.setText(sal.getPrecioHora());
			btnactualizar.setEnabled(true);
			codsalon.setEnabled(false);
			Toast.makeText(this, "Salon Encontrado",Toast.LENGTH_LONG).show();}
			else{
				Toast.makeText(this, "No se encontro el Salon",Toast.LENGTH_LONG).show();
			}
		    sls.close();
		    break;
		    
		    case R.id.btnactualizarsalon:  
		    	sal = new Salon(codsalon.getText().toString(),
			    nombre.getText().toString(),capacidad.getText().toString(), precioHora.getText().toString());
		        sls = new SalonDataSource(SalonActivity.this);
			    sls.open();
			    if (sls.actualizarSalon(sal)){
						Toast.makeText(this, "Registro de Salon Actualizado",Toast.LENGTH_LONG).show();
		    			
			        }
			        else{
			        	Toast.makeText(this, "Error al actualizar el salon",Toast.LENGTH_LONG).show();
		    			
			        }
			        sls.close();
		    		
		    break;
		   
	}
		
	}
	
	
	private boolean verificarDatos(){
		if (codsalon.getText().toString().equals("")){
			return false;
		}
		else{
			return true;
		}
	}
	
	private void limpiarCampos(){
		 codsalon.setText("");
		 nombre.setText("");
		 capacidad.setText("");
		 precioHora.setText("");
		 
	 }
	
}
