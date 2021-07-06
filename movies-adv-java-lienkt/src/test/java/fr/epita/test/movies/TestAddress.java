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

import fr.epita.movies.datamodel.Address;

/**
 * Test address
 * @author LienKT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContextJPA.xml")
public class TestAddress {

	private static final Logger LOGGER = LogManager.getLogger(TestAddress.class);
	
	@PersistenceContext
	EntityManager manager;

	@Inject
	DataSource ds;

	@Test
	@Transactional
	public void test() {
		Address entity = new Address();
		manager.persist(entity);
	}

	@Test
	public void testPrintAddress() throws SQLException {
		Connection connection = ds.getConnection();
		String schema = connection.getSchema();
		Assert.assertNotNull(schema);

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"ADDRESS\"");
		ResultSet results = preparedStatement.executeQuery();

		while (results.next()) {
			Integer id = results.getInt("ID");
			String country = results.getString("COUNTRY");
			String area = results.getString("AREA");
			String city = results.getString("CITY");
			String street = results.getString("STREET");
			Integer number = results.getInt("NUMBER");
			
			Address address = new Address();
			address.setId(id);
			address.setCountry(country);
			address.setArea(area);
			address.setCity(city);
			address.setStreet(street);
			address.setNumber(number);
			
			address.toString();
			LOGGER.info("Record is printed!");
		}
		connection.close();

	}

}
