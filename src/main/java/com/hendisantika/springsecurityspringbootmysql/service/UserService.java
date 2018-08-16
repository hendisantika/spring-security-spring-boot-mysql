package com.hendisantika.springsecurityspringbootmysql.service;

import com.hendisantika.springsecurityspringbootmysql.domain.AppUser;

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
public interface UserService {
    AppUser saveUser(AppUser user);
}
