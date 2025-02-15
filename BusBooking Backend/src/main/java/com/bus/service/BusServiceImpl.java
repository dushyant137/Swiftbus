package com.bus.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.Repository.BusRepo;
import com.bus.custom_Exceptions.ResourceNotFoundException;
import com.bus.dto.Busdto;
import com.bus.entities.Bus;
import com.bus.entities.Passengers;

@Service
@Transactional
public class BusServiceImpl implements BusService{
	
	@Autowired
	public BusRepo busRepo;
	
	@Autowired
	public ModelMapper modelMapper;

	@Override
	public String addBus(Bus bus) {
		busRepo.save(bus);
		return "bus added successfully with No "+bus.getBusNo();
	}

	@Override
	public Busdto getBus(Long busNo) {
		Bus entity=busRepo.findById(busNo)
				.orElseThrow(()->new ResourceNotFoundException
						("Bus no is not valid Please enter valid No!!!"));
		return modelMapper.map(entity, Busdto.class);
	}

	@Override
	public Busdto updateBus(Long busNo, Bus bus) {
		Bus existingBus = busRepo.findById(busNo)
	            .orElseThrow(() -> new ResourceNotFoundException("Bus not found with busNo: " + busNo));
	    existingBus.setBusName(bus.getBusName()); 
	    existingBus.setArrivalCity(bus.getArrivalCity());
	    existingBus.setDepartureCity(bus.getDepartureCity());
	    existingBus.setOwnerId(bus.getOwnerId());
	    Bus updatedBus = busRepo.save(existingBus);
	    return modelMapper.map(updatedBus, Busdto.class);
		
	}

	@Override
	public String deleteBus(Long busNo) {
		busRepo.deleteById(busNo);
		return "bus with busNo "+busNo+" deleted successfully";
	}

	@Override
	public List<Bus> getAllBus() {
		
		return busRepo.findAll();
	}

	@Override
	public List<Bus> getAllBusAndPassengers(Long busNo) {
		
		return busRepo.getBusAndPassengers(busNo);
	}

}
