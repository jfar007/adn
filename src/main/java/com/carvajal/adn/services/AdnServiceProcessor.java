package com.carvajal.adn.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;

import com.carvajal.adn.entidades.Cadena;
import com.carvajal.adn.entidades.Persona;
import com.carvajal.adn.handler.DBHandler;
import com.carvajal.adn.processor.Processor;

public class AdnServiceProcessor {

	
	DBHandler handler;
	
	public boolean salvarCaso(String usuario,  String[] adn){
		
		try {
			Processor processor = new Processor();
			String[][] adnmt = new String[6][6];
			adnmt = processor.toMatriz(adnmt, adn, 0, 0);
			processor.procesarADN(adnmt); 			
			Persona persona = new Persona(usuario, adn ,adnmt, processor.tieneMalformaciones(),processor.obtenerMalformacione());
			handler.getInstance().personas.add(persona);
			return true;
		} catch (Exception e) {
			return false;
		}		
	}
	
	public List<Persona> casos(String usuario){
		List<Persona> casos = new ArrayList<Persona>();
		List<Persona> temp  = handler.getInstance().personas.stream().filter(p -> p.getUsuario() == usuario) .collect(Collectors.toList());
		
		return temp.size() > 0 ? temp : null;
	}
	
	public String statusCasos(String usuario){
		int procesados =  handler.getInstance().personas.stream().filter(p -> p.getUsuario() == usuario).collect(Collectors.toList()).size();
		int malformaciones =  handler.getInstance().personas.stream().filter(p -> p.getUsuario() == usuario && p.tieneMalformacion()).collect(Collectors.toList()).size();
		double toal = procesados > 0 ? malformaciones / procesados : 0;
		String st = "[{\"count_correct_dna\":\"0\",\"count_defect_dna\":\"0\",\"ratio”\":\"0\"}]";
		st = st.replaceFirst("0",String.valueOf(malformaciones));
		st =st.replaceFirst("0",String.valueOf(procesados));
		st = st.replaceFirst("0",String.valueOf(toal));
		return st;  
	}
	
}
