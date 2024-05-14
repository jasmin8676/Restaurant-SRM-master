package com22.rest1.repository;

import com22.rest1.dto.userDto.UserResponse;
import com22.rest1.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
            select new com22.rest1.dto.userDto.UserResponse
                        (   u.id,
                            u.firstName,
                            u.lastName,
                            u.dateOfBirth,
                            u.email,
                            u.password,
                            u.phoneNumber,
                            u.role,
                            u.experience)
                        from User u
            """)
    List<UserResponse> getAll();

    Optional<User> getUserByEmail(String email);

    boolean existsByEmail(String email);
}
