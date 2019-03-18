package com.fzy.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fzy.Application;
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

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class TestMethod {

	@Autowired InfoPtypeMapper infoPtypeMapper;
	
	//测试InfoPtypeMapper
	@Test
	public void test1() {
		InfoPtype ip1 = infoPtypeMapper.findById(1);
		System.out.println(ip1.getPtypeId());
		System.out.println(ip1.getProjectType());
	}
	@Test
	public void test2() {
		List<InfoPtype> ip2 = infoPtypeMapper.findAll();
		for(InfoPtype infoPtype : ip2) {
			System.out.println("==========" + infoPtype.getPtypeId() + " : " + infoPtype.getProjectType());
		}
	}
	
	@Autowired InfoPformMapper infoPformMapper;
	//测试InfoPformMapper
	@Test
	public void test3() {
		List<InfoPform> ipf1 = infoPformMapper.findAll();
		for (InfoPform infoPform : ipf1) {
			System.out.println("infoPformMapper:" + infoPform.getPformId() + " : " + infoPform.getProjectForm());
		}
	}
	
	//测试InfoSform
	@Autowired InfoSformMapper infoSformMapper;
	@Test
	public void test4() {
		List<InfoSform> ifs1 = infoSformMapper.findAll();
		System.out.println(ifs1);
		for (InfoSform infoSform : ifs1) {
			System.out.println(infoSform.getServiceForm()+infoSform.getSformId());
		}
	}
	
	//测试ProInfo
	@Autowired ProInfoMapper proInfoMapper;
	@Test
	public void test5() {
		List<ProInfo> pi1 = proInfoMapper.findAll();
		System.out.println(pi1);
		for (ProInfo proInfo : pi1) {
			System.out.println(proInfo.getInfoId()+proInfo.getContractNumber()+proInfo.getRefId());
		}
	}
	@Test
	public void test6() {
		ProInfo pi2 = proInfoMapper.findById(1);
		System.out.println(pi2.getInfoId()+pi2.getContractNumber());
	}
	
	@Test
	public void test7() {
		Date date = new Date();
		Timestamp time = new Timestamp(date.getTime());
		ProInfo pi3 = new ProInfo();
		pi3.setCustomerName("哈士奇");
		pi3.setProjectName("野区");
		pi3.setContractNumber("21");
		pi3.setResponseDepartment("服务部");
		pi3.setProjectManager("2");
		pi3.setProjectMoney(220000000);
		pi3.setApplyDate(time);
		pi3.setPtypeId(1);
		pi3.setPformId(1);
		pi3.setSformId(1);
		String uuid=UUID.randomUUID().toString();
		pi3.setRefId(uuid);
		proInfoMapper.insertProInfo(pi3);
		System.out.println("insert success!");
		
		List<ProInfo> pi4 = proInfoMapper.findAll();
		System.out.println(pi4);
		for (ProInfo proInfo : pi4) {
			System.out.println(proInfo.getInfoId()+proInfo.getContractNumber());
		}
	}
	


	
	/*
	 * 测试AppendixIdea
	 */
	
	/*
	 * 测试ProLabor
	 */
	@Autowired ProLaborMapper proLaborMapper;
	@Test
	public void test11() {
		List<ProLabor> pl1 = proLaborMapper.findAll();
		for (ProLabor proLabor : pl1) {
			System.out.println(proLabor.getRefId());
		}
		System.out.println(pl1);
	}
	@Test
	public void test111() {
		
	}
	@Test
	public void test12() {
		ProLabor pl2 = new ProLabor();
		pl2.setServicerName("22");
		pl2.setDutyNote("223");
	//	pl2.setSpositionId(2);
		pl2.setEveryday5(51);
		pl2.setEveryday7(71);
		pl2.setEveryday24(241);
		pl2.setWeekendsday24(242);
		pl2.setWeekendsday7(72);
		pl2.setWeekendsday5(52);
		pl2.setNationalday24(243);
		pl2.setNationalday5(52);
		pl2.setNationalday7(72);
		proLaborMapper.insertProLabor(pl2);
		
		List<ProLabor> pl3 = proLaborMapper.findAll();
		System.out.println(pl3);
	}
	/*
	 * 测试ProCost
	 */
	@Autowired ProCostMapper proCostMapper;
	@Test
	public void test13() {
		List<ProCost> pc1 = proCostMapper.findAll();
		System.out.println(pc1);
	}
	@Test
	public void test14() {
		ProCost pc2 = new ProCost();
		pc2.setCostBreakdown("cost");
		pc2.setCostMoney(1);
		pc2.setFragmentaryMoney(2);
		pc2.setMainList("main");
		pc2.setPurchaseList("purchase");
		pc2.setPurchaseMoney(3);
		pc2.setSubcontractContent("content");
		pc2.setSubcontractMessage("message");
		pc2.setSubcontractMoney(4);
		proCostMapper.insertProCost(pc2);
		List<ProCost> pc3 = proCostMapper.findAll();
		System.out.println(pc3);
	}
	
	@Test
	public void test15() {
		ProInfo pi1= proInfoMapper.findByRefId("fbfd1399-be6a-458e-a42d-fcfa9a38b6ce");
		System.out.println(pi1.getCustomerName());
	}
	@Test
	public void test16() {
		List<ProLabor> proLabor = proLaborMapper.findByRefId("fbfd1399-be6a-458e-a42d-fcfa9a38b6ce");
		System.out.println(proLabor);
	}
	@Test
	public void test17() {
		ProCost proCost = proCostMapper.findByRefId("fbfd1399-be6a-458e-a42d-fcfa9a38b6ce");
		System.out.println(proCost);
	}
}
