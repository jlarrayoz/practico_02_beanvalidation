package uy.org.curso;

import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class LineaFactura {
	
	@NotNull(message = "El id NO puede ser nulo")
	private Long id;
	
	//Se puede apreciar un ejemplo de message interpolation
	@Size(min = 1, max = 10, message = "La descripcion debe estar entre {min} y {max}")
	private String producto;
	
	@Min(value = 1, message = "La cantidad de la linea debe ser mayor a {value}")
	private int cantidad;
	
	@Positive(message = "El precio debe ser > a 0")
	private BigDecimal precio;
	
	
	public LineaFactura(Long id, String producto, int cantidad, BigDecimal precio) {
		super();
		this.id = id;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
}
