package sdacademy.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import sdacademy.User;

@Controller
public class UserController {
	
	
	@GetMapping(path="/hello")
	public ResponseEntity<String> test(){
		return  new ResponseEntity<String>("Hello world!", HttpStatus.OK);
		
	}
	
	@GetMapping(path="/user")
	public ResponseEntity<User> user(){
		User u = new User("Jan", "Nowak", 25);
		
		return new ResponseEntity<>(u, HttpStatus.OK) ;
		
	}
	
	@GetMapping(path="/userList")
	public ResponseEntity<List<User>> userList(){
		

		return new ResponseEntity<>(userList, HttpStatus.OK) ;
		
	}
	
	@GetMapping(path="/getUser/{id}")
	public ResponseEntity<User> userList(@PathVariable("id") int naszeId){
		
		return new ResponseEntity<>(userList.get(naszeId), HttpStatus.OK) ;
		
	}
	
	List<User> userList = new ArrayList<User>();

	
	@GetMapping(path="/addUser/{name}/{lastName}/{wiek}")
	public ResponseEntity<String> dodajUzytkownika(@PathVariable("name") String name,
			@PathVariable("lastName") String lastName, 
			@PathVariable("wiek") int wiek){
		
		userList.add(new User(name, lastName, wiek));
		
		return new ResponseEntity<>("Dodano", HttpStatus.OK) ;
		
	}
	
	@PostMapping(path="/addUser")
	public ResponseEntity<String> dodajUzytkownika(@RequestBody User user){
		userList.add(user);
		
		return new ResponseEntity<>("Dodano", HttpStatus.OK) ;
		
	}
	
	@GetMapping(path="/deleteUser/{id}")
	public ResponseEntity<String> deleteList(@PathVariable("id") int naszeId){
		User u = userList.get(naszeId);
		userList.remove(naszeId);
		return new ResponseEntity<>("Usunieto: "+u.getFirstName()+" "+u.getLastName(), HttpStatus.OK) ;
		
	}
	
	@PostMapping(path="/editUser/{id}")
	public ResponseEntity<String> deleteList(@PathVariable("id") int naszeId, @RequestBody User user){
		User u = userList.get(naszeId);
		u.setAge(user.getAge());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		
		userList.remove(naszeId);
		userList.add(u);
		return new ResponseEntity<>("Edycja uzytkownika: "+u.getFirstName()+" "+u.getLastName(), HttpStatus.OK) ;
		
	}
	
	

}
