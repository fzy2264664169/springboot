package com.fzy.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fzy.domain.InfoPform;
import com.fzy.domain.InfoPtype;
import com.fzy.domain.InfoSform;
import com.fzy.domain.ProCost;
import com.fzy.domain.ProInfo;
import com.fzy.domain.ProLabor;
import com.fzy.mapper.InfoPformMapper;
import com.fzy.mapper.InfoPtypeMapper;
import com.fzy.mapper.InfoSformMapper;
import com.fzy.mapper.ProCostMapper;
import com.fzy.mapper.ProInfoMapper;
import com.fzy.mapper.ProLaborMapper;

@Controller
public class PbtController {

	/*
	 * admin页面
	 */
	@RequestMapping("/admin")
	public String pb() {
		return "/admin";
	}
	
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	long time = System.currentTimeMillis();
	String date = df.format(new Date(time));
	
	/**
	 * 项目预算表页面pbt.html
	 * @return
	 */
	@RequestMapping("/pbt")
	public String pbt(Model model) {
		long a1 = new Date().getTime();
			model.addAttribute("contractNumber", date+a1);
//		String b = String.valueOf(a);
//		String b1 = b.substring(b.length()-3, b.length());
//		long c = 0;
//		String dString = date+b1;
		
		return "pbt";
	}
	
	/**
	 * 项目列表pbt-list.html
	 */
	@Autowired ProInfoMapper proInfoMapper;
	@RequestMapping("/pbt-list")
	public String pbtList(Model model) {
		model.addAttribute("info",proInfoMapper.findAll());
		return "pbt-list";
	}
	
	/**
	 * 项目列表view：pbt-detail
	 * 测试版
	 */
	@RequestMapping("/detail")
	public String detail() {
		return "pbt-detail";
	}
	
	@Autowired
	private ProLaborMapper proLaborMapper;
	@Autowired
	private ProCostMapper proCostMapper;
	/**
	 * 项目列表view：pbt-detail
	 * 上线版
	 */
	@RequestMapping("/pbt-detail")
	public String pbtDetail(String refId,Model model) {
		System.out.println("refId:"+refId);
		
		model.addAttribute("proinfo", proInfoMapper.findByRefId(refId));
		List<ProLabor> proLabor = proLaborMapper.findByRefId(refId);
		model.addAttribute("prolabor",proLabor);
		model.addAttribute("procost", proCostMapper.findByRefId(refId));
		return "pbt-detail";
	}
	
	/**
	 * 项目列表delete：msg=删除成功
	 * @throws IOException 
	 */
	/*@RequestMapping("/pbt-delete")
	public String pbtDelete(String refId,Model model,HttpServletResponse response) throws IOException {
		proInfoMapper.deleteProInfo(refId);
		proLaborMapper.deleteProLabor(refId);
		proCostMapper.deleteProCost(refId);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<script> alert('删除'); window.location='/pbt-list'; window.close(); </script>");
		response.getWriter().flush();
		model.addAttribute("msg", "删除成功");
		return "redirect:/pbt-list";
	}*/
	@RequestMapping("/pbt-delete")
	public void pbtDelete(String refId,Model model,HttpServletResponse response) throws IOException {
		System.out.println(refId);
		proInfoMapper.deleteProInfo(refId);
		proLaborMapper.deleteProLabor(refId);
		proCostMapper.deleteProCost(refId);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("<script> alert('删除成功'); window.location='/pbt-list'; window.close(); </script>");
		response.getWriter().flush();
	}
	
