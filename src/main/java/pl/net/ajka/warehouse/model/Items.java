package pl.net.ajka.warehouse.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Date addDate;
	
	@ManyToOne()
	@JoinColumn(name="who_add",foreignKey=@ForeignKey(name="items_ibfk_1"))
	private Users whoAdd;

	@OneToMany(mappedBy="items" , fetch=FetchType.EAGER)
	private Set<ItemsAmount> itemsAmount;
	
	/*Constructors*/
	


	public Items() {
		
	}
		
	public Items(ItemsKind idItemsKind, Palette idPaleta, Date addDate, Users whoAdd) {
		
		this.idItemsKind = idItemsKind;
		this.idPaleta = idPaleta;
		this.addDate = addDate;
		this.whoAdd = whoAdd;
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
		return addDate;
	}

	public void setAdd_date(Date addDate) {
		this.addDate = addDate;
	}

	public Users getWhoAdd() {
		return whoAdd;
	}

	public void setWhoAdd(Users who_add) {
		this.whoAdd = who_add;
	}
	
	public Set<ItemsAmount> getItemsAmount() {
		return itemsAmount;
	}

	public void setItemsAmount(Set<ItemsAmount> itemsAmount) {
		this.itemsAmount = itemsAmount;
	}
	
	
	@Override
	public String toString() {
		return "Items [id=" + id + ", idItemKind=" + idItemsKind + ", idPaleta=" + idPaleta + ", add_date=" + addDate
				+ ", who_add=" + whoAdd + "]";
	}
}
