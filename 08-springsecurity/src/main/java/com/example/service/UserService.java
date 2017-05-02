package com.example.service;

import com.example.model.Privilege;
import com.example.model.User;
import com.example.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by RENT on 2017-03-08.
 */
@Service
public class UserService {

    @Value("${user.defaultUserPrivilege}")
    private String DEFAULT_USER;

    @Value("${user.validationCodeLength}")
    private int CODE_LENGTH;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PrivilegeService privilegeService;

    @Autowired
    private MailService mailService;

    @Autowired
    private PasswordEncoder encoder;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByValidationCode(String code) {
        return userRepository.findUserByValidationCode(code);
    }

    public User registerUser(User user) throws MessagingException {
        user = prepareUserToRegister(user);
        userRepository.save(user);
        mailService.sendMail(user.geteMail(), user.getValidationCode());
        return user;
    }

    private User prepareUserToRegister(User user) {
        user.setEnabled(false);
        user.setPassword(encoder.encode(user.getPassword()));
        //default privilege
        Set<Privilege> privileges = new HashSet<>();
        privileges.add(privilegeService.findByName(DEFAULT_USER));
        user.setPrivileges(privileges);
        //generate validation code
        user.setValidationCode(RandomStringUtils.randomAlphanumeric(CODE_LENGTH).toLowerCase());

        return user;
    }
}
