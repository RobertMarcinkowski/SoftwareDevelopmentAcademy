package com.example.controller;

import com.example.model.Privilege;
import com.example.model.User;
import com.example.service.PrivilegeService;
import com.example.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

/**
 * Created by RENT on 2017-03-07.
 */
@Controller
public class AppController {

    @Value("${user.defaultUserPrivilege}")
    private String DEFAULT_USER;

    @Autowired
    private UserService userService;

    @Autowired
    private PrivilegeService privilegeService;

    @PostConstruct
    public void addUser() {
        if (userService.findByUsername("admin") == null) {
            User user = new User();
            user.setUsername("admin");
            PasswordEncoder encoder = new BCryptPasswordEncoder(11);
            user.setPassword(encoder.encode("admin"));
            user.setEnabled(true);
            Privilege privilege = new Privilege();
            privilege.setName("ADMIN");
            Set<Privilege> privileges = new HashSet<>();
            privileges.add(privilege);
            user.setPrivileges(privileges);

            userService.saveUser(user);
        }
        if (privilegeService.findByName(DEFAULT_USER) == null) {
            Privilege privilege = new Privilege();
            privilege.setName(DEFAULT_USER);

            privilegeService.save(privilege);
        }
    }

    @RequestMapping("/register")
    public ModelAndView regiserForm(ModelAndView modelAndView) {
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("registerForm");
        return modelAndView;
    }

    @RequestMapping("/confirmRegistration/{code}")
    public ModelAndView confirmRegistration(@PathVariable("code") String validationCode,
                                            ModelAndView modelAndView) {
        User user = userService.findByValidationCode(validationCode);
        String message;
        if (user != null) {
            if (user.getEnabled()) {
                message = "User allready confirmed.";
            } else {
                user.setEnabled(true);
                userService.saveUser(user);
                message = "Registration complete.";
            }
        } else {
            message = "Invalid code.";
        }
        modelAndView.addObject("message", message);
        modelAndView.setViewName("registerSuccess");
        return modelAndView;
    }

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid @ModelAttribute("user") User user,
                                     BindingResult bindingResult,
                                     ModelAndView modelAndView) throws MessagingException {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registerForm");
            return modelAndView;
        }
        User savedUser = userService.registerUser(user);
        modelAndView.addObject("eMail", savedUser.geteMail());
        modelAndView.addObject("validationCode", savedUser.getValidationCode());
        modelAndView.setViewName("registerSuccess");
        return modelAndView;
    }

    @RequestMapping("/home")
    public ModelAndView getHome(ModelAndView modelAndView) {
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping("/restricted")
    public ModelAndView getRestricted(ModelAndView modelAndView) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>)auth.getAuthorities();
        List<String> roles = new ArrayList<>();
        for (SimpleGrantedAuthority authority: authorities) {
            roles.add(authority.getAuthority());
        }
        modelAndView.addObject("username", auth.getName());
        modelAndView.addObject("roles", roles);
        modelAndView.setViewName("restricted");
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

}
