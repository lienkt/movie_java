package fr.epita.movies.datamodel;

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
@Table(name = "USERS")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="EMAIL")
	private String email;

	@Column(name="PASSWORD")
	private String password;

//	@OneToOne(mappedBy = "USERS")
//	private SeenMovie seen;

	@Column(name="ROLE_ID")
	private Integer roleId;
	
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")
//	private Role role;

	@Column(name="CONTACT_ID")
	private Integer contactId;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID")
//    private Contact contact;

    
	public User() {
	}

	public User(Integer id, String email, String password, Integer roleId, Integer contactId) {
		this.id = id;
		this.email = email;
		this.password = password;
//		this.seen = seen;
		this.roleId = roleId;
		this.contactId = contactId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public SeenMovie getSeen() {
//		return seen;
//	}
//
//	public void setSeen(SeenMovie seen) {
//		this.seen = seen;
//	}

	public Integer getRole() {
		return roleId;
	}

	public void setRole(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getContact() {
		return contactId;
	}

	public void setContact(Integer contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", roleId=" + roleId
				+ ", contactId=" + contactId + "]";
	}
}
