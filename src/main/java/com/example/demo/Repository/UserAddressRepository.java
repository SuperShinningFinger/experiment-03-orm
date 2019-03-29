package com.example.demo.Repository;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.User;
import com.example.demo.Entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserAddressRepository extends JpaRepository<UserAddress, Integer> {
    @Query("select ua from UserAddress ua where user.name = :name and address.detail = :detail")
    List<UserAddress> list(@Param("name") String name, @Param("detail") String detail);
}
