package movie;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Movie {
	
	private String tytul;
	private String producent;
	private String rok;
	private int dlugosc;
	private List<Actor> acotrs = new ArrayList<>();
	
	public Movie(){}
	
	public Movie(String tytul, String producent, String rok, int dlugosc, List<Actor> acotrs) {
		super();
		this.tytul = tytul;
		this.producent = producent;
		this.rok = rok;
		this.dlugosc = dlugosc;
		this.acotrs = acotrs;
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
	public void setRok(String rok) {
		this.rok = rok;
	}
	public int getDlugosc() {
		return dlugosc;
	}
	public void setDlugosc(int dlugosc) {
		this.dlugosc = dlugosc;
	}
	public List<Actor> getAcotrs() {
		return acotrs;
	}
	public void setAcotrs(List<Actor> acotrs) {
		this.acotrs = acotrs;
	}

	@Override
	public String toString() {
		return "Movie [tytul=" + tytul + ", producent=" + producent + ", rok=" + rok + ", dlugosc=" + dlugosc
				+ ", acotrs=" + acotrs + "]";
	}

	
	
	
}
