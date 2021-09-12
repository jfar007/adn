package com.carvajal.adn.handler;

import java.util.ArrayList;
import java.util.List;

import com.carvajal.adn.entidades.Persona;

public class DBHandler {


    private static DBHandler instancia = null;
 

    public List<Persona> personas;
 
    private DBHandler()
    {
        personas = new ArrayList<Persona>();
    }

    
    public static DBHandler getInstance()
    {
        if (instancia == null)
        	instancia = new DBHandler();
 
        return instancia;
    }
}
