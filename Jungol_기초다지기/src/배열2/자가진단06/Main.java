package 배열2.자가진단06;

import java.util.Scanner;

/*
85 67 95 65
80 95 86 56
100 98 67 86
95 76 84 65
67 86 90 76
 */
public class Main {
	public static void main(String[] args) {

		int[][] score = new int[5][4];
		
		Scanner sc = new Scanner(System.in);
		for(int stu = 0; stu < score.length; stu++) {
			for(int subj = 0; subj < score[stu].length; subj++) {
				score[stu][subj] = sc.nextInt();
			}
		}
		
		int sum;
		double avg;
		int success = 0;  // 합격(Pass) 한 학생수
		for(int stu = 0; stu < score.length; stu++) {
			sum = 0;
			avg = 0.0;
			// stu 학생의 총점 구하기 => sum
			for(int subj = 0; subj < score[stu].length; subj++) {
				sum += score[stu][subj];
			}
			
			avg = (double)sum / score[stu].length;
			
			// 합격 여부
			if(avg >= 80) {
				System.out.println("pass");
				success++;  // 합격자수 +1 증가
			} else {
				System.out.println("fail");
			}
		} // end for
		
		System.out.println("Successful : " + success);	
		
		
		sc.close();
		
		
	}
	
}














