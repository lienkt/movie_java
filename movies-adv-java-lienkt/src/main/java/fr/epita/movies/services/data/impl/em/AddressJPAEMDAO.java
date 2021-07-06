package fr.epita.movies.services.data.impl.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fr.epita.movies.datamodel.Address;
import fr.epita.movies.services.data.api.IAddressDAO;
import fr.epita.movies.services.data.api.DataAccessException;
/**
 * Implements address services
 * @author LienKT
 */
@Transactional(value = Transactional.TxType.REQUIRED)
public class AddressJPAEMDAO extends AbstractGenericDAO<Address> implements IAddressDAO{
	
	@PersistenceContext
	EntityManager em;

	@Override
	public List<Address> search(Address entity) throws DataAccessException {
		TypedQuery<Address> query = em.createQuery("from ADDRESS", Address.class);
		return query.getResultList();
	}
}
