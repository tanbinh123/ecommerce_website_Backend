package com.register.pjt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.register.pjt.model.Categorie;

import com.register.pjt.repository.CategorieRepository;
@Service 
@Transactional
public class CategorieService {
	
	@Autowired
	CategorieRepository categorieRepository ;
	
	/**
	 * 
	 * @return all Categories
	 */
	public List<Categorie> getAll() {
		return  categorieRepository.findAll(Sort.by("libelle").ascending());
	}
	
	/**
	 * 
	 * @param id
	 * @return user by id
	 */
	public Optional<Categorie> findById(String code) {

		return  categorieRepository.findByCode(code);
	}
	
	
	/**
	 * save user
	 */
	public long save(Categorie categorie) {
		Categorie cat = new Categorie();
		cat.setCode(categorie.getCode());
		cat.setLibelle(categorie.getLibelle());
		
		return categorieRepository.save(cat).getId();
		
	}
	
	/**
	 * 
	 * @param id
	 * @param User
	 * updateOrsave user
	 */
	public void update(String code, Categorie categorie) {
		
		Optional<Categorie> categ = categorieRepository.findByCode(code);
		
		if(categ.isPresent()) {
			
			Categorie cat = categ.get();
			cat.setLibelle(categorie.getLibelle());
			
			categorieRepository.save(cat);
			
		}
	}

	
	public List<Categorie> findByLibelle(String libelle) {
		return  categorieRepository.findAllByLibelleContaining(libelle);
	}
	
	/**
	 * 
	 * @param id
	 * user deleted
	 */
	public void delete(String code) {
		Optional<Categorie> cat = categorieRepository.findByCode(code);
		cat.ifPresent(categorieRepository::delete);
	}
	/**
	 * 
	 * @return appeler la methode max dans repo
	 */
	public int max() {
		return categorieRepository.max();
	}
	/**
	 * 
	 * @return appeler le nbre des elments dans repo 
	 */
	public int nbre() {
		return categorieRepository.nbre();
	}
	
	
}
