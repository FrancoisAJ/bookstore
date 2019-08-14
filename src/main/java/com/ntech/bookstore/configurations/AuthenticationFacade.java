/**
 * Created By
 * * asjoh
 * * at 15/05/2019
 * * with Joy
 * * for the bookstore project!
 **/

package com.ntech.bookstore.configurations;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements IAuthenticationFacade {

    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
