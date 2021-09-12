package com.carvajal.adn.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.carvajal.adn.entidades.Cadena;

public class Processor {
	
	private List<Cadena> cadenas;
	private List<Cadena> malformaciones;
	
	

	public Processor() {
		super();
		this.cadenas = new ArrayList<Cadena>();
		this.malformaciones = new ArrayList<Cadena>();
	}

	public String[][] toMatriz(String[][] adn,String[] dna,int i,int j) {
		if (j < dna[0].length() &&  i != dna.length) {
			adn[i][j] = String.valueOf(dna[i].charAt(j));
			j++;
		}else if(i < dna.length) {
			i++; j=0;
		}else {
			return adn;
		}
		return toMatriz(adn, dna, i,j);
	}
	
	private void obtenerCadenasHorizontales(String[][] adn, List<Cadena> acum ) {
		for (int i = 0; i < adn.length; i++) {
			for (int j = 0; j < (adn.length / 2); j++) {
				String cadena = obteneCadena(adn,i,j,adn[i][j],3);
				Cadena cad = new Cadena("Horizontal", i, j, cadena);
				acum.add(cad);
			}
		}
	}
	
	private void obtenerCadenasVerticales(String[][] adn, List<Cadena> acum ) {
		for (int i = 0; i < (adn.length / 2) ; i++) {
			for (int j = 0; j < adn.length ; j++) {
				String cadena = obteneCadena(adn,i,j,adn[i][j],4);
				Cadena cad = new Cadena("Vertical", i, j, cadena);
				acum.add(cad);
			}
		}
	}
	
	private void obtenerCadenasOblicuas(String[][] adn,int sentido, List<Cadena> acum ) {
		for ( int i = 0; i <  (adn.length / 2); i++) {
			for (int j = (sentido == 1 ? 0 :(adn.length / 2)); j < (sentido == 1 ? (adn.length / 2) :adn.length); j++) {
				String cadena = obteneCadena(adn,i,j,adn[i][j],sentido);
				Cadena cad = new Cadena("Oblicua"+ sentido, i, j, cadena);
				acum.add(cad);
			}
		}
	}
	private String obteneCadena(String[][] adn, int i, int j, String currentCadena,int sentido) {
		i = (sentido == 3) ? i : i+ 1;
		j = (currentCadena.length() < 4 && (sentido == 1 || sentido == 3)) ? j + 1 : (sentido == 4 ? j : j - 1);
		if (currentCadena.length() < 4) {
			currentCadena = currentCadena.concat(adn[i][j]);
			return obteneCadena(adn,i,j,currentCadena,sentido);
		}else {
			return currentCadena;
		}
	}
	
	public void procesarADN(String[][] adn) {
		obtenerCadenasHorizontales(adn, cadenas);
		obtenerCadenasVerticales(adn, cadenas);
		obtenerCadenasOblicuas(adn,1,cadenas);
		obtenerCadenasOblicuas(adn,2,cadenas);
	}
	
	public List<Cadena> obtenerMalformacione(){
		return cadenas.stream().filter(c -> c.getCadena().matches("["+c.getCadena().charAt(0)+"]{4}")) .collect(Collectors.toList());
	}
	
	public boolean tieneMalformaciones(){
		
		return obtenerMalformacione().size() > 0;
	}

	public List<Cadena> getMalformaciones() {
		return malformaciones;
	}

	public void setMalformaciones(List<Cadena> malformaciones) {
		this.malformaciones = malformaciones;
	}
	
	
}
