package com.hendisantika.springsecurityspringbootmysql;

import com.hendisantika.springsecurityspringbootmysql.domain.AppUser;
import com.hendisantika.springsecurityspringbootmysql.domain.Role;
import com.hendisantika.springsecurityspringbootmysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SpringSecuritySpringBootMysqlApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecuritySpringBootMysqlApplication.class, args);
    }

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private UserService userService;

    /*
     * This method will run during application startup and execute all the codes inside this method
     *
     */
    @Override
    public void run(String... arg0) {
        //Remove or comment this part after first execution of application,
        //or else duplicate data will be inserted in the database
		AppUser admin = new AppUser();
		admin.setActive(true);
		admin.setPassword(encoder.encode("password"));
		admin.setUsername("admin");
		admin.setRoles(Arrays.asList(new Role("ADMIN")));
		userService.saveUser(admin);

		AppUser user = new AppUser();
		user.setActive(true);
		user.setPassword(encoder.encode("password"));
		user.setUsername("user");
		user.setRoles(Arrays.asList(new Role("USER")));
		userService.saveUser(user);


    }
}
