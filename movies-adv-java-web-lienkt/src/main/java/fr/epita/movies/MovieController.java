package fr.epita.movies;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.epita.movies.datamodel.Movie;
import fr.epita.movies.services.data.api.DataAccessException;
import fr.epita.movies.services.data.api.IMovieDAO;

@RestController
public class MovieController {
	
	private static final String BASE_PATH="/movies";
	
	@Inject
	IMovieDAO dao;
	
	@GetMapping(path=BASE_PATH +"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Movie>> find(@PathVariable("id") Integer id) throws DataAccessException {
		Movie criterion = new Movie();
		criterion.setId(id);
		List<Movie> search = dao.search(criterion);
		return ResponseEntity.ok(search);
	} 

	@PostMapping(path = BASE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> create(Movie movie) {
		try {
			dao.create(movie);
		} catch (Exception e) {
			return ResponseEntity.status(500).body(movie);
		}
		return ResponseEntity.created(URI.create(BASE_PATH + "/" + movie.getId())).build();
	}

	@PutMapping(path = BASE_PATH + "/{id}") 
	Movie updateMovie(@RequestBody Movie updateMovie, @PathVariable int id) throws DataAccessException {
		Movie movie = dao.findById(Movie.class, id);
		movie.setId(updateMovie.getId());
		movie.setTitle(updateMovie.getTitle());
		movie.setMovieDirector(updateMovie.getMovieDirector());
		movie.setCategory(updateMovie.getCategory());
		movie.setReleaseDate(updateMovie.getReleaseDate());
		movie.setThumbnail(updateMovie.getThumbnail());
		movie.setUrl(updateMovie.getUrl());
		movie.setRating(updateMovie.getRating());
        dao.update(movie);
		return movie;
  }
	@DeleteMapping(path = BASE_PATH + "/{id}")
	  void deleteMovie(@PathVariable("id") int id) throws DataAccessException {
		Movie movie = dao.findById(Movie.class, Integer.valueOf(id));
		dao.delete(movie);
	  }
}