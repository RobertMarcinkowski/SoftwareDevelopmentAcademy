package com.example.service;

import com.example.model.Privilege;
import com.example.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by RENT on 2017-03-11.
 */
@Service
public class PrivilegeService {

    @Autowired
    private PrivilegeRepository privilegeRepository;

    public Privilege findByName(String name) {
        return privilegeRepository.findByName(name);
    }

    public void save(Privilege privilege) {
        privilegeRepository.save(privilege);
    }
}
