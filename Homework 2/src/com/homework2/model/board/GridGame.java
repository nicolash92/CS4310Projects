package com.homework2.model.board;

public interface GridGame {

	public GridGame getGame();
	public boolean isSolved();
	public boolean changeBlock(int i, int j ,int k);
	public String toString();
}