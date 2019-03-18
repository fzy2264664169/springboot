package com.fzy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.domain.ProCost;
import com.fzy.mapper.ProCostMapper;
import com.fzy.service.ProCostService;
@Service
public class ProCostServiceImpl implements ProCostService {

	@Autowired
	private ProCostMapper proCostMapper;
	@Override
	public void insertProCost(ProCost proCost) {
		// TODO Auto-generated method stub
		proCostMapper.insertProCost(proCost);
	}

	@Override
	public List<ProCost> findAll() {
		// TODO Auto-generated method stub
		return proCostMapper.findAll();
	}

}
