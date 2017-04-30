package movie;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieContainerImpl implements MovieContainer {

	List<Movie> movies = new ArrayList<Movie>();

	@Override
	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
