package fr.epita.movies.services.data.impl.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fr.epita.movies.datamodel.User;
import fr.epita.movies.services.data.api.IUserDAO;
import fr.epita.movies.services.data.api.DataAccessException;

/**
 * Implements user services
 * @author LienKT
 */
@Transactional(value = Transactional.TxType.REQUIRED)
public class UserJPAEMDAO extends AbstractGenericDAO<User> implements IUserDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<User> search(User entity) throws DataAccessException {
		TypedQuery<User> query = em.createQuery("from USERS", User.class);
		return query.getResultList();
	}
}
