package com.kathybradt.piecetogether.Controllers;

import com.kathybradt.piecetogether.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class NavigationControllerTest {

    @Test
    void login() {
        NavigationController controller = new NavigationController(); //arrange
        String response = controller.login(); //act
        assertEquals("loginPage", response);//assert
    }

    @Test
    void registration() {
        NavigationController controller = new NavigationController();
        ModelAndView modelAndView = new ModelAndView();//arrange
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("registerPage");

        ModelAndView response = controller.registration(); //act

        assertEquals(modelAndView.getModel().getClass(), response.getModel().getClass());//assert
    }

    @Test
    void createNewUser() {
    }
}