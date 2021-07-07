package fr.epita.test.movies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.epita.movies.datamodel.Contact;


/**
 * Test contact
 * @author LienKT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContextJPA.xml")
public class TestContact {
	
	private static final Logger LOGGER = LogManager.getLogger(TestContact.class);

	@PersistenceContext
	EntityManager manager;
	
	@Inject
	DataSource ds;
	
	@Test
	@Transactional
	public void test() {
		Contact entity = new Contact();
		manager.persist(entity);
	}
	
	@Test
	public void testPrintContact() throws SQLException {
		Connection connection = ds.getConnection();
		String schema = connection.getSchema();
		Assert.assertNotNull(schema);

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"CONTACTS\"");
		ResultSet results = preparedStatement.executeQuery();
		
		while(results.next()) {
			
			Integer id = results.getInt("ID");
			Date birthDate = results.getDate("BIRTHDATE");
			String gender = results.getString("GENDER");
			Integer addressId = results.getInt("ADDRESS_ID");
			
			Contact contact = new Contact();
			contact.setId(id);
			contact.setBirthDate(birthDate);
			contact.setGender(gender);
			contact.setAddress(addressId);
			
			contact.toString();
			LOGGER.info("Record is printed!");
			
		}
		connection.close();
			
		}

}
