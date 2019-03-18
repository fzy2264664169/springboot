package com.fzy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.domain.InfoPtype;
import com.fzy.mapper.InfoPtypeMapper;
import com.fzy.service.InfoPtypeService;

@Service
public class InfoPtypeServiceImpl implements InfoPtypeService {

	@Autowired
	private InfoPtypeMapper infoPtypeMapper;
	
	@Override
	public InfoPtype findById(int id) {
		// TODO Auto-generated method stub
		return infoPtypeMapper.findById(id);
	}

	@Override
	public List<InfoPtype> findAll() {
		// TODO Auto-generated method stub
		return infoPtypeMapper.findAll();
	}

}
