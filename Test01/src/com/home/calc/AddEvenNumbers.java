package com.home.calc;

public class AddEvenNumbers {

	public static void main(String[] args) {
		
		new AddEvenNumbers().findEven();

	}

	
	public void findEven() {
		
		int result = 0;
		
		for(int i = 1; i <= 100; i++) {
			
			if((i % 2) == 0) {
				result += i;
				
			}
		}
		
		System.out.println(result);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
