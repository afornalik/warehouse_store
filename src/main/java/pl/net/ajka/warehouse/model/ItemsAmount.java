package pl.net.ajka.warehouse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items_amount")
public class ItemsAmount {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column (name="id_amount")
	private int idItemsAmount;
	
	@Column(name="id_item")
	private int idItem;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="date_of_modification")
	private Date dateOfModification;
	
	@Column(name="who_add")
	private int idUser;

	public int getIdItemsAmount() {
		return idItemsAmount;
	}

	public void setIdItemsAmount(int idItemsAmount) {
		this.idItemsAmount = idItemsAmount;
	}

	public int getIdItem() {
		return idItem;
	}

	public void setIdItem(int idItem) {
		this.idItem = idItem;
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

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	@Override
	public String toString() {
		return "ItemsAmount [idItemsAmount=" + idItemsAmount + ", idItem=" + idItem + ", amount=" + amount
				+ ", dateOfModification=" + dateOfModification + ", idUser=" + idUser + "]";
	}
	
	
}
