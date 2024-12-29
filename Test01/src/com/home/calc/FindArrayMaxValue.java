package com.home.calc;

public class FindArrayMaxValue {
	
	// 난수가 대입된 배열을 순회하며 최대값을 찾는 로직
	public static void main(String[] args) {
		new FindArrayMaxValue().method1();
	}
//		int test = (int)(Math.random()*99+1);
//		System.out.print(test);
//		Math.random()은 0.0 - 1.0 사이의 난수를 발생시킴
	
	public void method1() {
		
		int[] arr = new int[10];
		int maxValue = arr[0];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100 + 1);
			// System.out.println(arr[i]);
		}
		
		for(int j = 0; j < arr.length; j++) {
			
			if(maxValue < arr[j]) {
				maxValue = arr[j];
			}
		}
		System.out.println("배열의 최댓값은? = " + maxValue);
		
	}
	
}
