package com.fzy.domain;

public class InfoPform {

	private Integer pformId;
	private String projectForm;
	public Integer getPformId() {
		return pformId;
	}
	public void setPformId(Integer pformId) {
		this.pformId = pformId;
	}
	public String getProjectForm() {
		return projectForm;
	}
	public void setProjectForm(String projectForm) {
		this.projectForm = projectForm;
	}
	@Override
	public String toString() {
		return "InfoPform [pformId=" + pformId + ", projectForm=" + projectForm + "]";
	}
	
}
