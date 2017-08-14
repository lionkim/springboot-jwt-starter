package net.bitnine.service.impl;

import net.bitnine.domain.User;
import net.bitnine.persistence.UserRepository;
import net.bitnine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fan.jin on 2016-10-15.
 */

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired private UserRepository repository;

    @Override
    @PreAuthorize("hasRole('USER')")
    public User findByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public User findById(Long id) throws AccessDeniedException {
        return repository.findOne(id);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> findAll() throws AccessDeniedException {
        return repository.findAll();
    }
    
}
