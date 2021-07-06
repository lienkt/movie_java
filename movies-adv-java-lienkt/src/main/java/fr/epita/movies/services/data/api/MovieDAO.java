package fr.epita.movies.services.data.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import fr.epita.movies.datamodel.Movie;

public class MovieDAO implements IMovieDAO {

	@Inject
	DataSource datasource;

	public List<Movie> search(Movie movieQBE) throws DataAccessException {
		List<Movie> list = new ArrayList<Movie>();
		try {
			Connection connection = this.datasource.getConnection();
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
				
				list.add(movie);
			}
		} catch (SQLException e) {
			throw DataAccessException.init(e);
		}
		return list;

	}

	public void create(Movie movie) throws DataAccessException {
		try {
			Connection connection = this.datasource.getConnection();
			String sqlQuery = "INSERT INTO \"MOVIES\"(\"TITLE\", \"MOVIE_DIRECTOR\", \"CATEGORY\", \"RELEASE_DATE\", \"THUMBNAIL\", \"URL\", \"RATING\") VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preps = connection.prepareStatement(sqlQuery);
			
			preps.setString(1, movie.getTitle());
			preps.setString(2, movie.getMovieDirector());
			preps.setString(3, movie.getCategory());
			preps.setDate(4, (java.sql.Date) movie.getReleaseDate());
			preps.setString(5, movie.getThumbnail());
			preps.setString(6, movie.getUrl());
			preps.setDouble(7, movie.getRating());
			
			preps.executeUpdate();
		} catch (SQLException e) {
			throw DataAccessException.init(e);
		}

	}

	public void update(Movie movie) throws DataAccessException {

		try {
			Connection connection = this.datasource.getConnection();
			String sqlQuery = "UPDATE \"MOVIES\" SET \"TITLE\"=?, "
			+ "\"MOVIE_DIRECTOR\"=?, \"CATEGORY\"=?, \"RELEASE_DATE\"=?, "
			+ "\"THUMBNAIL\"=?, \"URL\"=?, \"RATING\"=? "
			+ "	WHERE \"ID\" = ?";
			PreparedStatement preps = connection.prepareStatement(sqlQuery);
			
			preps.setString(1, movie.getTitle());
			preps.setString(2, movie.getMovieDirector());
			preps.setString(3, movie.getCategory());
			preps.setDate(4, (java.sql.Date) movie.getReleaseDate());
			preps.setString(5, movie.getThumbnail());
			preps.setString(6, movie.getUrl());
			preps.setDouble(7, movie.getRating());
			preps.setInt(8, movie.getId());
			
			preps.executeUpdate();
		} catch (SQLException e) {
			throw DataAccessException.init(e);
		}

	}

	public void delete(Movie movie) throws DataAccessException {
		try {
			Connection connection = this.datasource.getConnection();
			String sqlQuery = "DELETE FROM public.\"MOVIES\" WHERE \"ID\" = ?";
			PreparedStatement preps = connection.prepareStatement(sqlQuery);
			preps.setInt(1, movie.getId());
		} catch (SQLException e) {
			throw DataAccessException.init(e);
		}

	}

	public Movie findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Movie findById(Class<Movie> objectClass, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
