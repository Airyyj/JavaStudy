package array.demo;


import java.util.Arrays;
import java.util.Random;



public class ArrayDemo {
	
	 static int  l = 6;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] num = new int[10];
		
		int temp[] = new int[6];
		
		Random random = new Random();
		int num2 = random.nextInt(12) +1;
//  1 - 33 1 -16		
		for (int i = 0; i < l; i++) {
			System.out.println(i);
			System.out.println("++++");
			//int n = random.nextInt(12) +1;
			// 获取随机数
			temp[i]=random.nextInt(33) +1;
			// 判断与上个随机数是否相等
			if (i>0) {
				 for (int j = 0; j <i; j++) {
					 if (temp[i]==temp[j]) {
							//如果相等，增加l即增加循环次数
							System.out.println("我要减--");					
							i--;
						}					
				}  									
			}  			
			System.out.println("----");
			System.out.println(i);
			System.out.println("temp["+i+"]="+temp[i]);						
		}
		
		System.out.println("进行排序");
		Arrays.sort(temp);
		for (int i = 0; i < temp.length; i++) {
			
			System.out.println("temp["+i+"]="+temp[i]);
			
		}
	
		int[] luckyNumber = new int[7];
		for (int i = 0; i < luckyNumber.length; i++) {
			
			if (i<6) {
				luckyNumber[i] = temp[i];
			}
			else {
				luckyNumber[i] = random.nextInt(16)+1;
			}
			System.out.println("luckyNumber["+i+"]="+luckyNumber[i]);		
		}
		
		
		
	}
	
	
	
	
	

}
