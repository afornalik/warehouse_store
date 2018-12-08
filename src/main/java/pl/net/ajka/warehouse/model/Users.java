package pl.net.ajka.warehouse.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {

	@Id
	@Column(name="id_user")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="date_of_registration")
	private Date dateOfRegistration;
	
	@OneToMany(mappedBy="whoAdd",fetch=FetchType.EAGER)
	private Set<Items> whoAddItems;
	
	@OneToMany(mappedBy="users", fetch=FetchType.EAGER)
	private Set<ItemsAmount> whoAddItemsAmount;
	
	@OneToMany(mappedBy="users", fetch=FetchType.EAGER)
	private Set<ItemsKind> whoAddItemsKind;
	
	@OneToMany(mappedBy="users" , fetch=FetchType.EAGER)
	private Set<Palette> whoAddPalette;
	
	/*Constructors*/
	
	public Users() {
		super();
	}
	
	
	public Users(String firstName, String lastName, String password, Date dateOfRegistration) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.dateOfRegistration = dateOfRegistration;
	}


	/*Setters and Getters*/
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public Set<Items> getWhoAddItems() {
		return whoAddItems;
	}

	public void setWhoAddItems(Set<Items> whoAddItems) {
		this.whoAddItems = whoAddItems;
	}

	public Set<ItemsAmount> getWhoAddItemsAmount() {
		return whoAddItemsAmount;
	}

	public void setWhoAddItemsAmount(Set<ItemsAmount> whoAddItemsAmount) {
		this.whoAddItemsAmount = whoAddItemsAmount;
	}

	public Set<ItemsKind> getWhoAddItemsKind() {
		return whoAddItemsKind;
	}

	public void setWhoAddItemsKind(Set<ItemsKind> whoAddItemsKind) {
		this.whoAddItemsKind = whoAddItemsKind;
	}

	public Set<Palette> getWhoAddPalette() {
		return whoAddPalette;
	}

	public void setWhoAddPalette(Set<Palette> whoAddPalette) {
		this.whoAddPalette = whoAddPalette;
	}

	
	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfRegistration="
				+ dateOfRegistration + "]";
	}
	
	
}
