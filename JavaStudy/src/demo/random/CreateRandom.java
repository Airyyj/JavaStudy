package demo.random;

public class CreateRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	for (int i = 0; i < 6; i++) {
			int j = (int) Math.random();
			System.out.println(j);
		
		}*/
		
		int x= 100;
		int y=33;
		System.out.println(x%y);
		
		
		int[] b = new int[7];
		for (int i = 0; i < b.length; i++) {
	
			
			b[i]=(int)(Math.random()*100);
			//System.out.println(Math.random());
			System.out.println("new1 "+b[i]);
			//System.out.println("+++++++++++++++");
			for (int j = 0; j < i+1; j++) {
				if ((i!=j)&&b[i]==b[j]) {
					b[i]=(int)(Math.random()*100);
					System.out.println("new2 "+b[i]);
					
				}
				if (b[i]==0) {
					b[i]+=(int)(Math.random()*100);
					System.out.println("new3 "+b[i]);
					
				}
				if (b[i]>=36&&b[i]!=0) {
					b[i]=b[i]%36;
					System.out.println("new4 "+b[i]);
					
				}
			}
			
			}
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]+" ");
		}
		
		

	}

}
