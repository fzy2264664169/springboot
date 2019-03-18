package com.fzy.service;

import java.util.List;

import com.fzy.domain.InfoPtype;

public interface InfoPtypeService {

	public InfoPtype findById(int id);
	public List<InfoPtype> findAll();
}
