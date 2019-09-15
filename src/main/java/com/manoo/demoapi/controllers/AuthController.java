package com.manoo.demoapi.controllers;


import com.manoo.demoapi.security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {

    @Autowired
  private   TokenUtil tokenUtil;

    @Autowired
   private UserService userService;

    @Autowired
   private AuthenticationManager authenticationManager;



    @PostMapping(value ={ "","/"})
    public JwtResponse signIn(@RequestBody SignInRequest signInRequest) {


        final Authentication authentication = authenticationManager.authenticate(

                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword())
        );


        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails=userService.loadUserByUsername(signInRequest.getUsername());

        String generatedToken= tokenUtil.generateToken(userDetails);

        return new JwtResponse(generatedToken);

    }


    @PostMapping(value ={"/signup","/signup/"} )
    public ResponseEntity<Void> signUp(@Valid @RequestBody AppUser appUser) {

     userService.save(appUser);

        return new ResponseEntity<Void>(HttpStatus.OK);

    }


}
