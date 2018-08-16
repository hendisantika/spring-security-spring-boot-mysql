package com.hendisantika.springsecurityspringbootmysql.service;

import com.hendisantika.springsecurityspringbootmysql.domain.AppUser;
import com.hendisantika.springsecurityspringbootmysql.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-spring-boot-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/08/18
 * Time: 06.17
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public AppUser saveUser(AppUser user) {
        return userRepository.save(user);
    }

}
