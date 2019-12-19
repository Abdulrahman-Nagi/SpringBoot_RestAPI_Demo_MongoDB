package com.manoo.demoapi.security;

import com.manoo.demoapi.exceptionHandling.ConfilictException;
import com.manoo.demoapi.exceptionHandling.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    AppUserRepo appUserRepo;

    @Bean
    private PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


    AppUser user = appUserRepo.findByEmail(username);

    if(user==null) {

        throw  new NotFoundException("User Not found!");
    }

    return user;

    }





    public void save(AppUser user) {


        if(appUserRepo.findByEmail(user.getUsername())!=null){
            throw new ConfilictException(String.format("The User [%s]  already exists",user.getUsername()));
        }

        user.setPassword(passwordEncoder().encode(user.getPassword()));
        appUserRepo.save(user);
    }



    public List<AppUser> findAllusers() {
        return appUserRepo.findAll();
    }


    public AppUser findUserByEmail(String email) {

        return appUserRepo.findByEmail(email);
    }

}
