package movie;

import java.util.ArrayList;
import java.util.List;

public class Movie {
	private String tytul;
	private String producent;
	private String rok;
	private int dlugosc;
	private List<Actor> actors = new ArrayList<Actor>();

	public Movie() {
		super();
	}

	public Movie(String tytul, String producent, String rok, int dlugosc, List<Actor> actors) {
		super();
		this.tytul = tytul;
		this.producent = producent;
		this.rok = rok;
		this.dlugosc = dlugosc;
		this.actors = actors;
	}

	public String getTytul() {
		return tytul;
	}

	public void setTytul(String tytul) {
		this.tytul = tytul;
	}

	public String getProducent() {
		return producent;
	}

	public void setProducent(String producent) {
		this.producent = producent;
	}

	public String getRok() {
		return rok;
	}

	public void setRok(String date) {
		this.rok = date;
	}

	public int getDlugosc() {
		return dlugosc;
	}

	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

}
