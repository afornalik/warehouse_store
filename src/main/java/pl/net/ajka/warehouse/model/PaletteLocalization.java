package pl.net.ajka.warehouse.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paleta_loc_description")
public class PaletteLocalization {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="loc_name")
	private String localizationName;
	
	@Column(name="rows")
	private int rows;
	
	@Column(name="columns")
	private int columns;
	
	@Column(name="max_capacity")
	private int maxCapacity;
	
	@Column(name="free_location")
	private int freeLocation;

	
	
	
	
	public PaletteLocalization() {
		super();
	}

	public PaletteLocalization(String localizationName, int rows, int columns, int maxCapacity, int freeLocation) {
		super();
		this.localizationName = localizationName;
		this.rows = rows;
		this.columns = columns;
		this.maxCapacity = maxCapacity;
		this.freeLocation = freeLocation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocalizationName() {
		return localizationName;
	}

	public void setLocalizationName(String localizationName) {
		this.localizationName = localizationName;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

	public int getFreeLocation() {
		return freeLocation;
	}

	public void setFreeLocation(int freeLocation) {
		this.freeLocation = freeLocation;
	}

	@Override
	public String toString() {
		return "PaletteLocalization [id=" + id + ", localizationName=" + localizationName + ", rows=" + rows
				+ ", columns=" + columns + ", maxCapacity=" + maxCapacity + ", freeLocation=" + freeLocation + "]";
	}


}
