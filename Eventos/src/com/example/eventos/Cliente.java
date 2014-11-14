package com.example.eventos;

public class Cliente {

	public Cliente(String documento, String nombre, String telefono,
			String correo, String empresa) {
		super();
		this.codcliente = documento;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correo = correo;
		this.empresa = empresa;
	}
	
	public Cliente(){
		
	}
private String codcliente;
private String nombre;
private String telefono;
private String correo;
private String empresa;
public String getCodCliente() {
	return codcliente;
}
public void setCodCliente(String codcliente) {
	this.codcliente = codcliente;
			};

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getTelefono() {
	return telefono;
}
public void setTelefono(String telefono) {
	this.telefono = telefono;
}
public String getCorreo() {
	return correo;
}
public void setCorreo(String correo) {
	this.correo = correo;
}
public String getEmpresa() {
	return empresa;
}
public void setEmpresa(String empresa) {
	this.empresa = empresa;
}


}
