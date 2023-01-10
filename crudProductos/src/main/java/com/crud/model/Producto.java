package com.crud.model;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="productos") //Las tablas se nombran en plural 
public class Producto {
	
	@Id  //Es llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Con esto es auto incrementable
	private Integer Id;
	
	private String nombre;
	
	private String descripcion;
	
	private Double precio;
	
	//Metodos
	public Producto() {
		super();
	}
	
	public Producto(Integer id, String nombre, String descripcion, Double precio) {
		super();
		Id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [Id=" + Id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ "]";
	}

}
