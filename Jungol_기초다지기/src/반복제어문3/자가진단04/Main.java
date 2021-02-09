package 반복제어문3.자가진단04;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			
			// 공백 출력
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			
			// * 출력
			for(int j = 0; j < n - i; j++) {				
				System.out.print("*");
			}
			System.out.println();
		}
		
		sc.close();	
	}
}