	@Autowired
	private InfoPtypeMapper infoPtypeMapper;
	@Autowired
	private InfoPformMapper infoPformMapper;
	@Autowired
	private InfoSformMapper infoSformMapper;
	/**
	 * 项目信息——项目类型pbt-type.html
	 */
	@RequestMapping("/pbt-type")
	public void pbtType(Model model) {
		model.addAttribute("infoPtype",infoPtypeMapper.findAll());
	}
	//项目类型添加pbt-type-add.html
	@RequestMapping("/pbt-type-add")
	public String pbtTypeAdd() {
		return "pbt-type-add";
	}
	//添加项目类型业务type-add
	@RequestMapping("/type-add")
	public String typeAdd(Integer ptypeId,String projectType) {
		InfoPtype infoPtype = new InfoPtype();
		infoPtype.setPtypeId(ptypeId);
		infoPtype.setProjectType(projectType);
		infoPtypeMapper.insertInfoType(infoPtype);
		return "redirect:/pbt-type";
	}
	//项目类型修改pbt-type-edit.html
	@RequestMapping("/pbt-type-edit")
	public String pbtTypeEdit(int ptypeId,Model model) {
		model.addAttribute("infoPtype1", infoPtypeMapper.queryInfoPtype(ptypeId));
		return "pbt-type-edit";
	}
	//修改项目类型业务type-edit
	@RequestMapping("/type-edit")
	public String typeEdit(int ptypeId,String projectType) {
		InfoPtype infoPtype = new InfoPtype();
		infoPtype.setPtypeId(ptypeId);
		infoPtype.setProjectType(projectType);
		infoPtypeMapper.updateInfoPtype(infoPtype);
		return "redirect:/pbt-type";
	}
	//删除项目类型pbt-type-delete
	@RequestMapping("/pbt-type-delete")
	public String pbtTypeDelete(int ptypeId,HttpServletResponse response) {
		infoPtypeMapper.deleteInfoPtype(ptypeId);
		response.setContentType("text/html,charset=utf-8");
		return "redirect:/pbt-type";
	}
	
	/**
	 * 项目信息——项目性质pbt-form.html
	 */
	@RequestMapping("/pbt-form")
	public void pbtForm(Model model) {
		model.addAttribute("infoPform", infoPformMapper.findAll());
	}
	//项目性质添加pbt-form-add.html
	@RequestMapping("/pbt-form-add")
	public String pbtFormAdd() {
		return "pbt-form-add";
	}
	//项目性质添加业务form-add
	@RequestMapping("/form-add")
	public String formAdd(int pformId,String projectForm) {
		InfoPform infoPform = new InfoPform();
		infoPform.setPformId(pformId);
		infoPform.setProjectForm(projectForm);
		infoPformMapper.insertInfoPform(infoPform);
		return "redirect:pbt-form";
	}
	//项目性质修改pbt-form-edit
	@RequestMapping("/pbt-form-edit")
	public String pbtFormEdit(int pformId,Model model) {
		model.addAttribute("infoPform", infoPformMapper.queryInfoPform(pformId));
		return "pbt-form-edit";
	}
	//项目性质修改业务form-edit
	@RequestMapping("/form-edit")
	public String formEdit(int pformId,String projectForm) {
		InfoPform infoPform = new InfoPform();
		infoPform.setPformId(pformId);
		infoPform.setProjectForm(projectForm);
		infoPformMapper.updateInfoPform(infoPform);
		return "redirect:/pbt-form";
	}
	//项目性质删除pbt-form-delete
	@RequestMapping("/pbt-form-delete")
	public String pbtFormDelete(int pformId,HttpServletResponse response) {
		infoPformMapper.deleteInfoPform(pformId);
		response.setContentType("text/html,charset=utf-8");
		return "redirect:/pbt-form";
	}
	
	/**
	 * 项目信息——服务形式ser-form.html
	 */
	@RequestMapping("/ser-form")
	public void serForm(Model model) {
		model.addAttribute("infoSform", infoSformMapper.findAll());
	}
	//服务形式添加ser-form-add.html
	@RequestMapping("/ser-form-add")
	public String serFormAdd() {
		return "ser-form-add";
	}
	//服务形式添加业务ser-add
	@RequestMapping("/ser-add")
	public String serAdd(int sformId,String serviceForm) {
		InfoSform infoSform = new InfoSform();
		infoSform.setSformId(sformId);
		infoSform.setServiceForm(serviceForm);
		infoSformMapper.insertInfoSform(infoSform);
		return "redirect:/ser-form";
	}
	//服务形式修改ser-form-edit
	@RequestMapping("/ser-form-edit")
	public String serFormEdit(int sformId,Model model) {
		model.addAttribute("infoSform", infoSformMapper.queryInfoSform(sformId));
		return "ser-form-edit";
	}
	//服务形式修改业务ser-edit
	@RequestMapping("/ser-edit")
	public String serEdit(int sformId,String serviceForm) {
		InfoSform infoSform = new InfoSform();
		infoSform.setSformId(sformId);
		infoSform.setServiceForm(serviceForm);
		infoSformMapper.updateInfoSform(infoSform);
		return "redirect:/ser-form";
	}
	//服务形式删除ser-form-delete
	@RequestMapping("ser-form-delete")
	public String serFormDelete(int sformId) {
		infoSformMapper.deleteInfoSform(sformId);
		return "redirect:/ser-form";
	}
}
