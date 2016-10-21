package com.lottery.yang;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import com.mysql.jdbc.Connection;

public class LotteryController {
	// static int l = 6;
	static int prizeMoney;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 获取幸运数字的方法
		int[] luckyNumber = getLuckynumber();
		//临时定义一个变量 期注  //调用 获取期注的方法
		String DataNum = getDateNum();
		
		
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date createTime = new Date();
		String luckyTime = simpleDateFormat.format(createTime);
		Lottery lottery = new Lottery(DataNum, luckyNumber[0], luckyNumber[1], luckyNumber[2], luckyNumber[3],
				luckyNumber[4], luckyNumber[5], luckyNumber[6], prizeMoney, "杨要军", luckyTime);
		
		Connection getConn = LotteryServiceImpl.getConn();
		
		int successNum = LotteryServiceImpl.insert(getConn,lottery);
		if (successNum == 1) {
			System.out.println("恭喜你，插入成功！");
		}
		
		LotteryServiceImpl.getSelect();
		
	}
	
	//获取期注的方法
	private static String getDateNum(){
		//关键点，每次递增1，快年从1开始 年+序号
		//所以该值要有两部份组成  年份 String  +  序号 int
		// 当当前时间年份 大于上次时间时，要修改年份且序号改为1
		int Num = 1;
		String dataNum = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
		Date createTime = new Date();
		//获取当前年份
		String nowTime = simpleDateFormat.format(createTime);
		//System.out.println(nowTime);
		
		//获取历史记录中最大的期注值 LotteryServiceImpl.getDataYear()
		//截取 年份
		String dateYear =  LotteryServiceImpl.getMaxDataNum().substring(0, 4);
		//截取后三位序号
		String numString = LotteryServiceImpl.getMaxDataNum().substring(5, 7);
		
		// 转换数据类型 String -> int    反之  int  ->  String  s=String.valueOf(i);
		Num = Integer.valueOf(numString).intValue();
		//System.out.println(dateYear);
		//System.out.println(Num);
		//根据年份是否相等，控制序号变化方式
		if (nowTime.equals(dateYear)) {
			// 如果二者相等，这 期注+1
			Num += 1;	
		} else {
			//否则 期注为 1
			Num = 1;

		}
		// 按照三位整数的方式 保留该值，不足三位前补 0
		String stringNum = String.format("%03d", Num);
		//组合当前年份和序号得到 期注号
		dataNum = nowTime + stringNum;
		//System.out.println(dataNum);
		
		return dataNum;
		
	}
	
	
	
	

	// 一：5000000，二：6000，三：3000，四：200，五：10，六：5
	// red:1 - 33 ; blue:1 - 16
	// 获取幸运数字
	private static int[] getLuckynumber() {
		int[] temp = new int[6];
		int[] luckyNumber = new int[7];

		Random luckyRandom = new Random();

		do {
			prizeMoney = luckyRandom.nextInt(5000000) + 1;
			//System.out.println(prizeMoney);
			if (prizeMoney == 3000 || prizeMoney == 6000 || prizeMoney == 5000000) {
				for (int i = 0; i < luckyNumber.length; i++) {
					//System.out.println(i);
					if (i<temp.length) {
						int luckyNum = luckyRandom.nextInt(33) + 1;
						temp[i] = luckyNum;
						//System.out.println("luckyNum"+luckyNum);
						if (i > 0 && i < 6) {
							for (int j = 0; j < i; j++) {
								if (temp[i] == temp[j]) {
									i--;
								}
							}
						}
					}
				
					if (i == 6) {
						Arrays.sort(temp);
						for (int j = 0; j < luckyNumber.length; j++) {
							if (j<6) {
								luckyNumber[j] = temp[j];
							}
							
							else {
								luckyNumber[i] = luckyRandom.nextInt(16) + 1;
							}
						}
					}
				}
			}
			
		} while (!(prizeMoney == 3000 || prizeMoney == 6000 || prizeMoney == 5000000));
		
		return luckyNumber;

	}

}
