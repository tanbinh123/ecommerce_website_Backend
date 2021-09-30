package com.register.pjt.service;


/*import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.register.pjt.model.Client;
import com.register.pjt.model.User;
import com.register.pjt.repository.ClientRepository;*/
/*
@Service 
@Transactional*/
public class ClientService {
	/*@Autowired
	ClientRepository  delivaryManRepository;

	public List<Client> getAll() {
		System.out.println("Get all Users...");
		return  delivaryManRepository.findAll(Sort.by("nameD").ascending());
	}

	public Optional<Client> findById(long id) {
		return  delivaryManRepository.findById(id);
	}

	public Optional<Client> login(String name) {
		return delivaryManRepository.findByNameD(name);
	}

	public long save(Client DelivaryMan) {
		System.out.println("delivaryMan...");
		Client delivaryMan= new Client();
		
		delivaryMan.setCode(DelivaryMan.getCode());
		delivaryMan.setNameD(DelivaryMan.getNameD());
		delivaryMan.setLibelle(DelivaryMan.getLibelle());
		delivaryMan.setAdresse(DelivaryMan.getAdresse());
		delivaryMan.setEmail(DelivaryMan.getEmail());
		delivaryMan.setLogin(DelivaryMan.getLogin());
		delivaryMan.setPassword(DelivaryMan.getPassword());
		delivaryMan.setTel(DelivaryMan.getTel());
		
		return delivaryManRepository.save(delivaryMan).getId();
	}
	
	

	public void update(long id, Client DelivaryMan) {
		
		Optional<Client> deliveryup = delivaryManRepository.findById(id);
		
		if(deliveryup.isPresent()) {
			
			Client delivaryMan =deliveryup.get();
			
			//delivaryMan.setNameD(DelivaryMan.getNameD());
			delivaryMan.setLibelle(DelivaryMan.getLibelle());
			delivaryMan.setAdresse(DelivaryMan.getAdresse());
			delivaryMan.setEmail(DelivaryMan.getEmail());
			delivaryMan.setLogin(DelivaryMan.getLogin());
			//delivaryMan.setPassword(DelivaryMan.getPassword());
			delivaryMan.setTel(DelivaryMan.getTel());
			
			delivaryManRepository.save(delivaryMan);
			
		}
		
	}

	public void delete(Long id) {
		Optional<Client> delivaryMan = delivaryManRepository.findById(id);
		delivaryMan.ifPresent(delivaryManRepository::delete);
		
	}*/

}
