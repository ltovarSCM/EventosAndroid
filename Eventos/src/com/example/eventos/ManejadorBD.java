package com.example.eventos;

import android.provider.BaseColumns;
public class ManejadorBD {
	public static final String TABLA_EVENTO = "Evento";
	public static final String TABLA_CLIENTE = "Cliente";
    public static final String TABLA_SALON = "Salon";
    
    public static final class TCliente implements BaseColumns{
    	public static final String CODCLIENTE = "codcliente";
        public static final String NOMBRE = "nombre";
        public static final String TELEFONO = "telefono";
        public static final String CORREO = "correo";
        public static final String EMPRESA = "empresa";
    	    }
    public static final class TSalon implements BaseColumns{
    	public static final String CODIGOSALON = "codsalon";
        public static final String NOMBRE = "nombre";
        public static final String CAPACIDAD = "capacidad";
        public static final String PRECIOHORA = "preciohora";
               
    }
    public static final class TEvento implements BaseColumns{
    	public static final String CODEVENTO = "codevento";
    	public static final String CODCLIENTE = "codcliente";
    	public static final String NOMBRE = "nombre";
        public static final String DESCRIPCION = "descripcion";
        public static final String CODIGOSALON = "codsalon";
        public static final String FECHA = "fecha";
        public static final String HORAINI = "horaini";
        public static final String HORAFIN = "horafin";
        public static final String CONFIRMADO = "confirmado";
        public static final String VALOREVENTO = "valorevento";
    }
    	
    public static String tabla_salon = "CREATE TABLE " + ManejadorBD.TABLA_SALON + "(" 
    		+ TSalon.CODIGOSALON + " TEXT, " 
    		+ TSalon.NOMBRE + " TEXT,"
    		+ TSalon.CAPACIDAD + " TEXT,"
    		+ TSalon.PRECIOHORA + 
    		" text, PRIMARY KEY ("+ TSalon.CODIGOSALON+"));";
    public static String tabla_cliente = "CREATE TABLE " + ManejadorBD.TABLA_CLIENTE+ "(" 
    		+ TCliente.CODCLIENTE + " TEXT, " 
    		+ TCliente.NOMBRE + " TEXT,"
    		+ TCliente.TELEFONO + " TEXT,"
    		+ TCliente.CORREO + " TEXT," 
    		+ TCliente.EMPRESA + " text, PRIMARY KEY ("+ TCliente.CODCLIENTE+"));";
  
   public static String tabla_evento = "CREATE TABLE " + ManejadorBD.TABLA_EVENTO  + "( " 
    		+ TEvento.CODEVENTO + " TEXT, " 
    		+ TEvento.CODCLIENTE+ " TEXT,"
    		+ TEvento.NOMBRE + " TEXT,"
    		+ TEvento.DESCRIPCION + " TEXT,"
    		+ TEvento.CODIGOSALON + " TEXT," 
    		+ TEvento.FECHA+ " TEXT," 
    	    + TEvento.HORAINI+ " text,"
    	    + TEvento.HORAFIN+ " text,"
    	    + TEvento.CONFIRMADO+ " text,"
    	    + TEvento.VALOREVENTO+ " text,"
    	    + " text, PRIMARY KEY ("+ TEvento.CODEVENTO+"));";
 
}
