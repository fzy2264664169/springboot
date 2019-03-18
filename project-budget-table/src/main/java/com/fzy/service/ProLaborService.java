package com.fzy.service;

import java.util.List;

import com.fzy.domain.ProLabor;

public interface ProLaborService {

	public void insertProLabor(ProLabor proLabor);
	
	public List<ProLabor> findAll();
}
