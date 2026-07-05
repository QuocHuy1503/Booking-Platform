package com.bookingplatform.propertyservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "room")
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    @JsonIgnore
    private Property property;

    private String roomName;
    private Integer roomFloor;
    private Integer bedroom;
    private Integer capacity;
    private BigDecimal basePrice;
    private BigDecimal weekendPrice;
    private String status; // available / booked / maintenance


}