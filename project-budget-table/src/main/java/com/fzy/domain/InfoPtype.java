package com.fzy.domain;

public class InfoPtype {

	private Integer ptypeId;
	private String projectType;
	
//	public Integer getPtypeId1() {
//		return ptypeId;
//	}
//	public void setPtypeId1(Integer ptypeId1) {
//		this.ptypeId = ptypeId1;
//	}
//	
	public Integer getPtypeId() {
		return ptypeId;
	}
	public void setPtypeId(Integer ptypeId) {
		this.ptypeId = ptypeId;
	}
	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	@Override
	public String toString() {
		return "InfoPtype [ptypeId=" + ptypeId + ", projectType=" + projectType + "]";
	}
	
}
