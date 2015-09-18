package toursite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toursite.dao.ReviewDAO;
import toursite.dao.UserDAO;
import toursite.model.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vasyl on 31.05.2015.
 */

public class UserDetailsServiceImpl implements  UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    @Transactional
    public UserDetails loadUserByUsername(final String username)
            throws UsernameNotFoundException {
        System.out.println("loadUserByUsername"+ username);
        toursite.model.User user = userDAO.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("Username \'"+username+"\' not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_USER";
            }
        };
        authorities.add(authority);

        return new User(user.getUsername(), user.getPassword(), authorities);

    }
}
