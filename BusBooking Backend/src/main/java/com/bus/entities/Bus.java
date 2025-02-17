package com.bus.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long busNo;
	@Column(nullable = false,length = 20)
	public String busName;
	@Column(nullable = false,length = 20)
	public String arrivalCity;
	@Column(nullable = false,length = 20)
	public String departureCity;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	public LocalDateTime arrivalDate;
	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
	public LocalDateTime departureDate;
	public Bus(String busName, String arrivalCity, String departureCity, LocalDateTime arrivalDate,
			LocalDateTime departureDate) {
		super();
		this.busName = busName;
		this.arrivalCity = arrivalCity;
		this.departureCity = departureCity;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}
	@Override
	public String toString() {
		return "Bus [busNo=" + busNo + ", busName=" + busName + ", arrivalCity=" + arrivalCity + ", departureCity="
				+ departureCity + ", arrivalDate=" + arrivalDate + ", departureDate=" + departureDate + "]";
	}
	public Long getBusNo() {
		return busNo;
	}
	public void setBusNo(Long busNo) {
		this.busNo = busNo;
	}
	public String getBusName() {
		return busName;
	}
	public void setBusName(String busName) {
		this.busName = busName;
	}
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	public LocalDateTime getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDateTime arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public LocalDateTime getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="ownerId",nullable = false)
	private Owner ownerId;
	
	public Owner getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Owner ownerId) {
		this.ownerId = ownerId;
	}
	public Bus() {
		// TODO Auto-generated constructor stub
	}
	
	@OneToMany(mappedBy = "busNo",orphanRemoval = true,cascade =CascadeType.ALL )
	@JsonManagedReference
	List<Driver>drivers=new ArrayList<>();
	
	@OneToMany(mappedBy = "passBus",orphanRemoval = true,cascade =CascadeType.ALL )
	@JsonManagedReference
	List<Passengers>passengers=new ArrayList<>();
	
	
	@OneToMany(mappedBy = "busId",orphanRemoval = true,cascade =CascadeType.ALL )
	@JsonManagedReference
	List<Seats>seats=new ArrayList<>();
	
	
	
}
