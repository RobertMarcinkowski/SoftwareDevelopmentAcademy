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
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name="AKTORZY")
public class Actor {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Embedded
	private ImieINazwisko imieINazwisko;
	private int wiek;
	@Version
	private int version;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "movie")
	private Set<Movie> movies;
	
	@Transient
	private boolean czyJestSuper;
	
	public Actor(){}

	public Actor(Long id, int wiek) {
		super();
		this.id = id;
		this.wiek = wiek;
	}

	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public ImieINazwisko getImieINazwisko() {
		return imieINazwisko;
	}

	public void setImieINazwisko(ImieINazwisko imieINazwisko) {
		this.imieINazwisko = imieINazwisko;
	}

	public int getWiek() {
		return wiek;
	}
	public void setWiek(int wiek) {
		this.wiek = wiek;
	}

	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
}
