package com.register.pjt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.register.pjt.model.User;
import com.register.pjt.repository.UserRepository;
@Service 
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepository;

	/**
	 * 
	 * @return all users
	 */
	public List<User> getAll() {
		return  userRepository.findAll(Sort.by("username").ascending());
	}
	
	/**
	 * 
	 * @param id
	 * @return user by id
	 */
	public Optional<User> findById(long id) {

		return  userRepository.findById(id);
	}
	
	/**
	 * save user
	 */
	public long save(User User) {
		
		User user= new User();
		user.setUsername(User.getUsername());
		user.setEmail(User.getEmail());
		user.setPassword(User.getPassword());
		user.setRole(User.getRole());
		user.setActive(true);
		return userRepository.save(user).getId();
		
	}
	/**
	 * 
	 * @param id
	 * @param User
	 * updateOrsave user
	 */
	public void update(long id, User User) {
		Optional<User> userr = userRepository.findById(id);
		if(userr.isPresent()) {
			User user =userr.get();
			user.setUsername(User.getUsername());
			user.setEmail(User.getEmail());
			user.setPassword(User.getPassword());
			user.setRole(User.getRole());
			user.setActive(User.isActive());
			userRepository.save(user);
			
		}
	}

	/**
	 * 
	 * @param name
	 * @return user by name
	 * aller dans repo
	 */
	public Optional<User> login(String name) {
		
		return userRepository.findByUsername(name);
	}

	/**
	 * 
	 * @param id
	 * user deleted
	 */
	public void delete(Long id) {
		Optional<User> user = userRepository.findById(id);
		user.ifPresent(userRepository::delete);
	}

}
