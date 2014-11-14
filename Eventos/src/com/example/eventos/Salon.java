/**
 * 
 */
package com.example.eventos;

/**
 * @author LILIANA
 *
 */
public class Salon {
	
	public Salon (String codsalon, String nombre, String capacidad, String preciohora){
		super();
		this.codSalon = codsalon;
		this.nombreSalon = nombre;
		this.capacidadSalon = capacidad;
		this.precioHora = preciohora;
			
	}
	
	public Salon () {
	}
	
	private String codSalon;
	private String nombreSalon;
	private String capacidadSalon;
	private String precioHora;
	
	public String getCodSalon() {
		return codSalon;
	}

	public void setCodSalon(String codSalon) {
		this.codSalon = codSalon;
	}

	public String getNombreSalon() {
		return nombreSalon;
	}

	public void setNombreSalon(String nombreSalon) {
		this.nombreSalon = nombreSalon;
	}

	public String getCapacidadSalon() {
		return capacidadSalon;
	}

	public void setCapacidadSalon(String capacidadSalon) {
		this.capacidadSalon = capacidadSalon;
	}

	public String getPrecioHora() {
		return precioHora;
	}

	public void setPrecioHora(String precioHora) {
		this.precioHora = precioHora;
	}


	

}
