package com.bus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.Repository.BusRepo;
import com.bus.Repository.PassengerRepo;
import com.bus.Repository.SeatsRepo;
import com.bus.entities.Bus;
import com.bus.entities.Passengers;
import com.bus.entities.Seats;

@Service
@Transactional
public class PassengerServiceImpl implements PassengerService {

	@Autowired
	public SeatsRepo seatsRepo;
	@Autowired
	public BusRepo busRepo;
	
	@Autowired
	public PassengerRepo passengerRepo;
	
//	@Override
//	public Passengers addPassengerToSeat(String passengerName, int seatNo) {
//		
//		Seats seat = new Seats();
//        seat.setSeatNo(seatNo);
//        seat = seatsRepo.save(seat);  
//        Passengers passenger = new Passengers();
//        passenger.setPassengerName(passengerName);
//        passenger.setSeat(seat);  
//        passenger = passengerRepo.save(passenger);
//        seat.setPassenger(passenger);
//        seatsRepo.save(seat);
//
//        return passenger;
//	}

	@Override
	public String addPassenger(Passengers passenger) {
		passengerRepo.save(passenger);
		return "passenger added successfully";
	}



@Override
public List<Bus> getAllBuses() {
	
	return busRepo.findAll();
}

@Override
public List<Seats> getAllSeats(Long busNo) {
	
	return seatsRepo.findAll();
}



@Override
public String bookSeatForPassenger(Long seatId, Long passengerId) {
    Optional<Passengers> passengerOpt = passengerRepo.findById(passengerId);
    if (!passengerOpt.isPresent()) {
        return "Passenger not found!";
    }
    Passengers passenger = passengerOpt.get();

    Optional<Seats> seatOpt = seatsRepo.findById(seatId);
    if (!seatOpt.isPresent()) {
        return "Seat not found!";
    }
    Seats seat = seatOpt.get();

    if (!seat.isAvailable()) {
        return "Seat is already booked!";
    }
    seat.setAvailable(false);
    
    passenger.setSeat(seat); 
    seatsRepo.save(seat); 
    passengerRepo.save(passenger); 

    return "Seat booked successfully!";
}

	
}
