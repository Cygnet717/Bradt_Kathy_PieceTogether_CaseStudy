package com.kathybradt.piecetogether.Service;

import com.kathybradt.piecetogether.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {

    private UserService userService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.findUserByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException(("Not Found!"));
        }
        GrantedAuthority authorities = getUserAuthority(user);
        return buildUserForAuthentication(user, authorities);
    }

    private GrantedAuthority getUserAuthority(User user) {
        return new SimpleGrantedAuthority(user.getRole());
    }


    private UserDetails buildUserForAuthentication(User user, GrantedAuthority authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

            grantedAuthorities.add(authorities);

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(), user.getPassword(),
                user.getActive(), true,
                true, true, (Collection<? extends GrantedAuthority>) grantedAuthorities);
    }
}