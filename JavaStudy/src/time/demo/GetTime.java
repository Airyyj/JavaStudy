package time.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*	
 * mysql 数据库时间类型及范围	
 * 
		datetime       8 bytes   YYYY-MM-DD HH:MM:SS   1000-01-01 00:00:00 ~ 9999-12-31 23:59:59 
		timestamp      4 bytes   YYYY-MM-DD HH:MM:SS   1970-01-01 00:00:01 ~ 2038 
		date           3 bytes   YYYY-MM-DD            1000-01-01          ~ 9999-12-31 
		year           1 bytes   YYYY                  1901                ~ 2155
		
		*/
		
		
		
		// 第一种获取时间方式
		//定义时间戳，java获取的是13为，除以1000 得到10；php是10为。
		//int currenttimes = (int) System.currentTimeMillis();
		int currentTime = (int) (System.currentTimeMillis()/1000);
		
		System.out.println(currentTime);
		
		// 第二种获取时间方
		//
		System.out.println("------");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date nowtime = new Date();
		System.out.println(simpleDateFormat.format(nowtime));
		
		System.out.println("++++++++++++");
		System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
		int i = 2;
		do {
			//i++;
			System.out.println(i);
		} while (i==3);
		

	}

}
