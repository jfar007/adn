package com.carvajal.adn.mensaje;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MensajeRespuesta<T> {
	private String message;
	private String url;
	private String error = "";
	private List<T> data = new ArrayList<T>();
	
	public MensajeRespuesta(String message, String url, String error, List<T> data) {
		super();
		this.message = message;
		this.url = url;
		this.error = error;
		this.data = data;
	}

	public MensajeRespuesta(String message, String url, String error) {
		this.message = message;
		this.url = url;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}


	
	
	
}

