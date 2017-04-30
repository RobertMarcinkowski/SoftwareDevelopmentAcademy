package com.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Producer {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String  nazwaStudia;
	@Embedded
	private ImieINazwisko imieINazwisko;
	
	@OneToMany(mappedBy = "producer", fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	private Set<Movie> movies;
	
	
	@Version
	private int version;
	
	public Producer(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNazwaStudia() {
		return nazwaStudia;
	}
	public void setNazwaStudia(String nazwaStudia) {
		this.nazwaStudia = nazwaStudia;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	public ImieINazwisko getImieINazwisko() {
		return imieINazwisko;
	}

	public void setImieINazwisko(ImieINazwisko imieINazwisko) {
		this.imieINazwisko = imieINazwisko;
	}

	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}
	
	
	
	
	
}
