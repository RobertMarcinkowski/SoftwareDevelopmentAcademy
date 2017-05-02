package com.szymon.service;

import com.szymon.model.User;
import com.szymon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HelloService {

    @Autowired
    private UserRepository userRepository;

    public Map<String, Object> getData() {
        Map<String, Object> map = new HashMap<>();
        map.put("Hello", "World ajsdhajsdhasjd");
        return map;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(users::add);
        return users;
    }
}
