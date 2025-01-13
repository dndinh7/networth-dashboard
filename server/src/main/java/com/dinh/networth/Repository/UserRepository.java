package com.dinh.networth.Repository;

import com.dinh.networth.Models.Asset;
import com.dinh.networth.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByName(String name);

    List<Asset> findByNameContaining(String name);
}
