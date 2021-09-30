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

import com.register.pjt.model.Categorie;

import com.register.pjt.service.CategorieService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CategorieController {

	
	@Autowired
	private CategorieService categorieService ;
	
	
	/**
	 * 
	 * @return list of users
	 */
	@GetMapping("/categories")
	public List<Categorie> list(){
		
		return categorieService.getAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return findById
	 */
	@GetMapping("/categories/{id}")
	public ResponseEntity<Categorie> post(@PathVariable String id){
		Optional<Categorie> cat = categorieService.findById(id);
		return cat.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.notFound()
						.build());
	}
	
	
	/**
	 * 
	 * @param User
	 * @return save
	 */
	
	@PostMapping("/categories")
	public long save(@RequestBody Categorie categorie) {
		return categorieService.save(categorie);
	}
	
	/**
	 * 
	 * @param id
	 * @param User
	 * updated user
	 */
	@PutMapping("/categories/{id}")
	public void update(@PathVariable String id, @RequestBody Categorie categorie){
		Optional<Categorie> post = categorieService.findById(id);
		if (post.isPresent()) {
			categorieService.update(id,categorie);
		}else {
			categorieService.save(categorie);
		}
	}
	
	/**
	 * 
	 * @param id
	 * deleted user
	 */
	@DeleteMapping("/categories/{id}")
	public void delete(@PathVariable String id){
		categorieService.delete(id);
	}
	/**
	 * afficher le code catego
	 */
	@GetMapping("/categories/7")
	public int getCode() {
		int x = categorieService.nbre();
		System.out.println(x);
		if (x==0) {
			return 0;
		}
		else {
			return categorieService.max();
		}
	}
}
