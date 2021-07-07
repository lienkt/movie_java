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
import fr.epita.movies.datamodel.Role;
import fr.epita.movies.services.data.api.IRoleDAO;


@RestController
public class RoleController {

	private static final String BASE_PATH = "/roles";

	@Inject
	IRoleDAO dao;
	
	@GetMapping(path = BASE_PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Role> search(@PathVariable("id") String id) throws DataAccessException {
		return ResponseEntity.ok(dao.findById(Role.class, Integer.valueOf(id)));

	}

	@PostMapping(path = BASE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Role> create(@RequestBody Role role) {
		try {
			System.out.println(role);
			dao.create(role);

		} catch (Exception e) {
			return ResponseEntity.status(500).body(role);
		}
		return ResponseEntity.created(URI.create(BASE_PATH + "/" + role.getId())).build();
	}

	@PutMapping(path = BASE_PATH + "/{id}") 
	Role update(@RequestBody Role updateRole, @PathVariable String id) throws DataAccessException {
		Role role = dao.findById(Role.class, Integer.valueOf(id));
		role.setId(updateRole.getId());
		role.setName(updateRole.getName());
        dao.update(role);
		return role;
	}
	
	@DeleteMapping(path = BASE_PATH + "/{id}")
	void deleteRole(@PathVariable("id") String id) throws DataAccessException {
		Role role = dao.findById(Role.class, Integer.valueOf(id));
		dao.delete(role);
	}
}
