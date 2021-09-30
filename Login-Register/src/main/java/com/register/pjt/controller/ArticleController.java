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

import com.register.pjt.Dto.ListArticle;
import com.register.pjt.model.Article;
import com.register.pjt.service.ArticleService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ArticleController {
	@Autowired
    private ArticleService articleService;
	
	 /**
	  * recuperer la liste des articles
	  */
	 @GetMapping("/articles")
	 public List<ListArticle> list() {
	             return articleService.getAll();
	   }
	   	 
	
	 @GetMapping("/articles/{code}")
	 public ResponseEntity<Article> post(@PathVariable String code) {
	        Optional<Article> art = articleService.findByCode(code);
	        return art.map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.notFound()
	                                              .build());
	    }
	 
	 /**
		 * 
		 * @param code
		 * @return find les scateg by code categ
		 */
		@GetMapping("/articles/5/{code}")
		public ResponseEntity<List<Article>> listArticle(@PathVariable String code){
			List<Article> articles = articleService.findByCcateg(code);
			return new ResponseEntity<List<Article>>(articles, HttpStatus.OK);
					
		}
		
	 /**
		 * 
		 * @param User
		 * @return save
	 */
		
		@PostMapping("/articles")
		public long save(@RequestBody Article article) {
			return articleService.save(article);
		}
	 
	 /*@PostMapping("/articles")
	 public long createArticle (
			 @RequestParam("file") MultipartFile file, 
			 @RequestParam("article") String article) 
	 
					 throws JsonParseException , JsonMappingException , Exception {
		 
		 Article arti = new ObjectMapper().readValue(article, Article.class);
		 boolean isExit = new File(context.getRealPath("/Images/")).exists();
			    
			    if (!isExit){
			    	new File (context.getRealPath("/Images/")).mkdir();
			    	System.out.println("mk dir Images.............");
			    }
			    
			    System.out.println("Save Article  22222.............");
			    
			    String filename = file.getOriginalFilename();
			    String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
			    File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
			    
			    try {
			    	System.out.println("Image");
			    	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
			    }
			    catch(Exception e) { e.printStackTrace(); }
			    
			    System.out.println("Save Article 333333.............");
			    arti.setFileName(newFileName);
			    
			    return articleService.save(arti);
	 }*/
	 
	 
	  @PutMapping("/articles/{id}")
	    public void update(@PathVariable String code, @RequestBody Article Article) {
	        Optional<Article> cat = articleService.findByCode(code);
	        if (cat.isPresent()) {
	            articleService.update(code, Article);
	    
	        }
	        else {
	        	articleService.save(Article);
	        }
	    }
	
	    @DeleteMapping("/articles/{code}")
	    public void delete(@PathVariable String code) {
	        articleService.delete(code);
	    }
	   /*  
	   @GetMapping(path="/Imgarticles/{id}")
		 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
			 Article Article   =articleService.findById(id).get();
			 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+Article.getFileName()));
		 }*/
	    
	    /**
		 * @param code
		 * @return generer code article
		 */
		 @GetMapping("/articles/7/{code}")
		 public  int getCode(@PathVariable String code) {
			 int  x = articleService.nbre(code);
			 System.out.println(x);
			 if (x == 0)
			 {
				 return 0;
			 }
			 else
			 {
				 return  articleService.max(code);
			 }
		 }
}
