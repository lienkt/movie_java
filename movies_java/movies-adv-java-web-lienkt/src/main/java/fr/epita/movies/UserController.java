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
import fr.epita.movies.datamodel.User;
import fr.epita.movies.services.data.api.IUserDAO;

@RestController
public class UserController {

	private static final String BASE_PATH = "/users";

	@Inject
	IUserDAO dao;

	@GetMapping(path = BASE_PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> search(@PathVariable("id") String id) throws DataAccessException {
		return ResponseEntity.ok(dao.findById(User.class, Integer.valueOf(id)));

	}

	@PostMapping(path = BASE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> create(@RequestBody User user) {
		try {
			System.out.println(user);
			dao.create(user);

		} catch (Exception e) {
			return ResponseEntity.status(500).body(user);
		}
		return ResponseEntity.created(URI.create(BASE_PATH + "/" + user.getId())).build();
	}

	@PutMapping(path = BASE_PATH + "/{id}") 
	User update(@RequestBody User updateUser, @PathVariable String id) throws DataAccessException {
		User user = dao.findById(User.class, Integer.valueOf(id));
		user.setId(updateUser.getId());
		user.setEmail(updateUser.getEmail());
		user.setPassword(updateUser.getPassword());
		user.setRole(updateUser.getRole());
		user.setContact(updateUser.getContact());
        dao.update(user);
		return user;
  }
	
	@DeleteMapping(path = BASE_PATH + "/{id}")
	void delete(@PathVariable("id") String id) throws DataAccessException {
		User cust = dao.findById(User.class, Integer.valueOf(id));
		dao.delete(cust);
	}
}
