package fr.epita.movies.services.data.impl.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fr.epita.movies.datamodel.SeenMovie;
import fr.epita.movies.services.data.api.ISeenMovieDAO;
import fr.epita.movies.services.data.api.DataAccessException;

/**
 * Implements seen movie services
 * @author LienKT
 */
@Transactional(value = Transactional.TxType.REQUIRED)
public class SeenMoviesJPAEMDAO extends AbstractGenericDAO<SeenMovie> implements ISeenMovieDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<SeenMovie> search(SeenMovie entity) throws DataAccessException {
		TypedQuery<SeenMovie> query = em.createQuery("from SEEN_MOVIE", SeenMovie.class);
		return query.getResultList();
	}
}
