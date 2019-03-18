package com.fzy.service;

import java.util.List;

import com.fzy.domain.InfoSform;

public interface InfoSformService {

	public List<InfoSform> findAll();
	
	public InfoSform findById(int id);
}
