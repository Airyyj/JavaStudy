package study.demo;

public class BreakDemo {

	public static void main(String[] args) {

		first: {
			System.out.println("我是first");
			

			secend: {
				System.out.println("我是secend");
				
				
				thrid:{
				for (int i = 0; i < 2; i++) {
					System.out.println("我是thrid");
					break ;
					
				}
				
				System.out.println("跳出thrid");
					
				}

			}

		}
	System.out.println("我是main");

	}

}
