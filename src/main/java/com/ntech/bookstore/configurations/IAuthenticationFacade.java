/**
 * Created By
 * * asjoh
 * * at 15/05/2019
 * * with Joy
 * * for the bookstore project!
 **/
package com.ntech.bookstore.configurations;

import org.springframework.security.core.Authentication;

public interface IAuthenticationFacade {
    Authentication getAuthentication();
}


