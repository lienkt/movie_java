package fr.epita.movies.services.data.api;

import java.util.List;

import fr.epita.movies.datamodel.SeenMovie;

/**
 * Interface of SeenMovie DAO
 * @author LienKT
 */
public interface ISeenMovieDAO extends IDAO<SeenMovie> {
	
	public List<SeenMovie> search(SeenMovie role) throws DataAccessException;

	public void update(SeenMovie seen) throws DataAccessException;

	public void delete(SeenMovie seen) throws DataAccessException;

	public void create(SeenMovie seen) throws DataAccessException;
	
	public SeenMovie findById(Class<SeenMovie> objectClass, Integer id);


}
