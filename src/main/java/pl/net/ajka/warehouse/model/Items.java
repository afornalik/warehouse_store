package pl.net.ajka.warehouse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Items {

	
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="id_item")
	private int id;
	
	@Column(name="id_item_kind")
	private int idItemKind;
	
	@Column(name="id_paleta")
	private int idPaleta;
	
	@Column(name="add_date")
	private Date add_date;
	
	@Column(name="who_add")
	private int idUsers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdItemKind() {
		return idItemKind;
	}

	public void setIdItemKind(int idItemKind) {
		this.idItemKind = idItemKind;
	}

	public int getIdPaleta() {
		return idPaleta;
	}

	public void setIdPaleta(int idPaleta) {
		this.idPaleta = idPaleta;
	}

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	public int getIdUsers() {
		return idUsers;
	}

	public void setIdUsers(int idUsers) {
		this.idUsers = idUsers;
	}
	
	
}
