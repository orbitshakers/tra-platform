package org.orbitshakers.tra.service;

import java.util.List;
import java.util.stream.Collectors;

import org.orbitshakers.tra.domain.Domain;
import org.orbitshakers.tra.entity.ConceptEntity;
import org.orbitshakers.tra.entity.DomainEntity;
import org.orbitshakers.tra.repo.ConceptRepo;
import org.orbitshakers.tra.repo.DomainRepo;
import org.orbitshakers.tra.transformer.DomainTrans;
import org.orbitshakers.tra.transformer.Transformer;
import org.springframework.stereotype.Service;

@Service
public class TraServiceImpl implements TraService{

	private Transformer<DomainEntity, Domain> domainTransformer = new DomainTrans();
	private final DomainRepo repo;
	private final ConceptRepo conceptRepo;

	public TraServiceImpl(DomainRepo repo, ConceptRepo conceptRepo) {

		this.repo = repo;
		this.conceptRepo = conceptRepo;
	}

	public List<Domain> findAllDomains() {
		List<DomainEntity> entityList = repo.findAllByOrderBySortOrderAsc();
		
		return entityList.stream().map(domainTransformer::transform)
				.collect(Collectors.toList());
	}
	
	public List<Domain> findAllConceptsByDomainId() {
		List<DomainEntity> domEntityList = repo.findAllByOrderBySortOrderAsc();
		
		
		for (DomainEntity de : domEntityList) {
			List<ConceptEntity> conceptList = conceptRepo.findAllByDomainId(de.id);
		}
		return domEntityList.stream().map(domainTransformer::transform)
				.collect(Collectors.toList());
	}
		

}
