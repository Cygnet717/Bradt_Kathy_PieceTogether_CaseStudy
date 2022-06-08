package com.piecetogether.piecetogether.Service;

import com.piecetogether.piecetogether.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userServic;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userServic.findUserByUserName(userName);
        GrantedAuthority authorities = getUserAuthority(user);
        return buildUserForAuthentication(user, authorities);
    }

    private GrantedAuthority getUserAuthority(User user) {
        return new SimpleGrantedAuthority(user.getRole());
    }


    private UserDetails buildUserForAuthentication(User user, GrantedAuthority authorities) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                user.getActive(), true,
                true, true, (Collection<? extends GrantedAuthority>) authorities);
    }
}