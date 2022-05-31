package com.search.service.search.DAO;

import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.search.service.search.models.Hotel;

@Repository
public interface HotelDAO extends CrudRepository<Hotel, BigInteger>{
	
}


