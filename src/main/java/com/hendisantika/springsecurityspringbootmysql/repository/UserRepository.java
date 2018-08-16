package com.hendisantika.springsecurityspringbootmysql.repository;

import com.hendisantika.springsecurityspringbootmysql.domain.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-spring-boot-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/08/18
 * Time: 06.16
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String name);
}