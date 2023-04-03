package com.code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="areasinfo")
public class AreasInfoVO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ZIP_NO")
	private int no;

	@Column(name="SIDO")
	private String sido;
	
	@Column(name="SIGUNGU")
	private String sigungu;
	
	@Column(name="DORO")
	private String doro;
	
	@Column(name="BUILD_NO1")
	private String buildNo1;
	
	@Column(name="BUILD_NO2")
	private String buildNo2;
	
	@Column(name="BUILD_NM")
	private String buildNm;
	
	@Column(name="DONG_NM")
	private String dongNm;
	
	@Column(name="H_DONG_NM")
	private String HDongNm;
	
	@Column(name="ZIBUN1")
	private String zibun1;
	
	@Column(name="ZIBUN2")
	private String zibun2;
	
	

	public AreasInfoVO() {
		
	}

	public int getNo() {
		return no;
	}

	
	public String getDoro() {
		return doro;
	}

	public String getSido() {
		return sido;
	}

	public String getSigungu() {
		return sigungu;
	}

	public String getBuildNo1() {
		return buildNo1;
	}

	public String getBuildNo2() {
		return buildNo2;
	}

	public String getBuildNm() {
		return buildNm;
	}

	public String getDongNm() {
		return dongNm;
	}

	public String getHDongNm() {
		return HDongNm;
	}

	public String getZibun1() {
		return zibun1;
	}

	public String getZibun2() {
		return zibun2;
	}

	@Override
	public String toString() {
		return "AreasInfoVO [no=" + no + ", sido=" + sido + ", sigungu=" + sigungu + ", doro=" + doro + ", buildNo1="
				+ buildNo1 + ", buildNo2=" + buildNo2 + ", buildNm=" + buildNm + ", dongNm=" + dongNm + ", HDongNm="
				+ HDongNm + ", zibun1=" + zibun1 + ", zibun2=" + zibun2 + "]";
	}

	
	
	


}
