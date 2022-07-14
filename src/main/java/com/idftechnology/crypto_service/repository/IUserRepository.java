package com.idftechnology.crypto_service.repository;

import com.idftechnology.crypto_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, String> {

    List<User> findBySymbol(String symbol);
}
