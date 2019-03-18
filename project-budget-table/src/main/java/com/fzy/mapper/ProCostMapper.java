package com.fzy.mapper;

import java.util.List;

import com.fzy.domain.ProCost;

public interface ProCostMapper {

	public void insertProCost(ProCost proCost);
	
	public List<ProCost> findAll();
	
	public ProCost findByRefId(String refId);
	
	public void deleteProCost(String refId);
}
