package fr.epita.test.movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test connection
 * @author LienKT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestPGSQLConnection {
	@Inject
	DataSource ds;

	@Test
	public void testConnection() throws SQLException {
		System.out.println("lien lien lien ");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/movies", "postgres",
				"123");
		System.out.println(connection);
		String schema = connection.getSchema();
		Assert.assertNotNull(schema);
	}
}
