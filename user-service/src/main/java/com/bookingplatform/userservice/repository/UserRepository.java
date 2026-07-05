package com.bookingplatform.userservice.repository;

import com.bookingplatform.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}