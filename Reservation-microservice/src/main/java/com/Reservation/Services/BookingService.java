package com.Reservation.Services;

import java.util.List;


import com.Reservation.Models.Booking;

public interface BookingService {

	List<Booking> findAll();

	void addBooking(Booking book);

	Object updateBooking(Booking book);

	String deleteBooking(long parseLong);

	

	List<Booking> getAllBookings();
}

