package com.fzy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fzy.domain.ProInfo;
import com.fzy.mapper.ProInfoMapper;
import com.fzy.service.ProInfoService;
@Service
public class ProInfoServiceImpl implements ProInfoService {

	@Autowired
	private ProInfoMapper proInfoMapper;
	@Override
	public List<ProInfo> findAll() {
		// TODO Auto-generated method stub
		return proInfoMapper.findAll();
	}

	@Override
	public ProInfo findById(int id) {
		// TODO Auto-generated method stub
		return proInfoMapper.findById(id);
	}

	@Override
	public void insertProInfo(ProInfo proInfo) {
		// TODO Auto-generated method stub
		proInfoMapper.insertProInfo(proInfo);
	}

}
