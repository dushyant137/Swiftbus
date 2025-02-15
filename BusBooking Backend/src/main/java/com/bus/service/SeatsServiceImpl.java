package com.bus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bus.Repository.PassengerRepo;
import com.bus.Repository.SeatsRepo;
import com.bus.entities.Bus;
import com.bus.entities.Passengers;
import com.bus.entities.Seats;

@Service
@Transactional
public class SeatsServiceImpl implements SeatsService {
	
    @Autowired
    private SeatsRepo seatRepository;

    @Autowired
    private PassengerRepo passengerRepository;

	@Override
	public String addSeats(Seats seats) {
		seatRepository.save(seats);
		return "Seats added successfully";
	}

    @Override
    public String bookSeat(Long passengerId,int seatNo) {
       
        Passengers passenger = passengerRepository.findById(passengerId)
            .orElseThrow(() -> new RuntimeException("Passenger not found"));
        Seats seat = seatRepository.findBySeatNo(seatNo);

        
        if (!seat.isAvailable()) {
            return "Seat is already booked.";
        }

       
        seat.setAvailable(false);

       
        passenger.setSeat(seat); 

       
        seatRepository.save(seat);
        passengerRepository.save(passenger);

        return "Seat booked successfully!";
    }
    
    
    
    @Override
    public List<Seats> getAvailableSeatsForBus(Bus bus) {
        // Fetch and return available seats for the given bus
        return seatRepository.findByBusIdAndAvailableTrue(bus);
    }

}
