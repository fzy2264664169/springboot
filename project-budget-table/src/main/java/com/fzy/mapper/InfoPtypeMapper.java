package com.fzy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fzy.domain.InfoPtype;

@Mapper
public interface InfoPtypeMapper {

	@Select("select ptype_id PtypeId,project_type projectType from info_ptype where ptype_id=#{value}")
	public InfoPtype findById(int id);
	
	@Select("select ptype_id PtypeId,project_type projectType from info_ptype")
	public List<InfoPtype> findAll();
	
	@Insert("insert into info_ptype values(#{ptypeId},#{projectType})")
	public void insertInfoType(InfoPtype infoPtype);
		//	select ptype_id ptypeId,project_type projectType from info_ptype where ptype_id=#{ptypeId}
	@Update("update info_ptype set ptype_id=#{ptypeId},project_type=#{projectType} where ptype_id=#{ptypeId}")
//	@Select("select ptype_id ptypeId,project_type projectType from info_ptype")
	public void updateInfoPtype(InfoPtype infoPtype);

	@Select("select ptype_id ptypeId,project_type projectType from info_ptype where ptype_id=#{value}")
	public InfoPtype queryInfoPtype(int ptypeId);

	@Delete("delete from info_ptype where ptype_id=#{ptypeId}")
	public void deleteInfoPtype(int ptypeId);
}
