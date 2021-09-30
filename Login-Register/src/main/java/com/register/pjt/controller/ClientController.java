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

//import com.register.pjt.model.Client;

//import com.register.pjt.service.ClientService;


/*@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")*/
public class ClientController {

	/*@Autowired
	private ClientService delivaryManService ;*/
	/**
	 * 
	 * @return list of users
	 */
	/*@GetMapping("/delivarys")
	public List<Client> list(){
		System.out.println("Get all DelivaryMan...");
		return delivaryManService.getAll();
	}*/
	/**
	 * 
	 * @param id
	 * @return findById
	 */
	/*@GetMapping("/delivarys/{id}")
	public ResponseEntity<Client> post(@PathVariable long id){
		Optional<Client> delm = delivaryManService.findById(id);
		return delm.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.notFound()
						.build());
	}*/
	/**
	 * 
	 * @param name
	 * @return login se loger a partir de mon username
	 */
	/*@GetMapping("/delivarys/auth/{nameD}")
	public ResponseEntity<Client> login(@PathVariable String nameD){
		Optional<Client> delm = delivaryManService.login(nameD);
		return delm.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.notFound()
						.build());
	}*/
	/**
	 * 
	 * @param User
	 * @return save
	 */
	
	/*@PostMapping("/delivarys")
	public long save(@RequestBody Client DelivaryMan) {
		return delivaryManService.save(DelivaryMan);
	}*/
	
	/**
	 * 
	 * @param id
	 * @param User
	 * updated user
	 */
	/*@PutMapping("/delivarys/{id}")
	public void update(@PathVariable long id, @RequestBody Client DelivaryMan){
		Optional<Client> delivaryMan = delivaryManService.findById(id);
		if (delivaryMan.isPresent()) {
			delivaryManService.update(id,DelivaryMan);
		}else {
			delivaryManService.save(DelivaryMan);
		}
	}*/
	
	/**
	 * 
	 * @param id
	 * deleted user
	 */
	/*@DeleteMapping("/delivarys/{id}")
	public void delete(@PathVariable Long id){
		delivaryManService.delete(id);
	}*/
}
