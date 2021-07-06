package fr.epita.movies.services.data.impl.em;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import fr.epita.movies.datamodel.Movie;
import fr.epita.movies.services.data.api.DataAccessException;
import fr.epita.movies.services.data.api.IDAO;
/**
 * Implements services
 * @author LienKT
 */
abstract class AbstractGenericDAO<T> implements IDAO<T> {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void create(T entity) throws DataAccessException {
		em.persist(entity);
	}
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void update(T entity) throws DataAccessException {
		em.merge(entity);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void delete(T entity) throws DataAccessException {
		em.remove(entity);
	}

	public T findById(Class<T> objectClass, Integer id) {
		return em.find(objectClass, id);
	}


}