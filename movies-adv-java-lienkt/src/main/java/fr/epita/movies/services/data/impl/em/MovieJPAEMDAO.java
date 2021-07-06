package fr.epita.movies.services.data.impl.em;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fr.epita.movies.datamodel.Movie;
import fr.epita.movies.services.data.api.IMovieDAO;
import fr.epita.movies.services.data.api.DataAccessException;

/**
 * Implements movie services
 * @author LienKT
 */
@Transactional(value = Transactional.TxType.REQUIRED)
public class MovieJPAEMDAO extends AbstractGenericDAO<Movie> implements IMovieDAO {
	
	@Inject
	IMovieDAO dao;
	
	@Override
	public List<Movie> search(Movie movie) throws DataAccessException {
		TypedQuery<Movie> query = em.createQuery("from MOVIES", Movie.class);
		return query.getResultList();
	}

	@Override
	public Optional<List<Movie>> findById(Integer id) {
		return dao.findById(id);
	}
}
