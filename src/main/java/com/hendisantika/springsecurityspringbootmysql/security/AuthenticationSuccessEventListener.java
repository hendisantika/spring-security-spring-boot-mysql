package com.hendisantika.springsecurityspringbootmysql.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-spring-boot-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/08/18
 * Time: 06.20
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    private Logger log = LoggerFactory.getLogger(AuthenticationFailureEventListener.class);

    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        WebAuthenticationDetails wad = (WebAuthenticationDetails) event.getAuthentication().getDetails();
        log.info("Login success from " + event.getAuthentication().getDetails());
    }

}