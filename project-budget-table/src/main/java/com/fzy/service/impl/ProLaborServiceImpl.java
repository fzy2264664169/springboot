package com.fzy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.domain.ProLabor;
import com.fzy.mapper.ProLaborMapper;
import com.fzy.service.ProLaborService;
@Service
public class ProLaborServiceImpl implements ProLaborService {

	@Autowired
	private ProLaborMapper proLaborMapper;
	@Override
	public void insertProLabor(ProLabor proLabor) {
		// TODO Auto-generated method stub
		proLaborMapper.insertProLabor(proLabor);
	}

	@Override
	public List<ProLabor> findAll() {
		// TODO Auto-generated method stub
		return proLaborMapper.findAll();
	}

}
