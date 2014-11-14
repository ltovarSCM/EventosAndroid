package com.example.eventos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
 
public class BaseDatos extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "Eventos.db";
    ;
     
    public BaseDatos(Context context) {
        super(context, DATABASE_NAME, null, 3);
        }
    @Override
    public void onCreate(SQLiteDatabase db) {
    
        db.execSQL(ManejadorBD.tabla_cliente);
        db.execSQL(ManejadorBD.tabla_salon);
        db.execSQL(ManejadorBD.tabla_evento);
    }   
    @Override
    public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion) {
   
        android.util.Log.v("Eventos","Actualizando Base de datos, se destruirán los datos viejos");       
        db.execSQL("DROP TABLE IF EXISTS Cliente");
        db.execSQL("DROP TABLE IF EXISTS Salon");
        db.execSQL("DROP TABLE IF EXISTS Evento");
        onCreate(db);
    }
}
