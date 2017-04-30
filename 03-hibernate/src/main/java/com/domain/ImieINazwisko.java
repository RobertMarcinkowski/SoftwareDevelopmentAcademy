package com.domain;

import javax.persistence.Embeddable;

@Embeddable
public class ImieINazwisko {

	private String imie;
	private String nazwisko;
	
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	
}
