package com.bookingplatform.propertyservice.repository;

import com.bookingplatform.propertyservice.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {
    List<Room> findByPropertyId(UUID propertyId);
}