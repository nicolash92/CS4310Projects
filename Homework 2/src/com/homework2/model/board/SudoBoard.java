package com.homework2.model.board;


import java.util.Random;

public class SudoBoard implements GridGame{
	private SudoBlock[][] board;

	@Override
	public GridGame getGame() {
		boolean notValidBoard;
		notValidBoard=true;
		while(notValidBoard){
			generateRandom();
			notValidBoard=false;
			for(int i=0; i<9; i++)
				for(int j=0; j<9; j++)
					if(!board[i][j].isBlank() && !unique(i,j))
						notValidBoard = true;
		}
		return this;
	}

	//checks if a block is unique in its row, column and square
	private boolean unique(int i, int j) {
		SudoBlock temp = board[i][j];
		for(int col = 0; col<9; col++) {
			if(temp.getValue()==board[i][col].getValue() && col!=j)
				return false;
		}
		for(int row = 0; row<9; row++) {
			if(temp.getValue()==board[row][j].getValue() && row!=i)
				return false;
		}
		
		int blockBaseRow , blockBaseColumn;

		if(i<6) { if(i<3) {blockBaseRow = 0;} else {blockBaseRow = 3;} }else { blockBaseRow = 6;}

		if(j<6) { if(j<3) {blockBaseColumn = 0;} else {blockBaseColumn = 3;} }else { blockBaseColumn = 6;}
		
		for(int row=blockBaseRow; row<blockBaseRow+3; row++) {
			for(int column=blockBaseColumn; column<blockBaseColumn+3; column++) {
				if(row!=i && column!=j && temp.getValue()==board[row][column].getValue() )
					return false;
			}	
		}
		
		return true;
		
	}

	//returns true if solved and false otherwise
	@Override
	public boolean isSolved() {
		for(int i=0;i<board.length; i++) {
			for(int j=0;j<board[i].length; j++) {
				if(this.board[i][j].isBlank()||!unique(i,j)) return false; //if there is an incorrect block then the Nonogram isn't solved
			}
		}
		return true;
		
	}

	//flips the block between filled and not filled
	@Override
	public boolean changeBlock(int x, int y, int k) {
		if((x<0)||(y<0)||(board.length<=x)||(board[x].length<=y))
			return false;
		
		
		board[x][y].setValue(k);
		return true;
	}
	
	//generate a random board
	private void generateRandom() {
		board = new SudoBlock[9][9];
		Random r= new Random(System.currentTimeMillis());
		for(int i=0;i<board.length; i++) {
			for(int j=0;j<board[i].length; j++) {
				if(r.nextBoolean() && r.nextBoolean()) {
					board[i][j] = new SudoBlock( r.nextInt(9)+1 , true);
				}else {
					board[i][j] = new SudoBlock(0, false);
				}
			}
		}
	}
	
	public String getBlockValue(int i, int j) {
		return this.board[i][j].toString();
	}

	@Override
	public String toString() {
		String str= "\n";
		str+= "---------\n";
		for(int i=0;i<board.length; i++) {
			for(int j=0;j<board[i].length; j++) {
				str+=(board[i][j]).toString();
			}
			str+="\n";
		}
		str+= "---------";
		
		return str;
	}


}
