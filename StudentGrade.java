package com.task;

import java.util.Scanner;

public class StudentGrade {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the number of subjects : ");
		int Totalsub = sc.nextInt();
		
		int[] marks = new int[Totalsub];
		int totalMarks = 0;
		
		System.out.println("Enter marks ->");
		for(int i=0; i<Totalsub; i++) {
			System.out.print("Subject "+(i+1)+" - ");
			marks[i] = sc.nextInt();
			totalMarks += marks[i];
			
		}
		
		Double avgPercentage = (double)totalMarks / Totalsub;
		
		String grade;
		if(avgPercentage >= 90) {
			grade = "A";
		}else if(avgPercentage >= 80) {
			grade = "B";
		}else if(avgPercentage >= 60) {
			grade = "C";
		}else if(avgPercentage >= 40) {
			grade = "D";
		}else {
			grade = "Fail";
		}
		
		System.out.println("----------Student Result----------");
		System.out.println("Total Marks -> "+totalMarks);
		System.out.println("Average Percentage -> "+avgPercentage);
		System.out.println("Grade -> "+grade);
			
	}
}
