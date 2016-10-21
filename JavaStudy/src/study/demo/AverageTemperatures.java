package study.demo;

import java.util.Scanner;

public class AverageTemperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count;
		double next,sum,average;
		sum=0;
		//创建以scanner对象
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入七天的温度：");
		for (count = 1; count < 8; count++) {
			//通过 scanner 对象获得用户输入
			next=sc.nextDouble();
			System.out.println("第"+count+"天的温度是"+next);
			sum+=next;
		}
		System.out.println("总温度是："+sum);
		average=sum/7;
		System.out.println("平均气温为："+average);
		
	}

}
