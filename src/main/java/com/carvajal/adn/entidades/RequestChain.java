package com.carvajal.adn.entidades;

public class RequestChain {

	String part_one;
	String part_two;
	String part_three;
	String part_four;
	String part_five;
	String part_six;
	
	
	
	public RequestChain(String part_one, String part_two, String part_three, String part_four, String part_five,
			String part_six) {
		super();
		this.part_one = part_one;
		this.part_two = part_two;
		this.part_three = part_three;
		this.part_four = part_four;
		this.part_five = part_five;
		this.part_six = part_six;
	}

	public String getPart_one() {
		return part_one;
	}



	public void setPart_one(String part_one) {
		this.part_one = part_one;
	}



	public String getPart_two() {
		return part_two;
	}



	public void setPart_two(String part_two) {
		this.part_two = part_two;
	}



	public String getPart_three() {
		return part_three;
	}



	public void setPart_three(String part_three) {
		this.part_three = part_three;
	}



	public String getPart_four() {
		return part_four;
	}



	public void setPart_four(String part_four) {
		this.part_four = part_four;
	}



	public String getPart_five() {
		return part_five;
	}



	public void setPart_five(String part_five) {
		this.part_five = part_five;
	}



	public String getPart_six() {
		return part_six;
	}



	public void setPart_six(String part_six) {
		this.part_six = part_six;
	}



	public String[] getChain(){
		String[] chain = {this.part_one,this.part_two,this.part_three,this.part_four,this.part_five, this.part_six};
		return chain;
	}
	
	
	
	
}
