package com.fzy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.fzy.domain.InfoSform;

@Mapper
public interface InfoSformMapper {

	@Select("select sform_id sformId,service_form serviceForm from info_sform")
	public List<InfoSform> findAll();
	
	@Select("select sform_id sformId,service_form serviceForm from info_sform where sform_id = #{value}")
	public InfoSform findById(int id);

	@Insert("insert into info_sform values(#{sformId},#{serviceForm})")
	public void insertInfoSform(InfoSform infoSform);

	@Select("select sform_id sformId,service_form serviceForm from info_sform where sform_id = #{value}")
	public InfoSform queryInfoSform(int sformId);

	@Update("update info_sform set sform_id=#{sformId},service_form=#{serviceForm} where sform_id=#{sformId}")
	public void updateInfoSform(InfoSform infoSform);

	@Delete("delete from info_sform where sform_id=#{sformId}")
	public void deleteInfoSform(int sformId);
}
