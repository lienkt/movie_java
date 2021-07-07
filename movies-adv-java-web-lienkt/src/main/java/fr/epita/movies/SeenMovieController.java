package fr.epita.movies;

import java.net.URI;

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

import fr.epita.movies.services.data.api.DataAccessException;
import fr.epita.movies.datamodel.SeenMovie;
import fr.epita.movies.services.data.api.ISeenMovieDAO;

@RestController
public class SeenMovieController {
	
	private static final String BASE_PATH = "/seenMovies";

	@Inject
	ISeenMovieDAO dao;
	
	@GetMapping(path = BASE_PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SeenMovie> search(@PathVariable("id") String id) throws DataAccessException {
		return ResponseEntity.ok(dao.findById(SeenMovie.class, Integer.valueOf(id)));

	}

	@PostMapping(path = BASE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SeenMovie> create(@RequestBody SeenMovie seenMovie) {
		try {
			System.out.println(seenMovie);
			dao.create(seenMovie);

		} catch (Exception e) {
			return ResponseEntity.status(500).body(seenMovie);
		}
		return ResponseEntity.created(URI.create(BASE_PATH + "/" + seenMovie.getId())).build();
	}

	@PutMapping(path = BASE_PATH + "/{id}") 
	SeenMovie update(@RequestBody SeenMovie updateSeen, @PathVariable String id) throws DataAccessException {
		SeenMovie seen = dao.findById(SeenMovie.class, Integer.valueOf(id));
		seen.setId(updateSeen.getId());
		seen.setSeenDate(updateSeen.getSeenDate());
		seen.setMovie(updateSeen.getMovie());
		seen.setUser(updateSeen.getUser());
        dao.update(seen);
		return seen;
	}
	
	@DeleteMapping(path = BASE_PATH + "/{id}")
	void delete(@PathVariable("id") String id) throws DataAccessException {
		SeenMovie seen = dao.findById(SeenMovie.class, Integer.valueOf(id));
		dao.delete(seen);
	}


}
