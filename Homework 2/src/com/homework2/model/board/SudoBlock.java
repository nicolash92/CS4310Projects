package com.homework2.model.board;


public class SudoBlock {
	
	//solution for block
	private char value;
	
	//private boolean preSolved;
	private boolean preSolved;
	
	public SudoBlock(int value, boolean preSolved) {
		this.preSolved = preSolved;
		if(preSolved) {
			if(value<1||value>9) {
				value = 0;
				this.preSolved = false;
			}
		}
		this.value= (char) ('0'+value);
			
	}
	
	public void setValue(int value) {
		if(preSolved) {
			return;
		}
		if(value<0||value>9)
			value = 0;
		this.value= (char) ('0'+value);
	}
	
	public boolean isBlank() {
		return value=='0';
	}
	
	public char getValue() {
		return value;
	}

	public String toString() {
		return this.value=='0'?" ":String.valueOf(value);
	}
}
