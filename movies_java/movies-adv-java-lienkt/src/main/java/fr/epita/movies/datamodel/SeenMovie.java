package fr.epita.movies.datamodel;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The User class is used to create a User
 * @author LienKT
 */
@Entity
@Table(name = "SEEN_MOVIE")
public class SeenMovie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;

	@Column(name="SEEN_DATE")
	private Date seenDate;
	
	@Column(name="MOVIE_ID")
	private Integer movieId;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "MOVIE_ID", referencedColumnName = "ID")
//	private Movie movie;

	@Column(name="USER_ID")
	private Integer userId;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
//	private User user;

	public SeenMovie() {
	}

	public SeenMovie(Integer id, Date seenDate, Integer movieId, Integer userId) {
		this.id = id;
		this.seenDate = seenDate;
		this.movieId = movieId;
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getSeenDate() {
		return seenDate;
	}

	public void setSeenDate(Date seenDate) {
		this.seenDate = seenDate;
	}

	public Integer getMovie() {
		return movieId;
	}

	public void setMovie(Integer movieId) {
		this.movieId = movieId;
	}

	public Integer getUser() {
		return userId;
	}

	public void setUser(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SeenMovie [id=" + id + ", seenDate=" + seenDate + ", movieId=" + movieId + ", userId=" + userId + "]";
	}
}
