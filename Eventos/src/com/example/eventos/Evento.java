/**
 * 
 */
package com.example.eventos;

/**
 * @author LILIANA
 *
 */
public class Evento {
	
	private String codcliente;
	private String codsalon;
	private String nombre;
	private String descripción;
	private String fecha;
	private String horaini;
	private String horafin;
	private String confirmado;
	private String valorevento;


	public Evento(String codEvento, String codCliente, String codSalon, String nombre, 
			String descripcion, String fechaEvento, String horaInicio, String horaFinal,
			String confirmado, String valorEvento) {
			super();
			this.codevento = codEvento;
			this.codcliente = codCliente;
			this.codsalon = codSalon;
			this.nombre = nombre;
			this.descripción = descripcion;
			this.fecha = fechaEvento;
			this.horaini = horaInicio;
			this.horafin = horaFinal;
			this.confirmado = confirmado;
			this.valorevento = valorEvento;
				
	}

	
	public Evento() {
		// TODO Auto-generated constructor stub
	}

	private String codevento;
	public String getCodevento() {
		return codevento;
	}


	public void setCodevento(String codevento) {
		this.codevento = codevento;
	}


	public String getCodcliente() {
		return codcliente;
	}


	public void setCodcliente(String codcliente) {
		this.codcliente = codcliente;
	}


	public String getCodsalon() {
		return codsalon;
	}


	public void setCodsalon(String codsalon) {
		this.codsalon = codsalon;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripción() {
		return descripción;
	}


	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getHoraini() {
		return horaini;
	}


	public void setHoraini(String horaini) {
		this.horaini = horaini;
	}


	public String getHorafin() {
		return horafin;
	}


	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}


	public String getConfirmado() {
		return confirmado;
	}


	public void setConfirmado(String confirmado) {
		this.confirmado = confirmado;
	}


	public String getValorevento() {
		return valorevento;
	}


	public void setValorevento(String valorevento) {
		this.valorevento = valorevento;
	}




}
