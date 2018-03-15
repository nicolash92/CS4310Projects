package com.View;

import java.util.Scanner;

public class viewConsole {
	
	static Scanner userInput;
	
	public viewConsole() {
		userInput = new Scanner(System.in);
	}
	
	public int start() {
		int min = 0, max = 2;
		
		System.out.print("[0]: Exit, [1]: Sudoku:, [2]: Nonogram: ");
		
		return checkValid(min, max);
		
	}
		
	public int checkValid(int min, int max) {
		// TODO Auto-generated method stub
		boolean valid = false;
			
		while(!valid) {
			try {
				int num = userInput.nextInt();
					
				if(!(num >= min && num <= max))
					throw new Exception("Invalid try again: ");
					
				return num;
					
			} catch(Exception ex) {
				System.out.print(ex.getMessage());
			}
		}
		return 0;
	}
	
}
