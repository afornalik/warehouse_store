package pl.net.ajka.warehouse.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="paleta")
public class Palette {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_paleta")
	private int id;
	
	@Column(name="location_x")
	private int locX;
	
	@Column(name="location_y")
	private int locY;
	
	@Column(name="size_x")
	private int sizeX;
	
	@Column(name="size_y")
	private int sizeY;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="place",foreignKey=@ForeignKey(name="paleta_ibfk_2"))
	private PaletteLocalization place;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="who_add",foreignKey=@ForeignKey(name="paleta_ibfk_1"))
	private Users users;

	@OneToMany(mappedBy="idPaleta", fetch=FetchType.LAZY)
	private Set<Items> items;
	
	@ManyToMany(mappedBy="palette", fetch=FetchType.LAZY)
	private Set<ItemsKind> itemsKind;
	
	/*Constructors*/
	

	public Palette() {
		super();
	}
	
	
	public Palette(int locX, int locY, int sizeX, int sizeY, PaletteLocalization place, Users users) {
		super();
		this.locX = locX;
		this.locY = locY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.place = place;
		this.users = users;
	}




	/*Setters and Getters*/
	
	public int getId() {
		return id;
	}

	

	public void setId(int id) {
		this.id = id;
	}

	public int getLocX() {
		return locX;
	}

	public void setLocX(int locX) {
		this.locX = locX;
	}

	public int getLocY() {
		return locY;
	}

	public void setLocY(int locY) {
		this.locY = locY;
	}

	public int getSizeX() {
		return sizeX;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public PaletteLocalization getPlace() {
		return place;
	}

	public void setPlace( PaletteLocalization place) {
		this.place = place;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	
	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}
	
	public Set<ItemsKind> getItemsKind() {
		return itemsKind;
	}


	public void setItemsKind(Set<ItemsKind> itemsKind) {
		this.itemsKind = itemsKind;
	}


	
	
	@Override
	public String toString() {
		return "Palette [id=" + id + ", locX=" + locX + ", locY=" + locY + ", sizeX=" + sizeX + ", sizeY=" + sizeY
				+ ", place=" + place + ", users=" + users + "]";
	}
}
