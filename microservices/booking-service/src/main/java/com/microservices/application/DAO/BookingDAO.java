package com.microservices.application.DAO;

import java.math.BigInteger;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservices.application.models.Booking;



@Repository
public interface BookingDAO extends CrudRepository<Booking, BigInteger>{

}
