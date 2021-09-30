package com.register.pjt.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.register.pjt.Dto.ListArticle;
import com.register.pjt.model.Article;
import com.register.pjt.repository.ArticleRepository;

@Service
@Transactional
public class ArticleService {
	@Autowired
	ArticleRepository articleRepository;
 
	public List<ListArticle> getAll() {
    	return articleRepository.listArticle();	    	
    }
	
	
	
    public Optional<Article> findByCode(String code) {
        return articleRepository.findByCode(code);
    }
    
    public long save(Article article) {
    	Article art = new Article();
    	art.setCode(article.getCode());
    	art.setLibelle(article.getLibelle());
    	art.setCcateg(article.getCcateg());
    	art.setPa(article.getPa());
    	art.setPv(article.getPv());
    	art.setStock(article.getStock());
    	art.setTva(article.getTva());
    	art.setFileName(article.getFileName());
        return articleRepository.save(article)
                             .getId();
    }
    public void update(String code, Article article) {
        Optional<Article> artic = articleRepository.findByCode(code);
        if (artic.isPresent()) {
            Article art = artic.get();
            art.setLibelle(article.getLibelle());
	        art.setCcateg(article.getCcateg());
	        articleRepository.save(art);
        }
    }
  

    public List<Article> findByLibelle(String libelle) {
        return articleRepository.findAllByLibelleContaining(libelle);
    }

    public void delete(String code) {
        Optional<Article> art = articleRepository.findByCode(code);
        art.ifPresent(articleRepository::delete);
    }
	
    public List<Article> findByCcateg(String code) {
        return articleRepository.findAllByCcateg(code);
    }

    public List<Article> findByCscateg(String code) {
        return articleRepository.findAllByCscateg(code);
    }

	public int nbre(String code) {
		return articleRepository.nbre(code);
	}



	public int max(String code) {
		return articleRepository.max(code);
	}



	public Optional<Article> findById(Long id) {
		  return articleRepository.findById(id);
	}


}
