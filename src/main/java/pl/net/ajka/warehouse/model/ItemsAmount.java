package pl.net.ajka.warehouse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="items_amount")
public class ItemsAmount {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="id_amount")
	private int idItemsAmount;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_item", foreignKey=@ForeignKey(name="items_amount_ibfk_2"))
	private Items items;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="date_of_modification")
	private Date dateOfModification;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="who_add",foreignKey=@ForeignKey(name="items_amount_ibfk_1"))
	private Users users;


	
	/*Constructors*/
	
	public ItemsAmount() {
		super();
		
	}

	public ItemsAmount(Items items, int amount, Date dateOfModification, Users users) {
		this.items = items;
		this.amount = amount;
		this.dateOfModification = dateOfModification;
		this.users = users;
	}

	
	/*Setters and Getters*/
	
	public int getIdItemsAmount() {
		return idItemsAmount;
	}

	public void setIdItemsAmount(int idItemsAmount) {
		this.idItemsAmount = idItemsAmount;
	}

	public Items getIdItem() {
		return items;
	}

	public void setIdItem(Items items) {
		this.items = items;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Date getDateOfModification() {
		return dateOfModification;
	}

	public void setDateOfModification(Date dateOfModification) {
		this.dateOfModification = dateOfModification;
	}

	public Users getIdUser() {
		return users;
	}

	public void setIdUser(Users users) {
		this.users = users;
	}

	
		
	
	@Override
	public String toString() {
		return "ItemsAmount [idItemsAmount=" + idItemsAmount + ", idItem=" + items + ", amount=" + amount
				+ ", dateOfModification=" + dateOfModification + ", idUser=" + users + "]";
	}
	
	
}
