package com.carvajal.adn.entidades;

import java.util.List;

public class Persona {

	private String usuario;
	private String[] cadenaAdn;
	private String[][] adn;
	private boolean tieneMalformacion;
	private List<Cadena> malformaciones;
	
	public Persona(String usuario, String[] cadenaAdn, String[][] adn, boolean tieneMalformacion,
			List<Cadena> malformaciones) {
		super();
		this.usuario = usuario;
		this.cadenaAdn = cadenaAdn;
		this.adn = adn;
		this.tieneMalformacion = tieneMalformacion;
		this.malformaciones = malformaciones;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String[] getCadenaAdn() {
		return cadenaAdn;
	}

	public void setCadenaAdn(String[] cadenaAdn) {
		this.cadenaAdn = cadenaAdn;
	}

	public String[][] getAdn() {
		return adn;
	}

	public void setAdn(String[][] adn) {
		this.adn = adn;
	}

	public boolean tieneMalformacion() {
		return tieneMalformacion;
	}

	public void setTieneMalformacion(boolean tieneMalformacion) {
		this.tieneMalformacion = tieneMalformacion;
	}

	public List<Cadena> getMalformaciones() {
		return malformaciones;
	}

	public void setMalformaciones(List<Cadena> malformaciones) {
		this.malformaciones = malformaciones;
	}
	
	
	
	
}
