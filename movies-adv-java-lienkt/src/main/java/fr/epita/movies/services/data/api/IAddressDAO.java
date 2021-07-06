package fr.epita.movies.services.data.api;

import java.util.List;

import fr.epita.movies.datamodel.Address;

/**
 * Interface of Address DAO
 * @author LienKT
 */
public interface IAddressDAO extends IDAO<Address>{
	
	public List<Address> search(Address address) throws DataAccessException;

	public void update(Address address) throws DataAccessException;

	public void delete(Address address) throws DataAccessException;

	public void create(Address address) throws DataAccessException;
	
	public Address findById(Class<Address> objectClass, Integer id);

}
