package com.fzy.mapper;

import java.util.List;

import com.fzy.domain.ProLabor;

public interface ProLaborMapper {

	public void insertProLabor(ProLabor proLabor);
	
	public List<ProLabor> findAll();
	
	public List<ProLabor> findById(int id);
	
	public List<ProLabor> findByRefId(String refId);
	
	public void deleteProLabor(String refId);
}
