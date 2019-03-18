package com.fzy.service;

import java.util.List;

import com.fzy.domain.ProInfo;

public interface ProInfoService {

	public List<ProInfo> findAll();
	
	public ProInfo findById(int id);
	
	public void insertProInfo(ProInfo proInfo);
}
