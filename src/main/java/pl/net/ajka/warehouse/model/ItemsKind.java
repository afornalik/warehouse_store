package pl.net.ajka.warehouse.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="items_kind")
public class ItemsKind {
	
	@Id
	@Column(name="id_item_kind")
	@GeneratedValue (strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="index_code")
	private int indexCode;
	
	@Column(name="name")
	private String name;
	
	@Column(name="family")
	private String family;
	
	@Column(name="add_date")
	private Date addDate;
	
	@ManyToOne
	@JoinColumn(name="who_add",foreignKey=@ForeignKey(name="items_kind_ibfk_1"))
	private Users users;


	@OneToMany(mappedBy="idItemsKind", fetch=FetchType.EAGER)
	private Set<Items> items;
	
	@ManyToMany()
	@JoinTable(name="itemsKindToPalette", joinColumns= @JoinColumn(name="idItemsKind",referencedColumnName="id_item_kind"),
							inverseJoinColumns=@JoinColumn(name="idPaleta",referencedColumnName="id_paleta"))
	private Set<Palette> palette;
	
	/*Constructors*/
	
	

	public ItemsKind() {
		super();
	}
	
	public ItemsKind(int indexCode, String name, String family, Date addDate, Users users) {
		this.indexCode = indexCode;
		this.name = name;
		this.family = family;
		this.addDate = addDate;
		this.users= users;
	}
	
	
	/*Setters and Getters*/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIndexCode() {
		return indexCode;
	}

	public void setIndexCode(int indexCode) {
		this.indexCode = indexCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}


	public Users getUser() {
		return users;
	}

	public void setUser(Users idUser) {
		this.users = idUser;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}
	
	public Set<Palette> getPalette() {
		return palette;
	}

	public void setPalette(Set<Palette> palette) {
		this.palette = palette;
	}

	
	
	@Override
	public String toString() {
		return "ItemsKind [id=" + id + ", indexCode=" + indexCode + ", name=" + name + ", family=" + family
				+ ", addDate=" + addDate + "," + ", users=" + users + "]";
	}
}
