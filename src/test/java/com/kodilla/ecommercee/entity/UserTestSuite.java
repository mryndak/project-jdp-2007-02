package com.kodilla.ecommercee.entity;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.domain.UserStatus;
import com.kodilla.ecommercee.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTestSuite {

    @Autowired
    UserRepository userRepository;

    private User userData() {
        User user = new User();
        user.setUserName("OrzelZnadWisly120");
        user.setStatus(UserStatus.TO_ACTIVATE);
        user.setUserKey(1L);
        user.setFirstName("Adam");
        user.setLastName("Małysz");
        user.setBirthDate(LocalDate.of(1980, 8, 18));
        user.setRegisterDate(LocalDate.now());
        user.setEmail("orzel@malysz.pl");
        user.setCity("Wisła");
        user.setPostCode("12-345");
        user.setStreet("Sniezna");
        user.setHouseNr("12");
        user.setPhoneNumber("010-12-13-14");
        user.setLogin("orzel120");
        user.setPassword("qwerty123");
        return user;
    }

    @Test
    public void testSaveUser() {
        //GIVEN
        User user = userData();
        //WHEN
        userRepository.save(user);
        //THEN
        Long userId = user.getId();
        Optional<User> readUser = userRepository.findById(userId);
        Assert.assertTrue(readUser.isPresent());
        //CLEANUP
        userRepository.deleteById(userId);
    }

    @Test
    public void testUpdateCart() {
        //GIVEN
        User user = userData();
        userRepository.save(user);
        //WHEN
        user.setFirstName("Janusz");
        user.setPassword("janusz123");
        userRepository.save(user);
        //THEN
        Long userId = user.getId();
        User readUser = userRepository.findById(userId).orElse(null);
        Assert.assertEquals(readUser.getFirstName(), "Janusz");
        Assert.assertEquals(readUser.getPassword(), "janusz123");
        //CLEANUP
        userRepository.deleteById(userId);
    }

    @Test
    public void testDeleteUser() {
        //GIVEN
        User user = userData();
        userRepository.save(user);
        Long userId = user.getId();
        //WHEN
        userRepository.deleteById(userId);
        //THEN
        Optional<User> readUser = userRepository.findById(userId);
        Assert.assertFalse(readUser.isPresent());
    }

}
