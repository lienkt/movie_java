package fr.epita.movies.services.data.impl.em;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import fr.epita.movies.datamodel.Contact;
import fr.epita.movies.services.data.api.IContactDAO;
import fr.epita.movies.services.data.api.DataAccessException;

/**
 * Implements contact services
 * @author LienKT
 */
@Transactional(value = Transactional.TxType.REQUIRED)
public class ContactJPAEMDAO extends AbstractGenericDAO<Contact> implements IContactDAO {

	@PersistenceContext
	EntityManager em;

	@Override
	public List<Contact> search(Contact entity) throws DataAccessException {
		TypedQuery<Contact> query = em.createQuery("from CONTACTS", Contact.class);
		return query.getResultList();
	}

}
