package fr.epita.movies.datamodel;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Contact class is used to create Contact of user
 * @author LienKT
 */
@Entity
@Table(name = "CONTACTS")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="BIRTHDATE")
	private Date birthDate;

	@Column(name="GENDER")
	private String gender;


	@Column(name="ADDRESS_ID")
	private Integer addressId;

//	@OneToOne(mappedBy = "CONTACTS")
//    private User User;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
//	private Address address;

	public Contact() {
	}

	public Contact(Integer id, Date birthDate, String gender, Integer addressId) {
		this.id = id;
		this.birthDate = birthDate;
		this.gender = gender;
		this.addressId = addressId;
//		User = user;
//		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

//	public User getUser() {
//		return User;
//	}
//
//	public void setUser(User user) {
//		User = user;
//	}

	public Integer getAddress() {
		return addressId;
	}

	public void setAddress(Integer addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", birthDate=" + birthDate + ", gender=" + gender + ", addressId=" + addressId
				+ "]";
	}
}
