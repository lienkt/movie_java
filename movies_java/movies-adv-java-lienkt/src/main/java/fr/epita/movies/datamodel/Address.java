
package fr.epita.movies.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Address class is used to create address of user
 * @author LienKT
 */
@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;

	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="AREA")
	private String area;

	@Column(name="CITY")
	private String city;

	@Column(name="STREET")
	private String street;

	@Column(name="NUMBER")
	private Integer number;
	
//	@OneToOne(mappedBy = "ADDRESS")
//	private Contact contact;

	public Address() {
	}

	public Address(Integer id, String country, String area, String city, String street, Integer number) {
		this.id = id;
		this.country = country;
		this.area = area;
		this.city = city;
		this.street = street;
		this.number = number;
//		this.contact = contact;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

//	public Contact getContact() {
//		return contact;
//	}
//
//	public void setContact(Contact contact) {
//		this.contact = contact;
//	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", country=" + country + ", area=" + area + ", city=" + city + ", street=" + street
				+ ", number=" + number + "]";
	}
}
