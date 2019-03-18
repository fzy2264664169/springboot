package com.fzy.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.UnableToRegisterMBeanException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//方法参数（手动添加的）
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fzy.domain.InfoPform;
import com.fzy.domain.InfoPtype;
import com.fzy.domain.InfoSform;
import com.fzy.domain.ProCost;
import com.fzy.domain.ProInfo;
import com.fzy.domain.ProLabor;
import com.fzy.mapper.InfoPformMapper;
import com.fzy.mapper.InfoPtypeMapper;
import com.fzy.service.InfoPformService;
import com.fzy.service.InfoPtypeService;
import com.fzy.service.InfoSformService;
import com.fzy.service.ProCostService;
import com.fzy.service.ProInfoService;
import com.fzy.service.ProLaborService;

import net.sf.json.JSONObject;

@Controller
public class InfoController {

	@RequestMapping("/tr")
	public String tr() {
		return "/test";
	}
	@RequestMapping("/selectSearch")
	public String Select(Model model) {
		List<ProInfo> pi3=proInfoService.findAll();
		model.addAttribute("proInfo", pi3);
		return "selectSearch";
	}
	
	
	/*
	 * 服务项目预算表主页  tab版
	 */
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	
	
	
	
	
	@Autowired
	private InfoPtypeService infoPtypeServie;
	/*
	 * 获取项目类型
	 */
	@RequestMapping(value="/getProjectType",method=RequestMethod.POST)
	@ResponseBody
	public List<InfoPtype> getProjectType() {
		System.out.println("------=========");
		List<InfoPtype> ip1 = infoPtypeServie.findAll();
		for (InfoPtype infoPtype : ip1) {
			System.out.println(infoPtype.getPtypeId() + " : " + infoPtype.getProjectType());
		}
		return ip1;
	}
	
	@Autowired
	private InfoPformService infoPformService;
	/*
	 * 获取项目性质
	 */
	@RequestMapping(value="/getProjectForm",method=RequestMethod.POST)
	@ResponseBody
	public List<InfoPform> getProjectForm() {
		List<InfoPform> ipf1 = infoPformService.findAll();
		return ipf1;
	}
	
	/*
	 * 获取服务形式
	 */
	@Autowired
	private InfoSformService infoSformService;
	@RequestMapping(value="/getServiceForm",method=RequestMethod.POST)
	@ResponseBody
	public List<InfoSform> getServiceForm() {
		List<InfoSform> ifs1 = infoSformService.findAll();
		return ifs1;
	}
	
	/*
	 * 获取服务人员职位
	 */
/*	@Autowired
//	private LaborTypeService laborTypeService;
	private LaborSpositionService laborSpositionService;
	@RequestMapping(value="/getServicerPosition",method=RequestMethod.POST)
	@ResponseBody
	public List<LaborSposition> getServicerPosition() {
		List<LaborSposition> ls1 = laborSpositionService.findAll();
		return ls1;
	}
	@RequestMapping(value="/getServicerPosition2",method=RequestMethod.POST)
	@ResponseBody
	public List<LaborSposition> getServicerPosition2(@RequestParam("id")int id) {
		List<LaborSposition> ls2 = laborSpositionService.findById(id);
		return ls2;
	}*/
	
	/*
	 * 获取项目工作类别
	 */
/*	@Autowired
	private LaborTypeService laborTypeService;
	@RequestMapping(value="/getWorkType",method=RequestMethod.POST)
	@ResponseBody
	public List<LaborType> getWorkType() {
		List<LaborType> lt1 = laborTypeService.findAll();
		return lt1;
	}*/
	
	
	
	
//	String uuid=UUID.randomUUID().toString();
	
//	@RequestMapping(value="/getRefId",method=RequestMethod.POST)
//	@ResponseBody
//	public String  getRefId() {
//		String refId=UUID.randomUUID().toString();
//		
//		System.out.println(refId);
//		return refId;
//		
//	}
	
