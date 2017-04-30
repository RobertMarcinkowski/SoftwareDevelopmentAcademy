package com.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Movie {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	private String title;
	private String year;
	
	
	@Column 
	// ta adnotacja nie robi nic
	// stosujemy są jeśli nadpisac domyslne ustawienia kolumny
	// zmienić nazwę, ustawić długość,
	// ustawić że kolumna ma być nullable lub nie
	private int length;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "producer")
	private Producer producer;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="movies" )
	private Set<Actor> actors;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="movie" )
	private Set<MovieRating> movieRating;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy="movie" )
	private Set<MovieComment> movieComments;
		
	@OneToOne(mappedBy = "movie")
	MovieDescription movieDescription;
	
	@Transient
	private double avg;
	
	
	public Movie(String title, double avg) {
		super();
		this.title = title;
		this.avg = avg;
	}



	public Movie(){}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public MovieDescription getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(MovieDescription movieDescription) {
		this.movieDescription = movieDescription;
	}



	public double getAvg() {
		return avg;
	}



	public void setAvg(double avg) {
		this.avg = avg;
	}

	
	
	
}
