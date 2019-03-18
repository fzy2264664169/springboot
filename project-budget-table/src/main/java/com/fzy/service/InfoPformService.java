package com.fzy.service;

import java.util.List;

import com.fzy.domain.InfoPform;

public interface InfoPformService {

	public List<InfoPform> findAll();
	public InfoPform findById(int id);
}
