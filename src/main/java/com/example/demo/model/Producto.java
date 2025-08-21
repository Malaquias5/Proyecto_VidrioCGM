package com.example.demo.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock_actual;
	private String tipoVidrio;
	private String medidas;
	private String grosor;
	private String color;

	public Producto() {}

	public Producto(long id, String nombre, String descripcion, double precio, int stock_actual, String tipoVidrio, String medidas, String grosor, String color) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock_actual = stock_actual;
		this.tipoVidrio = tipoVidrio;
		this.medidas = medidas;
		this.grosor = grosor;
		this.color = color;
	}

	public long getId() { return id; }
	public void setId(long id) { this.id = id; }
	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getDescripcion() { return descripcion; }
	public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
	public double getPrecio() { return precio; }
	public void setPrecio(double precio) { this.precio = precio; }
	public int getStockActual() { return stock_actual; }
	public void setStockActual(int stock_Actual) { this.stock_Actual = stock_actual; }
	public String getTipoVidrio() { return tipoVidrio; }
	public void setTipoVidrio(String tipoVidrio) { this.tipoVidrio = tipoVidrio; }
	public String getMedidas() { return medidas; }
	public void setMedidas(String medidas) { this.medidas = medidas; }
	public String getGrosor() { return grosor; }
	public void setGrosor(String grosor) { this.grosor = grosor; }
	public String getColor() { return color; }
	public void setColor(String color) { this.color = color; }
}
