package com.bus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bus.entities.Passengers;
import com.bus.service.PassengerService;

@RestController
@RequestMapping("/passenger")
public class PassengerController {
	
	@Autowired
	public PassengerService passService;
	
	@PostMapping("/addPassenger")
    public ResponseEntity<?> addPassenger(@RequestBody Passengers passeneger) {
        return ResponseEntity.ok(passService.addPassenger(passeneger));
    }

	
	 @GetMapping("/getAllBuses")
	    public ResponseEntity<?> getPassenger() {
	        return ResponseEntity.ok(passService.getAllBuses());
	    }
	 @GetMapping("/getAllSeats/{busNo}")
	    public ResponseEntity<?> getSeats(@PathVariable Long busNo) {
	        return ResponseEntity.ok(passService.getAllSeats(busNo));
	    }
	 
	 
	 @PostMapping("/book-seat")
	    public String bookSeat(@RequestParam Long seatId, @RequestParam Long passengerId) {
	        return passService.bookSeatForPassenger(seatId, passengerId);
	    }
}
