package 배열1.형성평가08;

import java.util.Scanner;


// 35 10 23 100 64 51 5 0
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int [] num = new int[100];
		
		int count = 0;
		int sum = 0;
		
		for(int i = 0; i < num.length; i++) {
			
			num[i] = sc.nextInt();
			if(num[i] == 0) break;
			
			if(num[i] % 5 == 0) {
				count++;
				sum += num[i];
			}
			
		} // end for
		
		System.out.println("Multiples of 5 : " + count);
		System.out.println("sum : " + sum);
		System.out.printf("avg : %.1f\n", sum / (double)count);
		
		sc.close();		
	} // end main
}




















