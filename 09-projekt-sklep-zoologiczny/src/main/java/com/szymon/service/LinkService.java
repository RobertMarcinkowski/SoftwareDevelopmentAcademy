package com.szymon.service;

import com.szymon.model.Link;
import com.szymon.model.User;
import com.szymon.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;

    public List<Link> fetchLinks(final Principal principal) {
//        List<Link> list = new ArrayList<>();
//        list.add(new Link("About", "/home"));
//        list.add(new Link("Service", "/home"));
//        list.add(new Link("Contact", "/home"));
//        return list;

        List<Link> links = new ArrayList<>();
        Iterable<Link> iterable = linkRepository.findAll();
        iterable.forEach(links::add);
        if (principal == null) {
            links.remove(1);
        }
        return links;
    }

}
