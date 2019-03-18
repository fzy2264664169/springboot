package com.fzy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fzy.domain.InfoPform;

@Mapper
public interface InfoPformMapper {

	@Select("select pform_id PformId,project_form projectForm from info_pform")
//	@Select("select * from info_pform")
	public List<InfoPform> findAll();
	
	@Select("select pform_id PformId,project_form projectForm from info_pform where pform_id = #{value}")
	public InfoPform findById(int id);

	@Insert("insert into info_pform values(#{pformId},#{projectForm})")
	public void insertInfoPform(InfoPform infoPform);

	@Select("select pform_id PformId,project_form projectForm from info_pform where pform_id = #{value}")
	public InfoPform queryInfoPform(int pformId);

	@Update("update info_pform set pform_id=#{pformId},project_form=#{projectForm} where pform_id=#{pformId}")
	public void updateInfoPform(InfoPform infoPform);

	@Delete("delete from info_pform where pform_id=#{pformId}")
	public void deleteInfoPform(int pformId);
}
