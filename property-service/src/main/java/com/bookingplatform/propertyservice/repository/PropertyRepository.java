package com.bookingplatform.propertyservice.repository;

import com.bookingplatform.propertyservice.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PropertyRepository extends JpaRepository<Property, UUID> {
}