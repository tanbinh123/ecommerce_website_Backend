package com.register.pjt.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.register.pjt.Dto.ListCategorie;
import com.register.pjt.model.Scategorie;
import com.register.pjt.repository.ScategorieRepository;

@Service 
@Transactional
public class ScategorieService {
	@Autowired
	ScategorieRepository scategorieRepository ;
	
	/**
	 * 
	 * @return all SCategories
	 */
	public List<ListCategorie> getAll() {
		return  scategorieRepository.listScateg();
	}
	
	/**
	 * 
	 * @param id
	 * @return user by id
	 */
	public Optional<Scategorie> getByCode(String code) {

		return  scategorieRepository.findByCode(code);
	}
	
	
	/**
	 * add  user
	 */
	public long save(Scategorie scategorie) {
		Scategorie scat = new Scategorie();
		scat.setCode(scategorie.getCode());
		scat.setLibelle(scategorie.getLibelle());
		scat.setCcateg(scategorie.getCcateg());
		scat.setRang(1);
		return scategorieRepository.save(scat).getId();
		
	}
	
	
	/**
	 * 
	 * @param id
	 * @param User
	 * updateOrsave user
	 */
	public void update(String code, Scategorie scategorie) {
		
		Optional<Scategorie> scateg = scategorieRepository.findByCode(code);
		
		if(scateg.isPresent()) {
			
			Scategorie scat = scateg.get();
			scat.setLibelle(scategorie.getLibelle());
			scat.setCcateg(scategorie.getCcateg());
			scategorieRepository.save(scat);
			
		}
	}

	/**
	 * 
	 * @param libelle
	 * @return list scateg by libelle
	 */
	public List<Scategorie> getByLibelle(String libelle) {
		return  scategorieRepository.findAllByLibelleContaining(libelle);
	}

	/**
	 * 
	 * @param id
	 * user deleted
	 */
	public void delete(String code) {
		Optional<Scategorie> cat = scategorieRepository.findByCode(code);
		cat.ifPresent(scategorieRepository::delete);
	}
	/**
	 * 
	 * @param ccateg
	 * @return list scateg by scateg 
	 */
	public List<Scategorie> getByCcateg(String code) {
		return  scategorieRepository.findAllByCcateg(code);
	}

	/**
	 * 
	 * @param code
	 * @return nbre categ
	 */
	public int nbre(String code) {
		return scategorieRepository.nbre(code);
	}


	/**
	 * 
	 * @param code
	 * @return max code
	 */
	public int max(String code) {
		return scategorieRepository.max(code);
	}
	
}
