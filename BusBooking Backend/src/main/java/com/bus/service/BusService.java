package com.bus.service;

import java.util.List;

import com.bus.dto.Busdto;
import com.bus.entities.Bus;
import com.bus.entities.Passengers;

public interface BusService {
	
	String addBus(Bus bus);
	Busdto getBus(Long busNo);
	Busdto updateBus(Long busNo,Bus bus);
	String deleteBus(Long busNo);
	List<Bus>getAllBus();
	List<Bus> getAllBusAndPassengers(Long passengerId);

}
