package org.tc.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tc.backend.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByPhoneNumber(String phoneNumber);

    Optional<User> findByPhoneNumber(String phoneNumber);
}
