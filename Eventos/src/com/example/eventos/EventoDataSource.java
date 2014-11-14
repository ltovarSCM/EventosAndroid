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
public class EventoDataSource {
	
	private SQLiteDatabase bd;
    private BaseDatos db;
    private String[] columnas = { ManejadorBD.TEvento.CODEVENTO,
    		ManejadorBD.TEvento.CODCLIENTE,
    		ManejadorBD.TEvento.CODIGOSALON,
    		ManejadorBD.TEvento.NOMBRE,
    		ManejadorBD.TEvento.DESCRIPCION,
    		ManejadorBD.TEvento.FECHA,
    		ManejadorBD.TEvento.HORAINI,
    		ManejadorBD.TEvento.HORAFIN,
    		ManejadorBD.TEvento.CONFIRMADO,
    		ManejadorBD.TEvento.VALOREVENTO
    		};
    
    public EventoDataSource(Context context) {
        db = new BaseDatos(context);
    }
 
    public void open() {
      bd  = db.getWritableDatabase();
    }
 
    public void close() {
       bd.close();
    }

    public void crearEvento(Evento e) {
        ContentValues values = new ContentValues();
        values.put(columnas[0], e.getCodevento());
        values.put(columnas[1], e.getCodcliente());
        values.put(columnas[2], e.getCodsalon());
        values.put(columnas[3], e.getNombre());
        values.put(columnas[4], e.getDescripción());
        values.put(columnas[5], e.getFecha());
        values.put(columnas[6], e.getHoraini());
        values.put(columnas[7], e.getHorafin());
        values.put(columnas[8], e.getConfirmado());
        values.put(columnas[9], e.getValorevento());
        bd.insert(ManejadorBD.TABLA_EVENTO, null, values);
    }
    
    public List<Evento> getAllEvento() {
        List<Evento> listaEvento = new ArrayList<Evento>();
 
        Cursor cursor = bd.query(ManejadorBD.TABLA_EVENTO, columnas, null, null,
                null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Evento nuevoEvento = cursorToEvento(cursor);
            listaEvento.add(nuevoEvento);
            cursor.moveToNext();
        }
 
        cursor.close();
        return listaEvento;
    }
    
    public Cursor listaEvento() {
        
        Cursor cursor = bd.query(ManejadorBD.TABLA_EVENTO, columnas, null, null,
                null, null, null);
        
        return cursor;
    }
    
    public void borrarEvento(Evento e) {
        String codevent= e.getCodevento();
        bd.delete(ManejadorBD.TABLA_EVENTO, ManejadorBD.TEvento.CODEVENTO + " = ?",new String[]{codevent});
       	       
    }
    
    public Evento buscarEvento(String codevento) {
	     Cursor cursor = bd.query(ManejadorBD.TABLA_EVENTO, columnas, 
	      ManejadorBD.TEvento.CODEVENTO+ " = ?", new String[]{codevento},
	      null, null, null);
	       if (cursor.getCount()>0){
	         cursor.moveToFirst();
	         Evento e1= new Evento();
	          e1.setCodevento(cursor.getString(0));
	          e1.setCodcliente(cursor.getString(1));
	          e1.setCodsalon(cursor.getString(2));
	          e1.setNombre(cursor.getString(3));
	          e1.setDescripción(cursor.getString(4));
	          e1.setFecha(cursor.getString(5));
	          e1.setHoraini(cursor.getString(6));
	          e1.setHorafin(cursor.getString(7));
	          e1.setConfirmado(cursor.getString(8));
	          e1.setValorevento(cursor.getString(9));
	          
	          return e1;
	          }
	             else return null;
	    }
    
    public boolean actualizarEvento(Evento e){
    	try{
    	String codevent = e.getCodevento();
    	ContentValues values = new ContentValues();
        values.put(columnas[0], e.getCodevento());
        values.put(columnas[1], e.getCodcliente());
        values.put(columnas[2], e.getCodsalon());
        values.put(columnas[3], e.getNombre());
        values.put(columnas[4], e.getDescripción());
        values.put(columnas[5], e.getFecha());
        values.put(columnas[6], e.getHoraini());
        values.put(columnas[7], e.getHorafin());
        values.put(columnas[8], e.getConfirmado());
        values.put(columnas[9], e.getValorevento());
        
        bd.update(ManejadorBD.TABLA_EVENTO, values, ManejadorBD.TEvento.CODEVENTO + " = ?",new String[]{codevent});
    	return true;
    	}
    	catch (Exception e2){ 
    		return false;
    	}
    	
    }
    
    private Evento cursorToEvento(Cursor cursor) {
        Evento evento = new Evento();
        evento.setCodevento(cursor.getString(0));
        evento.setCodcliente(cursor.getString(1));
        evento.setCodsalon(cursor.getString(2));
        evento.setNombre(cursor.getString(3));
        evento.setDescripción(cursor.getString(4));
        evento.setFecha(cursor.getString(5));
        evento.setHoraini(cursor.getString(6));
        evento.setHorafin(cursor.getString(7));
        evento.setConfirmado(cursor.getString(8));
        evento.setValorevento(cursor.getString(9));
                
        return evento;
    }
    
	public EventoDataSource() {
		// TODO Auto-generated constructor stub
	}

}
