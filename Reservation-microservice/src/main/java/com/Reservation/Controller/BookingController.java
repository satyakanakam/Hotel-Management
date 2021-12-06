package com.Reservation.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.Reservation.Models.Booking;
import com.Reservation.Services.BookingService;

@RestController
@RequestMapping("/reservation")
public class BookingController {

	@Autowired
	private BookingService service;
	
	

	@GetMapping("/hello")
	public String helloMsgs() {
		return "Reservation Microservice";
	}
	
	@PostMapping("/addReservation")
	public void addBooking(@RequestBody Booking book) 
	{
		 this.service.addBooking(book); 
	}


	@PutMapping("/updateReservation")
	public Object updateBooking(@RequestBody Booking book)
	{
		return this.service.updateBooking(book); 
	}
	

	@DeleteMapping("/cancelReservation/{id}")
	public String deleteBooking(@PathVariable("id") String id) 
	{
		return this.service.deleteBooking(Long.parseLong(id));
	}
	

	@GetMapping("/ShowAllReservations")
	public List<Booking> getAllBookings()
	{
		return this.service.getAllBookings();
	}
}
