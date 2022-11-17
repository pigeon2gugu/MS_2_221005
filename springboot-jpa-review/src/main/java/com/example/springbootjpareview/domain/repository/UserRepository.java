package com.example.springbootjpareview.domain.repository;

import com.example.springbootjpareview.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
