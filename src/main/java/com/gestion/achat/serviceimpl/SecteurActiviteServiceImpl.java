package com.gestion.achat.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.achat.entity.SecteurActivite;
import com.gestion.achat.repository.SecteurActiviteRepository;
import com.gestion.achat.service.SecteurActiviteService;

@Service
public class SecteurActiviteServiceImpl implements SecteurActiviteService {
	
	
	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;

	@Override
	public List<SecteurActivite> retrieveAllSecteurActivites() {
		
		return secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActivite addSecteurActivite(SecteurActivite sa) {
		
		return secteurActiviteRepository.save(sa);
	}

	@Override
	public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
		
		return secteurActiviteRepository.save(sa);
	}

	@Override
	public SecteurActivite retrieveSecteurActivite(Long id) {
		
		return secteurActiviteRepository.findById(id).orElse(null);
	}

	@Override
	public void removeSecteurActivite(Long id) {
		SecteurActivite secteurActivite = secteurActiviteRepository.findById(id).orElse(null);
		secteurActiviteRepository.delete(secteurActivite);
		
	}

}
