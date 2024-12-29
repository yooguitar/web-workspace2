package com.home.calc;

import java.util.Scanner;

public class CalcRun {
	

	public static void main(String[] args) {

		CalcRun calcRun = new CalcRun();
		
		calcRun.calc();
		
	}

	public void calc() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("안녕 간단 계산기입니다.\n");
		System.out.print("숫자를 입력해주세요 > ");
		int num1 = sc.nextInt();
		sc.nextLine();
		System.out.print("연산 방법을 입력해주세요 > (+, -, *, /)");
		char how = sc.next().charAt(0);
		sc.nextLine();
		System.out.print("숫자를 입력해주세요 > ");
		int num2 = sc.nextInt();
		sc.nextLine();
		
			int result = 0;
			if(how == '+') {
				result = num1 + num2;
			} else if(how == '-') {
				result = num1 - num2;
			} else if(how == '*') {
				result = num1 * num2;
			} else if(how == '/') {
				result = num1 / num2;
			} else {
				System.out.println("잘못된 입력!");
				return;
			}
		System.out.println("연산 결과 = " + result);
	}

}