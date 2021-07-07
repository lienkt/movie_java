package fr.epita.test.movies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import fr.epita.movies.datamodel.User;

/**
 * Test User
 * @author LienKT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContextJPA.xml")
public class TestUser {
	
	private static final Logger LOGGER = LogManager.getLogger(TestUser.class);

	@PersistenceContext
	EntityManager manager;

	@Inject
	DataSource ds;

	@Test
	@Transactional
	public void test() {
		User entity = new User();
		manager.persist(entity);
	}

	@Test
	public void testPrintUser() throws SQLException {
		Connection connection = ds.getConnection();
		String schema = connection.getSchema();
		Assert.assertNotNull(schema);

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"USERS\"");
		ResultSet results = preparedStatement.executeQuery();

		while (results.next()) {
			Integer id = results.getInt("ID");
			String email = results.getString("EMAIL");
			Integer roleId = results.getInt("ROLE_ID");
			Integer contactId = results.getInt("CONTACT_ID");

			User user = new User();
			user.setId(id);
			user.setEmail(email);
			user.setRole(roleId);
			user.setContact(contactId);
			
			user.toString();
			LOGGER.info("Record is printed!");
		}
	}
}