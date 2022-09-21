package com.example.demo.controllers;

import com.example.demo.entite.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class Testing {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;
   @Autowired
    private MyUserDetailsService userDetailsService;
    @GetMapping("/admin")
    public String hello(){
        return "helloa";
    }


    @RequestMapping(value = "/authenticate",method = RequestMethod.POST)
    public ResponseEntity<?>createAuthenticationToken(@RequestBody User user)throws Exception{

       try {
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));

       }
       catch(BadCredentialsException e){
           throw new Exception("incorrect username or password",e);
        }
       final UserDetails userDetails=userDetailsService.loadUserByUsername(user.getUsername());

       final String jwt=jwtTokenUtil.generatToken(userDetails);
       return  ResponseEntity.ok(jwt);
       }



}
