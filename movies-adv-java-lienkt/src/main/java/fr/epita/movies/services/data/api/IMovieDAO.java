package fr.epita.movies.services.data.api;
import java.util.List;

import fr.epita.movies.datamodel.Movie;

/**
 * Interface of Movie DAO
 * @author LienKT
 */
public interface IMovieDAO extends IDAO<Movie>{

	public List<Movie> search(Movie movie) throws DataAccessException;

	public void update(Movie movie) throws DataAccessException;

	public void delete(Movie movie) throws DataAccessException;

	public void create(Movie movie) throws DataAccessException;
	
	public Movie findById(Class<Movie> objectClass, Integer id);

}
