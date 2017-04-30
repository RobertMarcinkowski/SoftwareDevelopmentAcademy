package movie;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class MovieContainerImpl implements MovieContainer{

	List<Movie> movies = new ArrayList<>();

	@Override
	public List<Movie> getMovies() {
		return movies;
	}

}
