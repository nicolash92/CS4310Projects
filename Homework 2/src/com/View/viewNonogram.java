package com.View;
import java.util.Scanner;
public class viewNonogram implements viewInterface {
	
	private int row, column;
	static Scanner userInput;
	private userMove moves;
	
	public viewNonogram() {
		row  = column = -1;
		userInput = new Scanner(System.in);
	}
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		int min = 0, max = 1;
		
		System.out.println("Welcome to Nonogram");
		System.out.print("[0]: Exit, [1]: Start: ");
		
		int input = checkValid(min, max);
		
		switch(input){
		case 0:
			System.out.println("exit: Nonogram GoodBye!");
			System.exit(0);
			break;
		case 1:
			setRow(); 
			setColumn();
		}
	}
	
	@Override
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
	
	@Override
	public userMove move() {
		// TODO Auto-generated method stub
		int zero = 0;
		moves = new userMove();
		
		System.out.print("Row: ");
		moves.setRow(checkValid(zero, row));
		
		System.out.print("Column: ");
		moves.setColumn(checkValid(zero, row));
		
		return moves;
	}


	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		try {
			if(row <= 0 && column <= 0)
				throw new Exception("Error: No row or column input");
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			setRow(); setColumn();
			
		}
		String [] scale = {" ","1","2","3","4","5","6","7","8","9","10",
				"11","12","13","14","15"};
		for(int index = 0; index <= row; index++) {
			for(int jndex = 0; jndex <= column; jndex++) {
				if(index == 0)
					System.out.print(scale[jndex]);
				else if(jndex == 0)
					System.out.print(scale[index]);
				else 
					System.out.print("-");
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	@Override
	public void setRow() {
		// TODO Auto-generated method stub
		
		this.row = 8;
		
	}

	@Override
	public int getRow() {
		// TODO Auto-generated method stub
		return row;
	}

	@Override
	public void setColumn() {
		// TODO Auto-generated method stub
		 this.column = 8;
	}

	@Override
	public int getColumn() {
		// TODO Auto-generated method stub
		return column;
	}
}
