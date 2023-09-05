package com.gestion.achat.service;

import java.util.List;

import com.gestion.achat.entity.SecteurActivite;

public interface SecteurActiviteService {
	
	List<SecteurActivite> retrieveAllSecteurActivites();
	SecteurActivite addSecteurActivite(SecteurActivite sa);
	SecteurActivite updateSecteurActivite(SecteurActivite sa);
	SecteurActivite retrieveSecteurActivite(Long id);
	void removeSecteurActivite(Long id);

}
