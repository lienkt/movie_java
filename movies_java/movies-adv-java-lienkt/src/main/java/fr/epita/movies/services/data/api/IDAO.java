package fr.epita.movies.services.data.api;

import java.util.List;

/**
 * Interface of generic DAO
 * @author LienKT
 */
public interface IDAO<T> {
	public List<T> search(T entity) throws DataAccessException;

	public void update(T entity) throws DataAccessException;

	public void delete(T entity) throws DataAccessException;

	public void create(T entity) throws DataAccessException;
	
	public T findById(Class<T> objectClass, Integer id);

}
