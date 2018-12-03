package pl.net.ajka.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Override
	public String toString() {
		return "Palette [id=" + id + ", locX=" + locX + ", locY=" + locY + ", sizeX=" + sizeX + ", sizeY=" + sizeY
				+ ", place=" + place + ", users=" + users + "]";
	}

	@Column(name="place")
	private String place;
	
	@ManyToOne()
	@JoinColumn(name="who_add",foreignKey=@ForeignKey(name="paleta_ibfk_1"))
	private Users users;

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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
}
