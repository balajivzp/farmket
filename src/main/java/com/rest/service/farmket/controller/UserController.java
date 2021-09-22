package com.rest.service.farmket.controller;

import com.rest.service.farmket.config.TokenProvider;
import com.rest.service.farmket.model.AuthToken;
import com.rest.service.farmket.model.LoginUser;
import com.rest.service.farmket.model.ProductSheet;
import com.rest.service.farmket.model.User;
import com.rest.service.farmket.model.dto.UserDto;
import com.rest.service.farmket.service.ProductService;
import com.rest.service.farmket.service.UserService;
import com.sun.org.apache.bcel.internal.generic.RETURN;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    @RequestMapping(value="/getId/{username}", method = RequestMethod.GET)
    public Map<String, Long> getId(@PathVariable String username) {
    	User user  = new User();
    	user = userService.findOne(username);
    	Long id = user.getId();
    	Map<String, Long> map = new HashMap<>();
    	map.put("id", id);
    	return map;
    }
    @RequestMapping(value="/getMarketName/{id}", method = RequestMethod.GET)
    public Map<String, String> getMarketName(@PathVariable Long id) {
    	//return  userService.getMarketName(id);
    	String name =  userService.getMarketName(id);
    	Map<String, String> map = new HashMap<>();
    	map.put("name", name);
   	return map;
    }
    
    
  
    @RequestMapping(value = "/getUserRole/{username}", method = RequestMethod.GET )
    public Map<String, String>  getBusinessTitle(@PathVariable String username) {
    	User user  = new User();
    	user = userService.findOne(username);
    	Map<String, String> map = new HashMap<>();
    	map.put("role", user.getBusinessTitle());
    	return map;
    }
    
    @RequestMapping(value = "/getMarketList", method = RequestMethod.GET)
    public List<User> getMarketDetails() {
    	return userService.getAllMarkets();
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
