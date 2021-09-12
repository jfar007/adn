package com.carvajal.adn.rest;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carvajal.adn.entidades.Persona;
import com.carvajal.adn.entidades.RequestChain;
import com.carvajal.adn.mensaje.MensajeRespuesta;
import com.carvajal.adn.services.AdnServiceProcessor;


@RestController
@RequestMapping("/api/v1/adn")
@CrossOrigin()
public class AdnController {
	
	
	AdnServiceProcessor processorService;

	
	@GetMapping("/casoss")
	public String welcomePage() {
        return "Welcome!";
    }
	
	@GetMapping("/casos")
	public ResponseEntity<MensajeRespuesta> getCasos(HttpServletRequest request) {
	
		processorService = new AdnServiceProcessor();
		String message = "Consulta procesada correctamente.";
		try {
			List<Persona> casos= processorService.casos("1");	
				
		
		return new ResponseEntity<MensajeRespuesta>(new MensajeRespuesta(message, 
				request.getRequestURI(),message, casos), HttpStatus.OK);	
		
		}catch(Exception e) {
			message = e.getMessage();
			return new ResponseEntity<MensajeRespuesta>(new MensajeRespuesta(message, 
					request.getRequestURI(),message, null), HttpStatus.NO_CONTENT);	
		}		
	}
	
	@PostMapping("/crear")
	public ResponseEntity<MensajeRespuesta> evaluarCaso(@RequestBody RequestChain adn, HttpServletRequest request) {
		try {
		processorService = new AdnServiceProcessor();
		processorService.salvarCaso("1",adn.getChain());
		return getCasos(request);
		}catch(Exception e) {
			String message = "Registro no se pudo crear.";
			return new ResponseEntity<MensajeRespuesta>(new MensajeRespuesta(message, 
					request.getRequestURI(),message, null), HttpStatus.NO_CONTENT);	
		}
	} 
	
	@GetMapping("/status")
	public String statusCasos(HttpServletRequest request) {
		

		processorService = new AdnServiceProcessor();
		
		return processorService.statusCasos("1");
		
	} 
}
