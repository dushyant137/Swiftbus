package com.bus.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bus.entities.Owner;

public class Busdto {
	
	public Long busNo;
	public String busName;
	public String arrivalCity;
	public String departureCity;
	public LocalDate arrivalDate;
	public LocalDate departureDate;
	public Busdto(String busName, String arrivalCity, String departureCity, LocalDate arrivalDate,
			LocalDate departureDate) {
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
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	public LocalDate getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	
	
	private Owner ownerId;
	
	public Owner getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Owner ownerId) {
		this.ownerId = ownerId;
	}
	
	public Busdto() {
		// TODO Auto-generated constructor stub
	}
	
	List<DriverDto>drivers=new ArrayList<>();
	
	List<PassengerDto>passengers=new ArrayList<>();

}
