package com.example.eventos;

import android.support.v7.app.ActionBarActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EventoActivity extends ActionBarActivity implements OnClickListener {

	private Button btnguardar, btncancelar,btneliminar,btnbuscar,btnactualizar;
	private EditText codevento,	codcliente,	nombre,	descripcion,codsalon,fecha,
	horaini,	horafin,	confirmado,	valorevento;
	boolean sw=true;
	private EventoDataSource evDat;
	private Evento eve;

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_evento);
		        
		cargarDatos();
		btnguardar = (Button) findViewById(R.id.btnguardarEvent);
		btnguardar.setOnClickListener(this);
		btncancelar = (Button) findViewById(R.id.btncancelarEvent);
		btncancelar.setOnClickListener(this);
		btneliminar= (Button) findViewById(R.id.btneliminarEvent);
		btneliminar.setOnClickListener(this);
		btnbuscar = (Button) findViewById(R.id.btnbuscarEvent);
		btnbuscar.setOnClickListener(this);
		btnactualizar = (Button) findViewById(R.id.btnactualizarEvent);
		btnactualizar.setOnClickListener(this);
		btnactualizar.setEnabled(false);
	}
	
	private void cargarDatos(){
		 codevento= (EditText) findViewById(R.id.txtCodEvento);
		 codcliente = (EditText) findViewById(R.id.txtCodClienteEvent);
		 nombre = (EditText) findViewById(R.id.txtNombreEvent);
		 descripcion = (EditText) findViewById(R.id.txtDescripEvent);
		 codsalon = (EditText) findViewById(R.id.txtSalonEvent);
		 fecha = (EditText) findViewById(R.id.txtFechaEvent);
		 horaini = (EditText) findViewById(R.id.txtHoraInicio);
		 horafin = (EditText) findViewById(R.id.txtHoraFin);
		 confirmado = (EditText) findViewById(R.id.txtConfirmado);
		 valorevento = (EditText) findViewById(R.id.txtValorEvento);

	 }
	
	@Override
	public void onClick(View v) {
		
		switch(v.getId()){
		case R.id.btnguardarEvent:
		    AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);  
			dialogo1.setTitle("Importante");  
			dialogo1.setMessage("¿Desea Guardar el Evento?");            
			dialogo1.setCancelable(false);  
			dialogo1.setPositiveButton("SI", new DialogInterface.OnClickListener() {  
			public void onClick(DialogInterface dialogo1, int id) {  
				//	aceptar()
				if(verificarDatos()){
					Evento ev = new Evento(codevento.getText().toString(), codcliente.getText().toString(), codsalon.getText().toString(), nombre.getText().toString(), 
							descripcion.getText().toString(), fecha.getText().toString(), horaini.getText().toString(), horafin.getText().toString(),
							confirmado.getText().toString(), valorevento.getText().toString());
	        
					
			EventoDataSource evDat = new EventoDataSource(EventoActivity.this);
			 evDat.open();
			 evDat.crearEvento(ev);
			 AlertDialog.Builder builder = new AlertDialog.Builder(EventoActivity.this);
				        builder.setTitle("Exito");
				        builder.setMessage("Registro de Evento Realizado");
				        builder.setPositiveButton("OK",null);
				        builder.create();
				        builder.show(); 
				        limpiarCampos();
				        evDat.close();
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
               
		case R.id.btncancelarEvent:
		limpiarCampos();
        btnactualizar.setEnabled(false);
        codevento.setEnabled(true);
        	break;
        	
		case R.id.btneliminarEvent:  
			evDat = new EventoDataSource(EventoActivity.this);
			evDat.open();
		    eve = new Evento();
		    eve.setCodevento(codevento.getText().toString());
		    evDat.borrarEvento(eve);
		    evDat.close();
		    Toast.makeText(this, "Evento Eliminado",Toast.LENGTH_LONG).show();
		    limpiarCampos();
		    break;
		    
		  case R.id.btnbuscarEvent: 
			  evDat = new EventoDataSource(EventoActivity.this);
			evDat.open();
			eve = evDat.buscarEvento(codevento.getText().toString());
			if (eve!=null){
			codcliente.setText(eve.getCodcliente());
			nombre.setText(eve.getNombre());
			codsalon.setText(eve.getCodsalon());
			fecha.setText(eve.getFecha());
			horaini.setText(eve.getHoraini());
			horafin.setText(eve.getHorafin());
			confirmado.setText(eve.getConfirmado());
			descripcion.setText(eve.getDescripción());
			valorevento.setText(eve.getValorevento());
			btnactualizar.setEnabled(true);
			codevento.setEnabled(false);
			Toast.makeText(this, "Evento Encontrado",Toast.LENGTH_LONG).show();}
			else{
				Toast.makeText(this, "No se encontro el Evento",Toast.LENGTH_LONG).show();
			}
			evDat.close();
		    break;
		    
		    case R.id.btnactualizarEvent: 
		    	eve = new Evento(codevento.getText().toString(), codcliente.getText().toString(), codsalon.getText().toString(), nombre.getText().toString(), 
						descripcion.getText().toString(), fecha.getText().toString(), horaini.getText().toString(), horafin.getText().toString(),
						confirmado.getText().toString(), valorevento.getText().toString());
		            evDat = new EventoDataSource(EventoActivity.this);
		            evDat.open();
			        if (evDat.actualizarEvento(eve)){
						Toast.makeText(this, "Registro Actualizado",Toast.LENGTH_LONG).show();
		    			
			        }
			        else{
			        	Toast.makeText(this, "Error al actualizar",Toast.LENGTH_LONG).show();
		    			
			        }
			        evDat.close();
		    		
		    break;
		   
	}
		
	}
	
	
	private boolean verificarDatos(){
		if (codevento.getText().toString().equals("")){
			return false;
		}
		else{
			return true;
		}
	}
	
	private void limpiarCampos(){
		 codevento.setText("");
		 codcliente.setText("");
			nombre.setText("");
			codsalon.setText("");
			fecha.setText("");
			horaini.setText("");
			horafin.setText("");
			confirmado.setText("");
			descripcion.setText("");
			valorevento.setText("");
		 
	 }


	/**
	 * A placeholder fragment containing a simple view.
	 */


}
