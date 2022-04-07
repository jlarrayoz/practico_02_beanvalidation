package uy.org.curso;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Main {
	
	public static void main(String[] args) {
		//Inicializo la API de bean validations
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		
		//Creo una factura
		Factura factura = new Factura();
		factura.setFecha(new Date());
		factura.setEmail("asdasdasd");
		
		//Creo 2 lineas y la agrego a la factura
		LineaFactura lineaMartillo = new LineaFactura(1L, "Martillo", 0, new BigDecimal("200.00"));
		LineaFactura lineaClavos = new LineaFactura(null, "Clavos", 20, new BigDecimal("50.00"));
		factura.getLineas().add(lineaMartillo);
		factura.getLineas().add(lineaClavos);
		
		//Ejecuto las validaciones sobre la facutra
		Set<ConstraintViolation<Factura>> validaciones = validator.validate(factura);
		
		if (!validaciones.isEmpty()) {
			for(ConstraintViolation<Factura> constraint : validaciones) {
				System.out.println("ERROR: " + constraint.getMessage());
			}
		}
		else {
			System.out.println("INFO: no ocurrieron errores");
		}
	}
}
