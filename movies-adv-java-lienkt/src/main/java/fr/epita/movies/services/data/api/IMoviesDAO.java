package fr.epita.movies.services.data.api;
import java.util.List;
import java.util.Optional;

import fr.epita.movies.datamodel.Movie;

/**
 * Interface of Movie DAO
 * @author LienKT
 */
public interface IMoviesDAO extends IDAO<Movie>{

	Optional<List<Movie>> findById(Integer id);

}
