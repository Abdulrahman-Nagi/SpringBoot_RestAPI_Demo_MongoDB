package com.manoo.demoapi.util;

import com.manoo.demoapi.security.AppUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class BasicUtil {

    public AppUser getCurrentUser(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (AppUser) authentication.getPrincipal();
    }
}
