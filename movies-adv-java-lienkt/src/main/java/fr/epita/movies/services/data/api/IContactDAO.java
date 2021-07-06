package fr.epita.movies.services.data.api;

import java.util.List;

import fr.epita.movies.datamodel.Contact;

/**
 * Interface of Contact DAO
 * @author LienKT
 */
public interface IContactDAO extends IDAO<Contact>{
	
	public List<Contact> search(Contact contact) throws DataAccessException;

	public void update(Contact contact) throws DataAccessException;

	public void delete(Contact contact) throws DataAccessException;

	public void create(Contact contact) throws DataAccessException;
	
	public Contact findById(Class<Contact> objectClass, Integer id);

}
