package fr.epita.movies.services.data.api;

import java.util.List;

import fr.epita.movies.datamodel.User;

/**
 * Interface of User DAO
 * @author LienKT
 */
public interface IUserDAO extends IDAO<User>{
	
	public List<User> search(User user) throws DataAccessException;

	public void update(User user) throws DataAccessException;

	public void delete(User user) throws DataAccessException;

	public void create(User user) throws DataAccessException;
	
	public User findById(Class<User> objectClass, Integer id);

}
