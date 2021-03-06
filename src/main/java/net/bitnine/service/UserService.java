package net.bitnine.service;

import net.bitnine.domain.User;

import java.util.List;

/**
 * Created by fan.jin on 2016-10-15.
 */
public interface UserService {
    
    public User findById (Long id);
    public User findByUsername (String username);
    public List<User> findAll ();
}
