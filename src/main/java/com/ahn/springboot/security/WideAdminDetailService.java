package com.ahn.springboot.security;

import com.ahn.springboot.domain.WideAdmin;
import com.ahn.springboot.persistence.WideAdminRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class WideAdminDetailService implements UserDetailsService {
    private static final String ROLE_PREFIX = "ROLE_";

    @Autowired
    WideAdminRepository wideAdminRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("email "+ username);
        WideAdmin wideAdmin = wideAdminRepository.findByWide_admin_email(username).get(0);

        if(wideAdmin!=null){
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

            authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + wideAdmin.getWide_admin_roleCode()));

            return new User(wideAdmin.getWide_admin_email(),wideAdmin.getWide_admin_password(),authorities);
        }

       throw new UsernameNotFoundException("User'"+username+"'not found.");

    }



}
