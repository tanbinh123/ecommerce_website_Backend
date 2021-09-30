package com.register.pjt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.register.pjt.Dto.ListCategorie;
import com.register.pjt.model.Scategorie;
import com.register.pjt.service.ScategorieService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ScategorieController {
	
	@Autowired
	private ScategorieService scategorieService ;
	
	
	/**
	 * 
	 * @return list of users
	 */
	@GetMapping("/scategories")
	public List<ListCategorie> list(){
		return scategorieService.getAll();
	}
	
	/**
	 * 
	 * @param id
	 * @return findById recuperer scategorie by code
	 */
	@GetMapping("/scategories/{code}")
	public ResponseEntity<Scategorie> post(@PathVariable String code){
		Optional<Scategorie> scat = scategorieService.getByCode(code);
		return scat.map(ResponseEntity::ok)
				.orElseGet(()->ResponseEntity.notFound()
						.build());
	}
	/**
	 * 
	 * @param code
	 * @return find les scateg by code categ
	 */
	@GetMapping("/scategories/5/{code}")
	public ResponseEntity<List<Scategorie>> listCateg(@PathVariable String code){
		List<Scategorie> scategories = scategorieService.getByCcateg(code);
		return new ResponseEntity<List<Scategorie>>(scategories, HttpStatus.OK);
				
	}
	
	/**
	 * 
	 * @param User
	 * @return add scateg
	 */
	
	@PostMapping("/scategories")
	public long save(@RequestBody Scategorie scategorie) {
		return scategorieService.save(scategorie);
	}
	
	/**
	 * 
	 * @param id
	 * @param User
	 * updated user
	 */
	@PutMapping("/scategories/{id}")
	public void update(@PathVariable String code, @RequestBody Scategorie scategorie){
		Optional<Scategorie> scat = scategorieService.getByCode(code);
		if (scat.isPresent()) {
			scategorieService.update(code,scategorie);
		}else {
			scategorieService.save(scategorie);
		}
	}
	
	/**
	 * 
	 * @param id
	 * deleted user
	 */
	@DeleteMapping("/scategories/{id}")
	public void delete(@PathVariable String id){
		scategorieService.delete(id);
	}
	/**
	 * 
	 * @param code
	 * @return recuperer max code 
	 */
	 @GetMapping("/scategories/7/{code}")
	 public  int getCode(@PathVariable String code) {
		 
		 int  x = scategorieService.nbre(code);
		 System.out.println(x);
		 if (x == 0)
		 {
			 return 0;
		 }
		 else
		 {
			 return scategorieService.max(code);
		 }
	 }
}
