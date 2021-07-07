package fr.epita.movies.datamodel;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Movie class is used to create a movie
 * @author LienKT
 */
@Entity
@Table(name = "MOVIES")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;

	@Column(name="TITLE")
	private String title;
	
	@Column(name="MOVIE_DIRECTOR")
	private String movieDirector;
	
	@Column(name="CATEGORY")
	private String category;
	
	@Column(name="RELEASE_DATE")
	private Date releaseDate;
	
	@Column(name="THUMBNAIL")
	private String thumbnail;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="RATING")
	private double rating;
	
//	@OneToOne(mappedBy = "MOVIES")
//	private SeenMovie seen;
//	
	public Movie() {
	}

	public Movie(Integer id, String title, String movieDirector, String category, Date releaseDate, String thumbnail,
			String url, double rating) {
		this.id = id;
		this.title = title;
		this.movieDirector = movieDirector;
		this.category = category;
		this.releaseDate = releaseDate;
		this.thumbnail = thumbnail;
		this.url = url;
		this.rating = rating;
//		this.seen = seen;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", movieDirector=" + movieDirector + ", category=" + category
				+ ", releaseDate=" + releaseDate + ", thumbnail=" + thumbnail + ", url=" + url + ", rating=" + rating
				+ "]";
	}	
}

