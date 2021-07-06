package fr.epita.movies.services.data.impl.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fr.epita.movies.datamodel.Role;
import fr.epita.movies.services.data.api.IRoleDAO;
import fr.epita.movies.services.data.api.DataAccessException;

/**
 * Implements role services
 * @author LienKT
 */
@Transactional(value = Transactional.TxType.REQUIRED)
public class RoleJPAEMDAO extends AbstractGenericDAO<Role> implements IRoleDAO{

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Role> search(Role entity) throws DataAccessException {
		TypedQuery<Role> query = em.createQuery("from ROLES", Role.class);
		return query.getResultList();
	} 
	
	

}
