package com.gestion.achat.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.achat.entity.Operateur;
import com.gestion.achat.repository.OperateurRepository;
import com.gestion.achat.service.OperateurService;


@Service
public class OperateurServiceImpl implements OperateurService{
	
	@Autowired
	OperateurRepository operateurRepository;

	@Override
	public List<Operateur> retrieveAllOperateurs() {
		
		return operateurRepository.findAll();
	}

	@Override
	public Operateur addOperateur(Operateur o) {

		return operateurRepository.save(o);
	}

	@Override
	public Operateur upOperateur(Operateur o) {
		
		return operateurRepository.save(o);
	}

	@Override
	public Operateur retrieveOperateur(Long id) {
		
		return operateurRepository.findById(id).orElse(null);
	}

	@Override
	public void removeOperateur(Long id) {
		Operateur o = operateurRepository.findById(id).orElse(null);
		operateurRepository.delete(o);
		
	}

}
