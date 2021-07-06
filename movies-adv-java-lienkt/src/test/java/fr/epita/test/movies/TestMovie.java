package fr.epita.test.movies;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
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

import fr.epita.movies.datamodel.Movie;
import fr.epita.movies.services.data.api.DataAccessException;
import fr.epita.movies.services.data.api.MovieDAO;

/**
 * Test movie
 * @author LienKT
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContextJPA.xml")
public class TestMovie {
	
	private static final Logger LOGGER = LogManager.getLogger(TestMovie.class);
	
	@PersistenceContext
	EntityManager manager;
	
	@Inject
	DataSource ds;
	
	 @Inject
	 MovieDAO dao;
	 
	 
	@Test
	@Transactional
	public void test() {
		Movie entity = new Movie();
		manager.persist(entity);
	}
	
	@Test
	public void testSearch() throws DataAccessException {
		dao.search(new Movie());
	}

	@Test
	public void testAdd() throws DataAccessException {
		String title = "Peppa Pig";
		String movieDirector = "BCD";
		String category = "cartoons";
		Date releaseDate = java.sql.Date.valueOf("2021-07-01");
		String thumbnail = "https://i.ytimg.com/vi/7wexlVI84oM/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLARd9X5acKII-xAyrNO76h2Pc986A";
		String url = "https://www.youtube.com/watch?v=7wexlVI84oM";
		double rating = 0;

		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setMovieDirector(movieDirector);
		movie.setCategory(category);
		movie.setReleaseDate(releaseDate);
		movie.setThumbnail(thumbnail);
		movie.setUrl(url);
		movie.setRating(rating);
		
		dao.create(movie);
	}

	@Test
	public void testEdit() throws DataAccessException {
		Integer id = 2;
		String title = "Peppa Pig 2";
		String movieDirector = "BCD";
		String category = "cartoons";
		Date releaseDate = java.sql.Date.valueOf("2021-07-01");
		String thumbnail = "https://i.ytimg.com/vi/7wexlVI84oM/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLARd9X5acKII-xAyrNO76h2Pc986A";
		String url = "https://www.youtube.com/watch?v=7wexlVI84oM";
		double rating = 0;

		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setMovieDirector(movieDirector);
		movie.setCategory(category);
		movie.setReleaseDate(releaseDate);
		movie.setThumbnail(thumbnail);
		movie.setUrl(url);
		movie.setRating(rating);
		
		dao.update(movie);
	}

	@Test
	public void testDelete() throws DataAccessException {
		Integer id = 2;
		Movie movie = new Movie();
		movie.setId(id);
		
		dao.delete(movie);
	}
	
	@Test
	public void testPrintMovie() throws SQLException {
		Connection connection = ds.getConnection();
		String schema = connection.getSchema();
		Assert.assertNotNull(schema);

		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM \"MOVIES\"");
		ResultSet results = preparedStatement.executeQuery();

		while (results.next()) {
			Integer id = results.getInt("ID");
			String title = results.getString("TITLE");
			String movieDirector = results.getString("MOVIE_DIRECTOR");
			String category = results.getString("CATEGORY");
			Date releaseDate = results.getDate("RELEASE_DATE");
			String thumbnail = results.getString("THUMBNAIL");
			String url = results.getString("URL");
			double rating = results.getDouble("RATING");
			
			Movie movie = new Movie();
			movie.setId(id);
			movie.setTitle(title);
			movie.setMovieDirector(movieDirector);
			movie.setCategory(category);
			movie.setReleaseDate(releaseDate);
			movie.setThumbnail(thumbnail);
			movie.setUrl(url);
			movie.setRating(rating);
			
			movie.toString();
			LOGGER.info("Record is printed!");
		}
		connection.close();
	}

	@Test
	public void testAddMovie() throws SQLException, ParseException {
		Connection connection = ds.getConnection();
		String schema = connection.getSchema();
		Assert.assertNotNull(schema);
		
		String title = "Peppa Pig";
		String movieDirector = "BCD";
		String category = "cartoons";
		Date releaseDate = java.sql.Date.valueOf("2021-07-01");
		String thumbnail = "https://i.ytimg.com/vi/7wexlVI84oM/hq720.jpg?sqp=-oaymwEcCNAFEJQDSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLARd9X5acKII-xAyrNO76h2Pc986A";
		String url = "https://www.youtube.com/watch?v=7wexlVI84oM";
		double rating = 0;

		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setMovieDirector(movieDirector);
		movie.setCategory(category);
		movie.setReleaseDate(releaseDate);
		movie.setThumbnail(thumbnail);
		movie.setUrl(url);
		movie.setRating(rating);

		String sqlQuery = "INSERT INTO \"MOVIES\"(\"TITLE\", \"MOVIE_DIRECTOR\", \"CATEGORY\", \"RELEASE_DATE\", \"THUMBNAIL\", \"URL\", \"RATING\") VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement preps = connection.prepareStatement(sqlQuery);
		preps.setString(1, title);
		preps.setString(2, movieDirector);
		preps.setString(3, category);
		preps.setDate(4, (java.sql.Date) releaseDate);
		preps.setString(5, thumbnail);
		preps.setString(6, url);
		preps.setDouble(7, rating);
		
		preps.executeUpdate();
		LOGGER.info("Added Record!!");
		connection.close();
	}
	
	@Test
	public void testEditMovie() throws SQLException, ParseException {
		Connection connection = ds.getConnection();
		String schema = connection.getSchema();
		Assert.assertNotNull(schema);
		
		Integer id = 1;
		String title = "Peppa Pig 2";
		String sqlQuery = "UPDATE \"MOVIES\" SET \"TITLE\"=? WHERE \"ID\" = ? ";
		PreparedStatement preps = connection.prepareStatement(sqlQuery);
		preps.setString(1, title);
		preps.setInt(2, id);
		
		preps.executeUpdate();
		LOGGER.info("Edited Record!!");
		connection.close();
	}
	
	@Test
	public void testDeleteMovie() throws SQLException, ParseException {
		Connection connection = ds.getConnection();
		String schema = connection.getSchema();
		Assert.assertNotNull(schema);
		
		int id = 1;
		String sqlQuery = "DELETE FROM \"MOVIES\" WHERE \"ID\" = ?";
		PreparedStatement preps = connection.prepareStatement(sqlQuery);
		preps.setInt(1, id);
		
		preps.executeUpdate();
		LOGGER.info("Deleted Record!!");
		connection.close();
	}
}
