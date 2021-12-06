package com.Reservation.Repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Reservation.Models.Booking;

public interface BookingRepo extends MongoRepository<Booking, Long> {


	
}
