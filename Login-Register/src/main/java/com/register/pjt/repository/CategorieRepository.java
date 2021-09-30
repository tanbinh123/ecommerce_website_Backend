package com.register.pjt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.register.pjt.model.Categorie;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie,Long>{

	Optional<Categorie> findByCode(String code);

	List<Categorie> findAllByLibelleContaining(String libelle);
	/**
	 * 
	 * @return envoyer le nbre des categorie
	 */
	@Query(value = "SELECT count(code) FROM Categorie")
	public int nbre();
	/**
	 * 
	 * @return max code +1
	 * on lance ssi on a des elts
	 */
	@Query(value = "SELECT max(code) FROM Categorie")
	public int max();
}
