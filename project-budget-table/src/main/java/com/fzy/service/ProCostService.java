package com.fzy.service;

import java.util.List;

import com.fzy.domain.ProCost;

public interface ProCostService {

	public void insertProCost(ProCost proCost);
	
	public List<ProCost> findAll();
}
