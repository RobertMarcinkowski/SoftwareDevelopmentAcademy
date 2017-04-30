package com.example;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.ImieINazwisko;
import com.domain.Movie;
import com.domain.MovieComment;
import com.domain.MovieDescription;
import com.domain.MovieRating;
import com.domain.Producer;
import com.repository.MovieCommentRepository;
import com.repository.MovieRatingRepository;
import com.repository.MovieRepository;
import com.repository.ProducerRepository;

@RestController
@Transactional
public class MovieController {

	@Autowired
	MovieRepository movieRepo;
	
	@Autowired
	ProducerRepository producerRepository;
	
	@Autowired
	MovieRatingRepository movieRatingRepository;
	
	@Autowired
	MovieCommentRepository movieCommentRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@GetMapping(path="/getMovie")
	public List<String> getMovie(){
		
		//Tworzenie obiektu ImieINazwisko
		ImieINazwisko imieINazwisko = new ImieINazwisko();
		imieINazwisko.setImie("Jakub");
		imieINazwisko.setNazwisko("Nowak");
		//Tworzenie obiektu Producer
		Producer producer = new Producer();
		producer.setNazwaStudia("Super studio");
		producer.setImieINazwisko(imieINazwisko);
		//Tworzenie obiektu Movie
		Movie movie = new Movie();
		movie.setLength(120);
		movie.setTitle("Dobry film");
		movie.setYear("2012");
		movie.setProducer(producer);
		//zapisanie obiektu movie, ktory ma relacjedo producer
		movieRepo.add(movie);
		
		//pobraie wszystkich producentow po nazwe studioa
		List<Producer> list = producerRepository.findAllByNazwaStudia("nowe studio");
		for(Producer p :list){
			for(Movie m :p.getMovies()){
				System.out.println(m.getTitle());
			}
		}
		
		Optional<Producer> p =producerRepository.findProducer(new Long(4));

		p.ifPresent(x -> System.out.println("nasze studio: "+x.getNazwaStudia()));
		
		if(p.isPresent()){
			Producer pZbazy = p.get();
			pZbazy.setNazwaStudia("ekstra nowe studio555!");
			
			producerRepository.merge(pZbazy);
		}
				
		
		//Wyszukiwanie filmow z czasem mniejszym niz 100
		List<Movie> shortMovie = movieRepo.findShortMovies(100);		
		shortMovie.stream().forEach(
				x -> System.out.println("short movie: "+x.getTitle()));
		
		
		
		
		// Optional wykorzystanie
		String title = Optional.ofNullable(movie.getTitle().toUpperCase())
				.orElse("");
		Optional<Producer> producerNowy = producerRepository.findByFirstNameAndLastName("Jan", "kowalski");
		producerNowy.ifPresent(x -> System.out.println(x.getImieINazwisko().getImie()));
		String imie =producerNowy.map(x -> x.getImieINazwisko().getImie()).orElse("Brak");
		Producer producerFromOptional = producerNowy.orElse(new Producer());
		String noweImie = "";
		if(producerNowy.isPresent()){
			 noweImie =producerNowy.get().getImieINazwisko().getImie();
		}
		
		//Wyszukiwanie filmow za pomoca criteria
		List<Movie> movieList =movieRepo.findAllWithCriteria("Dobry film", 2012, 80);
		movieList.stream().forEach(x -> System.out.println("criteria: "+ x.getTitle()));
		
		
		/// dodawanie losowych ocen do filmow
		List<Movie> movieListToRating = movieRepo.findAll();
		movieListToRating.stream().forEach(x -> addRating(x));
		
		
		
		//Wyswietlanie filmow z średnia ocen
		List<String> movieWithAvg = movieRepo.findAllTitleAndAvg().stream().map(x-> x.getTitle()+" "+x.getAvg())
				.collect(Collectors.toList());
	
		//Dodawanie komentarza do losowego filmu
		Optional<Movie> filmDoKomentarz = movieRepo.findAll().stream().findAny();
		filmDoKomentarz.ifPresent(x -> addComment(x));
		
		return movieWithAvg;
	}

	private void addComment(Movie m) {
		MovieComment mc = new MovieComment();
		mc.setComment("Super film, polecam !");
		mc.setMovie(m);
		movieCommentRepository.persist(mc);
		
	}

	private void addRating(Movie m) {
		Random r = new Random();
		
		MovieRating mr = new MovieRating();
		mr.setMovie(m);
		mr.setEmail("test@sdacademy.pl");
		mr.setRate(r.nextInt(10));
		movieRatingRepository.persist(mr);
		
	}
}
