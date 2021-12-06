package com.Reservation.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Reservation.Models.Booking;
import com.Reservation.Repo.BookingRepo;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepo repos;

	@Override
	public List<Booking> findAll() {
		return repos.findAll();
	}

	@Override
	public void addBooking(Booking book) {
		repos.insert(book);
	}

	@Override
	public Object updateBooking(Booking book) {
	
		return repos.save(book);
	}

	@Override
	public String deleteBooking(long parseLong) {
		repos.deleteById(parseLong);
		return "Reservartion Cancelled";
		
	}

	@Override
	public List<Booking> getAllBookings() {
		
		return repos.findAll();
	}

		
	}
