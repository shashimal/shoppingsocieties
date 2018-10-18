package com.shoppingsocieties.repository;

import com.shoppingsocieties.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * Responsible for handling all the database operations of User entity
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
