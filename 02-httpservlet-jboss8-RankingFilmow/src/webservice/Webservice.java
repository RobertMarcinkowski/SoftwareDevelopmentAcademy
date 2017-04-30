package webservice;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import movie.Actor;
import movie.ActorContainer;
import movie.Movie;
import movie.MovieContainer;

@WebService
public class Webservice {

	@Inject
	MovieContainer movieContainer;
	@Inject
	ActorContainer actorContainer;

	private String message = new String("Hello, ");

	public void Hello() {

	}

	@WebMethod
	public String sayHello(String name) {
		return message + name + ".";
	}

	@WebMethod
	public String addMovie(Movie movie) {
		movieContainer.getMovies().add(movie);
		return "Otrzymałem: " + movie.getTytul() + ".";
	}

	@WebMethod
	public List<Movie> getMovies() {
		return movieContainer.getMovies();
	}

	@WebMethod
	public String addActor(Actor actor) {
		actorContainer.getActors().add(actor);
		return "Otrzymałem aktora: " + actor.getImie() + " " + actor.getNazwisko() + ".";
	}

	@WebMethod
	public List<Actor> getActors() {
		return actorContainer.getActors();
	}

	@WebMethod
	public String editActor(Actor actor) {
		Optional<Actor> actorToEdit;
		actorToEdit = actorContainer.getActors().stream().filter(x -> x.getId().equals(actor.getId())).findAny();

		if (actorToEdit.isPresent()) {
			Actor a = actorToEdit.get();
			a.setImie(actor.getImie());
			a.setNazwisko(actor.getNazwisko());
			a.setWiek(actor.getWiek());

			actorContainer.getActors().remove(actorToEdit.get());
			actorContainer.getActors().add(a);
			return "Udało się";
		} else {
			return "brak aktora";
		}

	}

}