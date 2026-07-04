package com.bookingplatform.propertyservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Integer age;
    private String address;
    private String email;
    private String contactNumber;
    private String emergencyContactNumber;
    private String role;
}