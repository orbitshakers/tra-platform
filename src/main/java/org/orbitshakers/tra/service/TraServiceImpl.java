package org.orbitshakers.tra.service;

import java.util.List;
import java.util.stream.Collectors;

import org.orbitshakers.tra.domain.Domain;
import org.orbitshakers.tra.entity.DomainEntity;
import org.orbitshakers.tra.repo.DomainRepo;
import org.orbitshakers.tra.transformer.DomainTrans;
import org.orbitshakers.tra.transformer.Transformer;
import org.springframework.stereotype.Service;

@Service
public class TraServiceImpl implements TraService{

	private Transformer<DomainEntity, Domain> domainTransformer = new DomainTrans();
	private final DomainRepo repo;

	public TraServiceImpl(DomainRepo repo) {

		this.repo = repo;
	}

	public List<Domain> findAllDomains() {
		List<DomainEntity> entityIter = repo.findAllByOrderByIdDesc();
		
		return entityIter.stream().map(domainTransformer::transform)
				.collect(Collectors.toList());
	}
	
	

}
