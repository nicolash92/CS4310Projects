package com.View;

public class userMove {
	private int row;
	private int column;
	private int input;
	
	public userMove() {
		row = column = input = 0;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}

	public void setInput(int input) {
		this.input = input;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}

	public int getInput() {
		return this.input;
	}
	
}