	/*
	 * 新增项目基本信息(测试数据添加)
	 */
	@Autowired
	private ProInfoService proInfoService;
	@Autowired
	private ProLaborService prolaborService;
	@Autowired
	private ProCostService proCostService;
	
	
	@RequestMapping(value="/insertProInfo",method=RequestMethod.POST)
	public String insertProInfo(ProInfo proInfo,ProLabor proLabor,ProCost proCost,HttpServletRequest request) throws ParseException {
		String param = request.getParameter("param");
		JSONObject jsonObject=JSONObject.fromObject(param);
		
		@SuppressWarnings("unchecked")
		List<Map<String, String>> labor = jsonObject.getJSONArray("data");
		System.out.println(labor);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		long dateTime = System.currentTimeMillis();
		String date = sdf.format(new Date(dateTime));
		
		
		String uuid=UUID.randomUUID().toString();
		System.out.println(uuid);
		
		
	for (Map<String, String> map : labor) {
		System.out.println("map:"+map);
		System.out.println("customerName:"+map.get("customerName"));
		if(map.get("servicerPosition")!=null) {
			int i=0;
			System.out.println(i++);
			continue;
		} else if(map.get("customerName")!=null){
			System.out.println("piii");
			ProInfo pi0=new ProInfo();
			pi0.setRefId(uuid);
			System.out.println("uuid:"+pi0.getRefId());
			pi0.setCustomerName(map.get("customerName"));
			System.out.println("customername:"+map.get("customerName"));
			pi0.setProjectName(map.get("projectName"));
			pi0.setContractNumber(map.get("contractNumber"));
			pi0.setResponseDepartment(map.get("responseDepartment"));
			pi0.setProjectManager(map.get("projectManager"));
			System.out.println("projectMoney:"+pi0.getProjectMoney());
			System.out.println("aa:"+map.get("projectMoney"));
//			System.out.println(Integer.parseInt(map.get("projectMoney")));
			//pi0.setProjectMoney(Integer.parseInt(map.get("projectMoney")));
			pi0.setProjectMoney(Integer.parseInt(map.get("projectMoney").equals("")?"0":map.get("projectMoney")));
			System.out.println("projectMoney:"+pi0.getProjectMoney());
			
			
			pi0.setApplyDate(sdf.parse(map.get("applyDate").equals("")?date:map.get("applyDate")));
			System.out.println("date:"+pi0.getApplyDate());
			pi0.setStartTime(sdf.parse(map.get("startTime").equals("")?date:map.get("startTime")));
			pi0.setEndTime(sdf.parse(map.get("endTime").equals("")?date:map.get("endTime")));
			pi0.setPtypeId(Integer.parseInt(map.get("projectType").equals("")?"0":map.get("projectType")));
			pi0.setPformId(Integer.parseInt(map.get("projectForm").equals("")?"0":map.get("projectForm")));
			pi0.setSformId(Integer.parseInt(map.get("serviceForm").equals("")?"0":map.get("serviceForm")));
			proInfoService.insertProInfo(pi0);
			System.out.println("proinfo");
		}
		
	}
		
		
		for (Map<String, String> map : labor) {
			System.out.println(map);
			
			
			//for (String key : map.keySet()) {
				
				//System.out.println("key= "+ key + " and value= " + map.get(key));
				
			if(map.get("servicerPosition")!=null) {
				ProLabor pl0=new ProLabor();
				
				pl0.setRefId(uuid);
				
				pl0.setServicerPosition(map.get("servicerPosition"));
				System.out.println("cost:"+map.get("averageCost"));
				pl0.setAverageCost(Integer.parseInt(map.get("averageCost").equals("")?"0":map.get("averageCost")));
				pl0.setServicerName(map.get("servicerName"));
				
				pl0.setEveryday5(Integer.parseInt(map.get("everyday5").equals("")?"0":map.get("everyday5")));
				pl0.setWeekendsday5(Integer.parseInt(map.get("weekendsday5").equals("")?"0":map.get("weekendsday5")));
				pl0.setNationalday5(Integer.parseInt(map.get("nationalday5").equals("")?"0":map.get("nationalday5")));
				pl0.setEveryday7(Integer.parseInt(map.get("everyday7").equals("")?"0":map.get("everyday7")));
				pl0.setWeekendsday7(Integer.parseInt(map.get("weekendsday7").equals("")?"0":map.get("weekendsday7")));
				pl0.setNationalday7(Integer.parseInt(map.get("nationalday7").equals("")?"0":map.get("nationalday7")));
				pl0.setEveryday24(Integer.parseInt(map.get("everyday24").equals("")?"0":map.get("everyday24")));
				pl0.setWeekendsday24(Integer.parseInt(map.get("weekendsday24").equals("")?"0":map.get("weekendsday24")));
				pl0.setNationalday24(Integer.parseInt(map.get("nationalday24").equals("")?"0":map.get("nationalday24")));
				pl0.setDutyNote(map.get("dutyNote"));
				prolaborService.insertProLabor(pl0);
				System.out.println("labor");
				
			}
				
				
		}
		
		for (Map<String, String> map : labor) {

			if(map.get("servicerPosition")!=null && map.get("customerName")!=null) {
				continue;
			} else if(map.get("subcontractContent")!=null){
				System.out.println("poinfooooooooooo:"+map);
				ProCost pc0 = new ProCost();
				pc0.setRefId(uuid);
				pc0.setSubcontractContent(map.get("subcontractContent"));
				pc0.setSubcontractMessage(map.get("subcontractMessage"));
				pc0.setSubcontractMoney(Integer.parseInt(map.get("subcontractMoney").equals("")?"0":map.get("subcontractMoney")));
				pc0.setPurchaseList(map.get("purchaseList"));
				pc0.setPurchaseMoney(Integer.parseInt(map.get("purchaseMoney").equals("")?"0":map.get("purchaseMoney")));
				pc0.setMainList(map.get("mainList"));
				pc0.setFragmentaryMoney(Integer.parseInt(map.get("fragmentaryMoney").equals("")?"0":map.get("fragmentaryMoney")));
				pc0.setCostBreakdown(map.get("costBreakdown"));
				pc0.setCostMoney(Integer.parseInt(map.get("costMoney").equals("")?"0":map.get("costMoney")));
				
				pc0.setSuggestion1(map.get("suggestion1"));
				pc0.setSuggestion2(map.get("suggestion2"));
				pc0.setSuggestion3(map.get("suggestion3"));
				pc0.setPrincipalName(map.get("principalName"));
				pc0.setPrincipalDate(sdf.parse(map.get("principalDate").equals("")?date:map.get("principalDate")));
				pc0.setSectionName(map.get("sectionName"));
				pc0.setSectionDate(sdf.parse(map.get("sectionDate").equals("")?date:map.get("sectionDate")));
				pc0.setCenterName(map.get("centerName"));
				pc0.setCenterDate(sdf.parse(map.get("centerDate").equals("")?date:map.get("centerDate")));
				proCostService.insertProCost(pc0);
				System.out.println("procost");
			}
			
		}
		
		return "index";
	}
}
