package uy.org.curso;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Factura {
	
	@Future
	private Date fecha;
	
	@NotBlank(message = "Usuario no puede ser vacio")
	private String usuario;
	
	@NotNull(message = "{factura.email.notNull}")
	@Email(message = "{factura.email.invalid}")
	private String email;
	
	//Dispara la validacion en cascada 
	@Valid
	private List<LineaFactura> lineas = new ArrayList<LineaFactura>();
	
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public List<LineaFactura> getLineas() {
		return lineas;
	}
	public void setLineas(List<LineaFactura> lineas) {
		this.lineas = lineas;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
}
