package com.code.springdemo.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AreasInfoDTO {

	private int no;

	
	private String sido;
	

	private String sigungu;
	
	private String doro;
	
	private String buildNo1;
	
	
	private String buildNo2;
	
	
	private String buildNm;
	
	
	private String dongNm;
	
	
	private String HDongNm;
	
	
	private String zibun1;
	
	private String zibun2;
	
	private String address;

	
	
	public AreasInfoDTO() {
	
	}
	
	public String getDoro() {
		return doro;
	}

	public void setDoro(String doro) {
		this.doro = doro;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getSido() {
		return sido;
	}

	public void setSido(String sido) {
		this.sido = sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public void setSigungu(String sigungu) {
		this.sigungu = sigungu;
	}

	public String getBuildNo1() {
		return buildNo1;
	}

	public void setBuildNo1(String buildNo1) {
		this.buildNo1 = buildNo1;
	}

	public String getBuildNo2() {
		return buildNo2;
	}

	public void setBuildNo2(String buildNo2) {
		this.buildNo2 = buildNo2;
	}

	public String getBuildNm() {
		return buildNm;
	}

	public void setBuildNm(String buildNm) {
		this.buildNm = buildNm;
	}

	public String getDongNm() {
		return dongNm;
	}

	public void setDongNm(String dongNm) {
		this.dongNm = dongNm;
	}

	public String getHDongNm() {
		return HDongNm;
	}

	public void setHDongNm(String hDongNm) {
		HDongNm = hDongNm;
	}

	public String getZibun1() {
		return zibun1;
	}

	public void setZibun1(String zibun1) {
		this.zibun1 = zibun1;
	}

	public String getZibun2() {
		return zibun2;
	}

	public void setZibun2(String zibun2) {
		this.zibun2 = zibun2;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AreasInfoDTO [no=" + no + ", sido=" + sido + ", sigungu=" + sigungu + ", buildNo1=" + buildNo1
				+ ", buildNo2=" + buildNo2 + ", buildNm=" + buildNm + ", dongNm=" + dongNm + ", HDongNm=" + HDongNm
				+ ", zibun1=" + zibun1 + ", zibun2=" + zibun2 + ", address=" + address + "]";
	}

	


	
}
