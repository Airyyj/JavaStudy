package com.lottery.yang;

import java.util.Date;

public class Lottery {
// LID,L01,L02,L03,L04,L05,L06,L07,Lmoney,CreateUser,CreateTime
	private int LID;
	private String DataNum;
	private int L01;
	private int L02;
	private int L03;
	private int L04;
	private int L05;
	private int L06;
	private int L07;
	private int Lmoney;
	private String CreateUser;
	private String CreateTime;

	public int getLID() {
		return LID;
	}

	public void setLID(int lID) {
		LID = lID;
	}


	public String getDataNum() {
		return DataNum;
	}

	public void setDataNum(String dataNum) {
		DataNum = dataNum;
	}

	public int getL01() {
		return L01;
	}

	public void setL01(int l01) {
		L01 = l01;
	}

	public int getL02() {
		return L02;
	}

	public void setL02(int l02) {
		L02 = l02;
	}

	public int getL03() {
		return L03;
	}

	public void setL03(int l03) {
		L03 = l03;
	}

	public int getL04() {
		return L04;
	}

	public void setL04(int l04) {
		L04 = l04;
	}

	public int getL05() {
		return L05;
	}

	public void setL05(int l05) {
		L05 = l05;
	}

	public int getL06() {
		return L06;
	}

	public void setL06(int l06) {
		L06 = l06;
	}

	public int getL07() {
		return L07;
	}

	public void setL07(int l07) {
		L07 = l07;
	}

	public int getLmoney() {
		return Lmoney;
	}

	public void setLmoney(int lmoney) {
		Lmoney = lmoney;
	}

	public String getCreateUser() {
		return CreateUser;
	}

	public void setCreateUser(String createUser) {
		CreateUser = createUser;
	}

	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	
	
	 public Lottery(String dataNum, int l01, int l02, int l03, int l04, int l05, int l06, int l07, int lmoney,
			String createUser, String createTime) {
		super();
		DataNum = dataNum;
		L01 = l01;
		L02 = l02;
		L03 = l03;
		L04 = l04;
		L05 = l05;
		L06 = l06;
		L07 = l07;
		Lmoney = lmoney;
		CreateUser = createUser;
		CreateTime = createTime;
	}

	
	
	
	

}
