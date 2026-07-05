package com.bookingplatform.propertyservice.controller;

import com.bookingplatform.propertyservice.entity.Property;
import com.bookingplatform.propertyservice.entity.Room;
import com.bookingplatform.propertyservice.repository.PropertyRepository;
import com.bookingplatform.propertyservice.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    // Lấy tất cả room thuộc 1 property
    @GetMapping("/properties/{propertyId}/rooms")
    public List<Room> getRoomsByProperty(@PathVariable UUID propertyId) {
        return roomRepository.findByPropertyId(propertyId);
    }

    // Tạo room mới cho 1 property
    @PostMapping("/properties/{propertyId}/rooms")
    public ResponseEntity<Room> createRoom(@PathVariable UUID propertyId, @RequestBody Room room) {
        return propertyRepository.findById(propertyId)
                .map(property -> {
                    room.setProperty(property);
                    return ResponseEntity.ok(roomRepository.save(room));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable UUID id) {
        return roomRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable UUID id, @RequestBody Room updated) {
        return roomRepository.findById(id)
                .map(room -> {
                    room.setRoomName(updated.getRoomName());
                    room.setRoomFloor(updated.getRoomFloor());
                    room.setBedroom(updated.getBedroom());
                    room.setCapacity(updated.getCapacity());
                    room.setBasePrice(updated.getBasePrice());
                    room.setWeekendPrice(updated.getWeekendPrice());
                    room.setStatus(updated.getStatus());
                    return ResponseEntity.ok(roomRepository.save(room));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable UUID id) {
        if (!roomRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        roomRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}