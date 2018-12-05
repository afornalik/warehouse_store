package pl.net.ajka.warehouse.model;

import java.util.Date;

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
@Table(name="items")
public class Items {

	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	@Column(name="id_item")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="id_item_kind",foreignKey=@ForeignKey(name="items_ibfk_2"))
	private ItemsKind idItemsKind;
	
	@ManyToOne
	@JoinColumn(name="id_paleta",foreignKey=@ForeignKey(name="items_ibfk_3"))
	private Palette idPaleta;
	
	@Column(name="add_date" )
	private Date add_date;
	
	@ManyToOne()
	@JoinColumn(name="who_add",foreignKey=@ForeignKey(name="items_ibfk_1"))
	private Users who_add;


	/*Constructors*/
	
	public Items() {
		
	}
		
	public Items(ItemsKind idItemsKind, Palette idPaleta, Date add_date, Users who_add) {
		
		this.idItemsKind = idItemsKind;
		this.idPaleta = idPaleta;
		this.add_date = add_date;
		this.who_add = who_add;
	}


	
	/*Setters and Getters*/
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ItemsKind getIdItemKind() {
		return idItemsKind;
	}

	public void setIdItemKind(ItemsKind idItemKind) {
		this.idItemsKind = idItemKind;
	}

	public Palette getIdPaleta() {
		return idPaleta;
	}

	public void setIdPaleta(Palette idPaleta) {
		this.idPaleta = idPaleta;
	}

	public Date getAdd_date() {
		return add_date;
	}

	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}

	public Users getWhoAdd() {
		return who_add;
	}

	public void setWhoAdd(Users who_add) {
		this.who_add = who_add;
	}
	
	
	
	@Override
	public String toString() {
		return "Items [id=" + id + ", idItemKind=" + idItemsKind + ", idPaleta=" + idPaleta + ", add_date=" + add_date
				+ ", who_add=" + who_add + "]";
	}
}
