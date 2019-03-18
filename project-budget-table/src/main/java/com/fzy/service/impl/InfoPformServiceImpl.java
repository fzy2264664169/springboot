package com.fzy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.domain.InfoPform;
import com.fzy.mapper.InfoPformMapper;
import com.fzy.service.InfoPformService;

@Service
public class InfoPformServiceImpl implements InfoPformService {

	@Autowired
	private InfoPformMapper infoPformMapper;
	
	@Override
	public List<InfoPform> findAll() {
		// TODO Auto-generated method stub
		return infoPformMapper.findAll();
	}

	@Override
	public InfoPform findById(int id) {
		// TODO Auto-generated method stub
		return infoPformMapper.findById(id);
	}

}
