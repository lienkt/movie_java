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
import fr.epita.movies.datamodel.Contact;
import fr.epita.movies.services.data.api.IContactDAO;

@RestController
public class ContactController {
	
	private static final String BASE_PATH = "/contacts";

	@Inject
	IContactDAO dao;
	
	@GetMapping(path = BASE_PATH + "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contact> search(@PathVariable("id") String id) throws DataAccessException {
		return ResponseEntity.ok(dao.findById(Contact.class, Integer.valueOf(id)));
	}

	@PostMapping(path = BASE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contact> create(@RequestBody Contact contact) {
		try {
			System.out.println(contact);
			dao.create(contact);

		} catch (Exception e) {
			return ResponseEntity.status(500).body(contact);
		}
		return ResponseEntity.created(URI.create(BASE_PATH + "/" + contact.getId())).build();
	}

	@PutMapping(path = BASE_PATH + "/{id}") 
	Contact update(@RequestBody Contact editContact, @PathVariable String id) throws DataAccessException {
		Contact contact = dao.findById(Contact.class, Integer.valueOf(id));
		contact.setId(editContact.getId());
		contact.setBirthDate(editContact.getBirthDate());
		contact.setGender(editContact.getGender());
		contact.setAddress(editContact.getAddress());
        dao.update(contact);
		return contact;
	}
	
	@DeleteMapping(path = BASE_PATH + "/{id}")
	void delete(@PathVariable("id") String id) throws DataAccessException {
		Contact contact = dao.findById(Contact.class, Integer.valueOf(id));
		dao.delete(contact);
	}

}
