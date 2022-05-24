package com.microservices.application.DAO;

import java.math.BigInteger;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.microservices.application.models.AvailableRoom;



@Repository
public interface AvailableRoomDAO extends CrudRepository<AvailableRoom, BigInteger>{
	
	@Modifying
	@Query(	"UPDATE AvailableRoom "
			+ "SET Quantity = (Quantity - :numRooms) "
			+ "WHERE RoomID = :roomId and date >= :start and date <= :end ")
    void updateReservedRooms(@Param("start") Date startDate, @Param("end") Date endDate,  @Param("numRooms") Integer numRooms, @Param("roomId") BigInteger roomID);
	
	@Modifying
	@Query(	"UPDATE AvailableRoom "
			+ "SET Quantity = (Quantity + :numRooms) "
			+ "WHERE RoomID = :roomId and date >= :start and date <= :end ")
	void updateCancelledRooms(@Param("start") Date startDate, @Param("end") Date endDate,  @Param("numRooms") Integer numRooms, @Param("roomId") BigInteger roomID);
	
	@Query(	"SELECT av.RoomID "
			+ "FROM AvailableRoom av "
			+ "WHERE av.date >= :start and av.date <= :end and av.Quantity >= :numRooms "
			+ "GROUP BY av.RoomID "
			+ "HAVING COUNT(av.date) = :numDays and av.RoomID = :roomID")
	Optional<BigInteger> checkAvailablity(@Param("roomID") BigInteger roomID, @Param("start") Date startDate, @Param("end") Date endDate,  @Param("numRooms") Integer quantity, @Param("numDays") Long numDays);
}

