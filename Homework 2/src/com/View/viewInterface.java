package com.View;

public interface viewInterface{
	
//start() method is a UI and should be the starting point of the class
// the interface ask the user to make a section on following input(int) values
// returns input(int)
public void start();

//getRow() returns row(int) 
public int getRow();

public void setRow();

//getColumn() returns column(int) 
public int getColumn();

public void setColumn();

//move() method allows the user to make a move to the board
// return nothing. It updates board in this method
public userMove move();

//checkValid() method checks to see if user input is correct
//parameters min and max value, returns valid input
public int checkValid(int min, int max);

//printBoard() method prints the board, and does not passes any parameters
// no return
public void printBoard();

}
