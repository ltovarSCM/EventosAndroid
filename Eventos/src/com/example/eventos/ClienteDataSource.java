package com.example.eventos;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ClienteDataSource {
	 private SQLiteDatabase bd;
	    private BaseDatos db;
	    private String[] columnas = { ManejadorBD.TCliente.CODCLIENTE,
	    		ManejadorBD.TCliente.NOMBRE,
	    		ManejadorBD.TCliente.TELEFONO,
	    		ManejadorBD.TCliente.CORREO,
	    		ManejadorBD.TCliente.EMPRESA,
	    		};
	 
		    public ClienteDataSource(Context context) {
	        db = new BaseDatos(context);
	    }
	 
	    public void open() {
	      bd  = db.getWritableDatabase();
	    }
	 
	    public void close() {
	       bd.close();
	    }
	 
	    public void crearCliente(Cliente c) {
	        ContentValues values = new ContentValues();
	        values.put(columnas[0], c.getCodCliente());
	        values.put(columnas[1], c.getNombre());
	        values.put(columnas[2], c.getTelefono());
	        values.put(columnas[3], c.getCorreo());
	        values.put(columnas[4], c.getEmpresa());
	        bd.insert(ManejadorBD.TABLA_CLIENTE, null, values);
	    }
	 
	    public List<Cliente> getAllCliente() {
	        List<Cliente> listaCliente = new ArrayList<Cliente>();
	 
	        Cursor cursor = bd.query(ManejadorBD.TABLA_CLIENTE, columnas, null, null,
	                null, null, null);
	        cursor.moveToFirst();
	        while (!cursor.isAfterLast()) {
	            Cliente nuevoCliente = cursorToCliente(cursor);
	            listaCliente.add(nuevoCliente);
	            cursor.moveToNext();
	        }
	 
	        cursor.close();
	        return listaCliente;
	    }
	    
	    public Cursor listaCliente() {
	        
	        Cursor cursor = bd.query(ManejadorBD.TABLA_CLIENTE, columnas, null, null,
	                null, null, null);
	        
	        return cursor;
	    }
	 
  public Cursor listaCliente2() {
	        
	        Cursor cursor = bd.rawQuery("select codcliente as _id, nombre, telefono, correo,empresa from Cliente",null);
	        
	        return cursor;
	    }
	    public void borrarCliente(Cliente c) {
	        String codcliente= c.getCodCliente();
	        bd.delete(ManejadorBD.TABLA_CLIENTE, ManejadorBD.TCliente.CODCLIENTE + " = ?",new String[]{codcliente});
	       	       
	    }
	    
	    public Cliente buscarCliente(String codcliente) {
	     Cursor cursor = bd.query(ManejadorBD.TABLA_CLIENTE, columnas, 
	      ManejadorBD.TCliente.CODCLIENTE+ " = ?", new String[]{codcliente},
	      null, null, null);
	       if (cursor.getCount()>0){
	         cursor.moveToFirst();
	         Cliente c1= new Cliente();
	          c1.setCodCliente(cursor.getString(0));
	          c1.setNombre(cursor.getString(1));
	          c1.setTelefono(cursor.getString(2));
	          c1.setCorreo(cursor.getString(3));
	          c1.setEmpresa(cursor.getString(4));
	          return c1;
	          }
	             else return null;
	    }
	    
	    public boolean actualizarCliente(Cliente c){
	    	try{
	    	String codcliente = c.getCodCliente();
	    	ContentValues values = new ContentValues();
	        values.put(columnas[0], c.getCodCliente());
	        values.put(columnas[1], c.getNombre());
	        values.put(columnas[2], c.getTelefono());
	        values.put(columnas[3], c.getCorreo());
	        values.put(columnas[4], c.getEmpresa());
	        bd.update(ManejadorBD.TABLA_CLIENTE, values, ManejadorBD.TCliente.CODCLIENTE + " = ?",new String[]{codcliente});
	    	return true;
	    	}
	    	catch (Exception e){ 
	    		return false;
	    	}
	    	
	    }
	    
	    private Cliente cursorToCliente(Cursor cursor) {
	        Cliente cliente = new Cliente();
	        cliente.setCodCliente(cursor.getString(0));
	        cliente.setNombre(cursor.getString(1));
	        cliente.setTelefono(cursor.getString(2));
	        cliente.setCorreo(cursor.getString(3));
	        cliente.setEmpresa(cursor.getString(4));
	        return cliente;
	    }
}
