package com.fzy.mapper;

import java.util.List;

import com.fzy.domain.ProInfo;

public interface ProInfoMapper {

	public void insertProInfo(ProInfo proInfo);
	
	public void deleteProInfo(String refId);
	
	public ProInfo updateProInfo(int id);
	
	public List<ProInfo> findAll();
	
	public ProInfo findById(int id);
	
	public ProInfo findByRefId(String refId);
}
