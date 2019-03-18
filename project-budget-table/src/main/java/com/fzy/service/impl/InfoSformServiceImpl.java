package com.fzy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.domain.InfoSform;
import com.fzy.mapper.InfoSformMapper;
import com.fzy.service.InfoSformService;
@Service
public class InfoSformServiceImpl implements InfoSformService {

	
	@Autowired
	private InfoSformMapper infoSformMapper;
	@Override
	public List<InfoSform> findAll() {
		// TODO Auto-generated method stub
		return infoSformMapper.findAll();
	}

	@Override
	public InfoSform findById(int id) {
		// TODO Auto-generated method stub
		return infoSformMapper.findById(id);
	}

}
