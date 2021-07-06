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

import fr.epita.movies.datamodel.SeenMovie;

/**
 * Test seen movie
 * @author LienKT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContextJPA.xml")
public class TestSeenMovies {
	
	private static final Logger LOGGER = LogManager.getLogger(TestSeenMovies.class);

	@PersistenceContext
	EntityManager manager;

	@Inject
	DataSource ds;

	@Test
	@Transactional
	public void test() {
		SeenMovie entity = new SeenMovie();
		manager.persist(entity);
	}

	@Test
	public void testSeenMovieDisplay() throws SQLException {
		Connection connection = ds.getConnection();
		String schema = connection.getSchema();
		Assert.assertNotNull(schema);

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"SEEN_MOVIE\"");
		ResultSet results = preparedStatement.executeQuery();

		while (results.next()) {
			Integer id = results.getInt("ID");
			Date seenDate = results.getDate("SEEN_DATE");
			Integer movieId = results.getInt("MOVIE_ID");
			Integer userId = results.getInt("USER_ID");
			
			SeenMovie seen = new SeenMovie();
			seen.setId(id);
			seen.setSeenDate(seenDate);
			seen.setUser(userId);
			seen.setMovie(movieId);

			seen.toString();
			LOGGER.info("Record is printed!");

		}

	}
}
