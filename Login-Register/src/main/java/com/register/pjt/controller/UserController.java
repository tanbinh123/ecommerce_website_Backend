package com.register.pjt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.pjt.model.User;
import com.register.pjt.service.UserService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService ;
	/**
	 * 
	 * @return list of users
	 */
	@GetMapping("/users")
	public List<User> list(){
		return userService.getAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return findById
	 */
	@GetMapping("/users/{id}")
	public ResponseEntity<User> post(@PathVariable long id){
		Optional<User> cat = userService.findById(id);
		return cat.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.notFound()
						.build());
	}
	
	/**
	 * 
	 * @param name
	 * @return login se loger a partir de mon username
	 */
	@GetMapping("/users/auth/{name}")
	public ResponseEntity<User> login(@PathVariable String name){
		Optional<User> cat = userService.login(name);
		return cat.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.notFound()
						.build());
	}
	/**
	 * 
	 * @param User
	 * @return save
	 */
	
	@PostMapping("/users")
	public long save(@RequestBody User User) {
		return userService.save(User);
	}
	
	/**
	 * 
	 * @param id
	 * @param User
	 * updated user
	 */
	@PutMapping("/users/{id}")
	public void update(@PathVariable long id, @RequestBody User User){
		Optional<User> user = userService.findById(id);
		if (user.isPresent()) {
			userService.update(id,User);
		}else {
			userService.save(User);
		}
	}
	
	/**
	 * 
	 * @param id
	 * deleted user
	 */
	@DeleteMapping("/users/{id}")
	public void delete(@PathVariable Long id){
		userService.delete(id);
	}
}
