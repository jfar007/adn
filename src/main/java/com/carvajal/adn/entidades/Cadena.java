package com.carvajal.adn.entidades;

public class Cadena {

	String tipo;
	int x;
	int y;
	String cadena;
	
	public Cadena(String tipo, int x, int y, String cadena) {
		super();
		this.tipo = tipo;
		this.x = x;
		this.y = y;
		this.cadena = cadena;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getCadena() {
		return cadena;
	}
	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	@Override
	public String toString() {
		return "Cadena [tipo=" + tipo + ", x=" + x + ", y=" + y + ", cadena=" + cadena + "]";
	}
	
	
	
}
