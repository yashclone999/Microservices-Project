package com.search.service.search.DAO;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.search.service.search.models.Room;

;

@Repository
public interface RoomDAO extends CrudRepository<Room, BigInteger>{
	
	@Query(	"SELECT R "
			+ "FROM Room R JOIN R.hotel H "
			+ "WHERE H.location = :location AND R.price >= :priceStart AND R.price <= :priceEnd")
	public Iterable<Room> findByLocationAndPrice(@Param("location") String location, @Param("priceStart") BigDecimal priceStart,  @Param("priceEnd") BigDecimal priceEnd);

}

