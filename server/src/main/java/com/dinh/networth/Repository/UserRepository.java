package com.dinh.networth.Repository;

import com.dinh.networth.Models.Asset;
import com.dinh.networth.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    List<User> findByName(String name);

    List<Asset> findByNameContaining(String name);
}
