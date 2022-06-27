package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.model.Other;
import com.kathybradt.piecetogether.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
class OtherServiceTest {
@Autowired
    private TestEntityManager entityManager;
    @Autowired
    private  OtherService otherService;

    @Test
    void get() {
    //arrange

        User newUser = new User("Test", "Tester", "test@email.com", "testPassword");
        Other newOther = new Other("test title", "test notes", new Date(100000), "Other", newUser);
        this.entityManager.persist(newUser);
    //act
        Other testOther = otherService.get(newOther.getEventId());
        //assert
        assertEquals(newOther, testOther);
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }
}