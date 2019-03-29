package com.example.demo;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.User;
import com.example.demo.Entity.UserAddress;
import com.example.demo.Repository.AddressRepository;
import com.example.demo.Repository.UserAddressRepository;
import com.example.demo.Repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Console;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserAddressRepository userAddressRepository;
    @Test
    public void contextLoads() {
    }
    @Test
    public void init() {
        Address address = new Address("957");
        addressRepository.save(address);

        User user = new User("wupeng");
        userRepository.save(user);

        UserAddress userAddress = new UserAddress(user, address);
        userAddressRepository.save(userAddress);
    }

    @Test
    public void testAdd() {
        List<Address> list = addressRepository.list("957");
        list.forEach(address -> {
            System.out.println(address.getDetail());
        });
    }

    @Test
    public void testUser() {
        List<User> list = userRepository.list(1);
        list.forEach(user -> {
            System.out.println(user.getName());
        });
    }


    @Test
    public void testUserAddress() {
        List<UserAddress> list = userAddressRepository.list("wupeng", "957");
        list.forEach(userAddress -> {
            System.out.println(userAddress.getUser());
            System.out.println(userAddress.getAddress());
            System.out.println(userAddress.getInsertTime());
        });
    }
}
