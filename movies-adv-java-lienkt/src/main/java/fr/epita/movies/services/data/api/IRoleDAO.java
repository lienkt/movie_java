package fr.epita.movies.services.data.api;

import java.util.List;

import fr.epita.movies.datamodel.Role;

/**
 * Interface of Role DAO
 * @author LienKT
 */
public interface IRoleDAO extends IDAO<Role>{
	
	public List<Role> search(Role role) throws DataAccessException;

	public void update(Role role) throws DataAccessException;

	public void delete(Role role) throws DataAccessException;

	public void create(Role role) throws DataAccessException;
	
	public Role findById(Class<Role> objectClass, Integer id);

}
