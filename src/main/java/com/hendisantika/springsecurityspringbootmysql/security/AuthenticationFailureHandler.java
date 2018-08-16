package com.hendisantika.springsecurityspringbootmysql.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-security-spring-boot-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 17/08/18
 * Time: 06.21
 * To change this template use File | Settings | File Templates.
 */
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        String errorMessage = "failed login attempt. invalid username or password";
        if (exception.getMessage().equalsIgnoreCase("blocked")) {
            errorMessage = "you have been blocked for 3 unsuccessful login attempt";
        }
        System.out.println("path " + request.getPathInfo());
        response.sendRedirect(request.getPathInfo());
    }

}