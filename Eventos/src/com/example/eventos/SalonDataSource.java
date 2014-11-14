/**
 * 
 */
package com.example.eventos;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


/**
 * @author LILIANA
 *
 */
public class SalonDataSource {

	 private SQLiteDatabase bd;
	    private BaseDatos db;
        //Define las columnas para los comandos select
	    private String[] columnas = { ManejadorBD.TSalon.CODIGOSALON,
	    		ManejadorBD.TSalon.NOMBRE,
	    		ManejadorBD.TSalon.CAPACIDAD,
	    		ManejadorBD.TSalon.PRECIOHORA,
	    		};

	public SalonDataSource(Context context) {
		// TODO Auto-generated constructor stub
        db = new BaseDatos(context);
		
	}
	
	//Abrir la base de datos
    public void open() {
      bd  = db.getWritableDatabase();
    }
//Cerrar la base de datos

    public void close() {
       bd.close();
    }
  //Metodo que crea un salon en la tabla Salon	 
    public void crearSalon(Salon s) {
//Defino los valores que se van a insertar
        ContentValues values = new ContentValues();
//Coloco cada valor en un par (variable, valor)
        values.put(columnas[0], s.getCodSalon());
        values.put(columnas[1], s.getNombreSalon());
        values.put(columnas[2], s.getCapacidadSalon());
        values.put(columnas[3], s.getPrecioHora());
        
//Inserto en la tabla Salon los valores
        bd.insert(ManejadorBD.TABLA_SALON, null, values);
    }
    
    
  //Consulto todos los salones de la tabla y los guardo en una lista
    public List<Salon> getAllSalon() {
        List<Salon> listaSalon = new ArrayList<Salon>();
 //Consulto todos los campo de la base de datos
        Cursor cursor = bd.query(ManejadorBD.TABLA_SALON, columnas, null, null, null, null, null);
  //Me muevo por todos los registros de la consulta
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
//Creo el salon llamando al método cursorToSalon y lo agrego a lista
            Salon nuevoSalon = cursorToSalon(cursor);
            listaSalon.add(nuevoSalon);
            cursor.moveToNext();
        }
 
        cursor.close();
        return listaSalon;
    }
    
    
    public Cursor listaSalon() {
        
        Cursor cursor = bd.query(ManejadorBD.TABLA_SALON, columnas, null, null,
                null, null, null);
        
        return cursor;
    }
    
    
  //Metodo para borrar un Salon
    public void borrarSalon(Salon s) {
        String codSalon= s.getCodSalon();
        bd.delete(ManejadorBD.TABLA_SALON, ManejadorBD.TSalon.CODIGOSALON + " = ?",new String[]{codSalon});
       	       
    }
    
  //Metodo para buscar un Salon 	    
    public Salon buscarSalon(String codSalon) {
     Cursor cursor = bd.query(ManejadorBD.TABLA_SALON, columnas, 
      ManejadorBD.TSalon.CODIGOSALON+ " = ?", new String[]{codSalon}, null, null, null);
       if (cursor.getCount()>0){
         cursor.moveToFirst();
         Salon s1= new Salon();
          s1.setCodSalon(cursor.getString(0));
          s1.setNombreSalon(cursor.getString(1));
          s1.setCapacidadSalon(cursor.getString(2));
          s1.setPrecioHora(cursor.getString(3));
          return s1;
          }
             else return null;
    }

  //Metodo para actualizar un salon
    public boolean actualizarSalon(Salon s){
    	try{
    	String codSalon = s.getCodSalon();
    	ContentValues values = new ContentValues();
        values.put(columnas[0], s.getCodSalon());
        values.put(columnas[1], s.getNombreSalon());
        values.put(columnas[2], s.getCapacidadSalon());
        values.put(columnas[3], s.getPrecioHora());
        bd.update(ManejadorBD.TABLA_SALON, values, ManejadorBD.TSalon.CODIGOSALON + " = ?",new String[]{codSalon});
    	return true;
    	}
    	catch (Exception e){ 
    		return false;
    	}
    	
    }
    
    private Salon cursorToSalon(Cursor cursor) {
        Salon salon = new Salon();
        salon.setCodSalon(cursor.getString(0));
        salon.setNombreSalon(cursor.getString(1));
        salon.setCapacidadSalon(cursor.getString(2));
        salon.setPrecioHora(cursor.getString(3));
        return salon;
    }

}
