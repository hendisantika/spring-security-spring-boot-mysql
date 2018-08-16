package com.hendisantika.springsecurityspringbootmysql.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-spring-boot-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/08/18
 * Time: 06.22
 * To change this template use File | Settings | File Templates.
 */
@Component
public class AuthenticationFailureEventListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private Logger log = LoggerFactory.getLogger(AuthenticationFailureEventListener.class);

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        WebAuthenticationDetails wad = (WebAuthenticationDetails) event.getAuthentication().getDetails();
        log.info("Login failed request from " + event.getAuthentication().getDetails());
    }

}