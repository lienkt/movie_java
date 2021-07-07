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
import fr.epita.movies.datamodel.Address;
import fr.epita.movies.services.data.api.IAddressDAO;

@RestController
public class AddressController {
private static final String BASE_PATH="/address";
	
	@Inject
	IAddressDAO dao;
	
	@GetMapping(path=BASE_PATH +"/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> seacrch(@PathVariable("id") String id) throws DataAccessException {
		return ResponseEntity.ok(dao.findById(Address.class, Integer.valueOf(id)));
	} 
	
	@PostMapping(path = BASE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> create(@RequestBody Address address) {
		try {
			System.out.println(address);
			dao.create(address);		
		}
		catch(Exception e) {
			return ResponseEntity.status(500).body(address);
		}
		return ResponseEntity.created(URI.create(BASE_PATH + "/" + address.getId())).build();
	}
	
	@PutMapping(path = BASE_PATH + "/{id}") 
	Address update(@RequestBody Address updateAddress, @PathVariable String id) throws DataAccessException {
		Address address = dao.findById(Address.class, Integer.valueOf(id));
		address.setId(updateAddress.getId());
		address.setCountry(updateAddress.getCountry());
		address.setArea(updateAddress.getArea());
		address.setCity(updateAddress.getCity());
		address.setStreet(updateAddress.getStreet());
		address.setNumber(updateAddress.getNumber());
        dao.update(address);
		return address;
	}
	
	@DeleteMapping(path = BASE_PATH + "/{id}")
	  void delete(@PathVariable("id") String id) throws DataAccessException {
		Address mv = dao.findById(Address.class, Integer.valueOf(id));
		dao.delete(mv);
	  }

}
