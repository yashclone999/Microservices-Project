package com.search.service.search.DAO;

import java.math.BigInteger;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.search.service.search.models.AvailableRoom;



@Repository
public interface AvailableRoomDAO extends CrudRepository<AvailableRoom, BigInteger>{
	
	@Query(	"SELECT av.RoomID "
			+ "FROM AvailableRoom av "
			+ "WHERE av.date >= :start and av.date <= :end and av.Quantity >= :numRooms "
			+ "GROUP BY av.RoomID "
			+ "HAVING COUNT(av.date) = :numDays")
    Iterable<BigInteger> findAvailableRooms(@Param("start") Date startDate, @Param("end") Date endDate,  @Param("numRooms") Integer quantity, @Param("numDays") Long numDays);
}

