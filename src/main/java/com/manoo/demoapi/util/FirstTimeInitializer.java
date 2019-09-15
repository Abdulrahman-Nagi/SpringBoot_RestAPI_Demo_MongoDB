package com.manoo.demoapi.util;

import com.manoo.demoapi.security.AppUser;
import com.manoo.demoapi.security.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class FirstTimeInitializer implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(FirstTimeInitializer.class);

    @Autowired
    UserService userDetails;

    @Override
    public void run(String... args) throws Exception {




             if (userDetails.findAllusers().isEmpty()) {

            logger.info("No users found...!..Creating new USER");

            AppUser appUser = new AppUser("manoo@gmail.com","manoo1234","Abdulrahman Nagi");

            userDetails.save(appUser);

        }









    }
}
