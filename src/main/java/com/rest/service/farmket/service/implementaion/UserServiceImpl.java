package com.rest.service.farmket.service.implementaion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import com.rest.service.farmket.dao.UserDao;
import com.rest.service.farmket.model.Role;
import com.rest.service.farmket.model.User;
import com.rest.service.farmket.model.dto.UserDto;
import com.rest.service.farmket.service.RoleService;
import com.rest.service.farmket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        userDao.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public User findOne(String username) {
        return userDao.findByUsername(username);
    }
    
    @Override
    public List<User> getAllMarkets() {
       Role role = roleService.findByName("MARKET");
       return userDao.findByRoles(role);
    }
    
    @Override
    public Map<Long, String> getMarketDetails() {
    	Role role = roleService.findByName("MARKET");
    	List<User> userList = userDao.findByRoles(role);
    	Map<Long, String> map = new HashMap<Long, String>();
    	for(User user: userList) {
    		map.put(user.getId(), user.getName());
    	}
    	return map;
    }
    
    @Override
    public String getMarketName(Long id) {
    	Optional<User> userOptional = userDao.findById(id);
    	String name = "";
    	if(userOptional.isPresent()) {
    		User user = userOptional.get();
    		name = user.getName();
    	}
    	return name;
    }

    @Override
    public User save(UserDto user) {

        User nUser = user.getUserFromDto();
        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        
        Set<Role> roleSet = new HashSet<>();
        
        if(nUser.getBusinessTitle().equals("FARMER")) {
        	Role role = roleService.findByName("FARMER");
        	roleSet.add(role);
        }

        if(nUser.getBusinessTitle().equals("MARKET")){
        	Role role = roleService.findByName("MARKET");
        	roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return userDao.save(nUser);
    }
}

