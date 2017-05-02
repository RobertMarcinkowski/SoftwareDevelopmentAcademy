package com.szymon;

import com.szymon.model.Image;
import com.szymon.model.Link;
import com.szymon.model.Product;
import com.szymon.model.User;
import com.szymon.repository.ImageRepository;
import com.szymon.repository.LinkRepository;
import com.szymon.repository.ProductRepository;
import com.szymon.repository.UserRepository;
import com.szymon.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private ImageRepository imageRepository;

    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void initDatabase() {
        User user = new User();
        user.setFirstName("Szymon");
        user.setLastName("Nowak");

        User user2 = new User();
        user2.setFirstName("Jan");
        user2.setLastName("Kowalski");

        User user3 = new User();
        user3.setFirstName("Andrzej");
        user3.setLastName("Duda");

        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);

//        linkRepository.save(new Link("About", "/home"));
//        linkRepository.save(new Link("Service", "/home"));
//        linkRepository.save(new Link("Contact", "/home"));
        linkRepository.save(new Link("Add", "/product-form"));
//        linkRepository.save(new Link("Login", "/login"));
        linkRepository.save(new Link("Logout", "/logout"));

        imageRepository.save(new Image("/home", "First Cat", "http://www.oregonhumane.org/wp-content/uploads/Find_Homes_For_Pets.jpg"));
        imageRepository.save(new Image("/home", "Third Cat", "http://www.friendsofbcas.org/sites/default/files/header%20barncat.jpg"));
        imageRepository.save(new Image("/home", "Fourth Cat", "http://groomiespet.com/wp-content/uploads/2015/07/cat.jpg"));

        Image smallImage = new Image("http://1.bp.blogspot.com/-bqJPGSx7ENU/VaL620oawgI/AAAAAAAAFqY/y1PXHn4clB8/s1600/CatWinterLucky.jpg", "siberian cat", "http://1.bp.blogspot.com/-bqJPGSx7ENU/VaL620oawgI/AAAAAAAAFqY/y1PXHn4clB8/s1600/CatWinterLucky.jpg");
        Image bigImage = new Image("http://zoomia.pl/files/i/10/74/koty-sprzedam-maine-coon_big21560_10745773451331497885.jpg?galeria", "Siberian cat", "http://zoomia.pl/files/i/10/74/koty-sprzedam-maine-coon_big21560_10745773451331497885.jpg?galeria");

        Image smallImage1 = new Image("http://1.bp.blogspot.com/-bqJPGSx7ENU/VaL620oawgI/AAAAAAAAFqY/y1PXHn4clB8/s1600/CatWinterLucky.jpg", "siberian cat", "http://1.bp.blogspot.com/-bqJPGSx7ENU/VaL620oawgI/AAAAAAAAFqY/y1PXHn4clB8/s1600/CatWinterLucky.jpg");
        Image bigImage1 = new Image("http://zoomia.pl/files/i/10/74/koty-sprzedam-maine-coon_big21560_10745773451331497885.jpg?galeria", "Siberian cat", "http://zoomia.pl/files/i/10/74/koty-sprzedam-maine-coon_big21560_10745773451331497885.jpg?galeria");

        Image smallImage2 = new Image("http://1.bp.blogspot.com/-bqJPGSx7ENU/VaL620oawgI/AAAAAAAAFqY/y1PXHn4clB8/s1600/CatWinterLucky.jpg", "siberian cat", "http://1.bp.blogspot.com/-bqJPGSx7ENU/VaL620oawgI/AAAAAAAAFqY/y1PXHn4clB8/s1600/CatWinterLucky.jpg");
        Image bigImage2 = new Image("http://www.oregonhumane.org/wp-content/uploads/Find_Homes_For_Pets.jpg", "Siberian cat", "http://www.oregonhumane.org/wp-content/uploads/Find_Homes_For_Pets.jpg");

        Image smallImage3 = new Image("http://1.bp.blogspot.com/-bqJPGSx7ENU/VaL620oawgI/AAAAAAAAFqY/y1PXHn4clB8/s1600/CatWinterLucky.jpg", "siberian cat", "http://1.bp.blogspot.com/-bqJPGSx7ENU/VaL620oawgI/AAAAAAAAFqY/y1PXHn4clB8/s1600/CatWinterLucky.jpg");
        Image bigImage3 = new Image("http://zoomia.pl/files/i/10/74/koty-sprzedam-maine-coon_big21560_10745773451331497885.jpg?galeria", "Siberian cat", "http://zoomia.pl/files/i/10/74/koty-sprzedam-maine-coon_big21560_10745773451331497885.jpg?galeria");

        productRepository.save(new Product("Siberian cat", "Cats. This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 25.0, smallImage, bigImage, "cats"));
        productRepository.save(new Product("Siberian cat", "Cats. This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 25.0, smallImage1, bigImage1, "cats"));
        productRepository.save(new Product("Siberian cat", "Dogs. This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 25.0, smallImage2, bigImage2, "dogs"));
        productRepository.save(new Product("Siberian cat", "Dogs. This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 25.0, smallImage3, bigImage3, "dogs"));
    }
}
