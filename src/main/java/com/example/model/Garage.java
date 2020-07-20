package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_garage")
public class Garage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "DOORS")
	private int doors;

	@Column(name = "PLATE NUMBER")
	private String platenumber;

	@Column(name = "BRAND")
	private String brand;

	@Column(name = "RENTING PRICE")
	private String rentingprice;

	public Garage() {

	}

	public Garage(int id, int doors, String platenumber, String brand, String rentingprice) {
		super();
		this.id = id;
		this.doors = doors;
		this.platenumber = platenumber;
		this.brand = brand;
		this.rentingprice = rentingprice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public String getPlatenumber() {
		return platenumber;
	}

	public void setPlatenumber(String platenumber) {
		this.platenumber = platenumber;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getRentingprice() {
		return rentingprice;
	}

	public void setRentingprice(String brand) {
		this.brand = rentingprice;
	}

}
