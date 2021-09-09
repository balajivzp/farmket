package com.rest.service.farmket.controller;

import com.rest.service.farmket.config.TokenProvider;
import com.rest.service.farmket.model.AuthToken;
import com.rest.service.farmket.model.LoginUser;
import com.rest.service.farmket.model.ProductSheet;
import com.rest.service.farmket.model.User;
import com.rest.service.farmket.model.dto.UserDto;
import com.rest.service.farmket.service.ProductService;
import com.rest.service.farmket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) throws AuthenticationException {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public User saveUser(@RequestBody UserDto user){
        return userService.save(user);
    }
    
    @RequestMapping(value = "/saveProductSheet", method = RequestMethod.POST)
    public String saveProductSheet(@RequestBody ProductSheet productSheet) {
    	return productService.save(productSheet);
    }
    
    @RequestMapping(value = "/getBusinessTitle/{username}", method = RequestMethod.POST )
    public String  getBusinessTitle(@PathVariable String username) {
    	User user  = new User();
    	user = userService.findOne(username);
    	return user.getBusinessTitle();
    }



    @PreAuthorize("hasRole('FARMER')")
    @RequestMapping(value="/farmerping", method = RequestMethod.GET)
    public String adminPing(){
        return "Only Farmers Can Read This";
    }

    @PreAuthorize("hasRole('MARKET')")
    @RequestMapping(value="/marketping", method = RequestMethod.GET)
    public String userPing(){
        return "Only Market can access this";
    }

}
