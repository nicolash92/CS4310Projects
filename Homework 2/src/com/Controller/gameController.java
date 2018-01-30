package com.Controller;

import com.View.*;
import com.homework2.model.board.GridGame;
import com.homework2.model.board.NonoBoard;
import com.homework2.model.board.SudoBoard;

public class gameController {

	public gameController() {
		// TODO Auto-generated method stub
		userMove user_move;
		viewConsole console = new viewConsole();
		
		switch(console.start()){
		case 1:
			viewSudoku con_Sudo = new viewSudoku();
			GridGame board_Sudo = new SudoBoard();
			board_Sudo.getGame();	//Loading board
			con_Sudo.start();		//Starting game
			
			
			do {
				System.out.println (board_Sudo.toString());
				user_move = con_Sudo.move();
				board_Sudo.changeBlock(user_move.getRow(), user_move.getColumn(), user_move.getInput());
			}while(!board_Sudo.isSolved());
			
			
			break;
			
		case 2:
			viewNonogram con_Nono = new viewNonogram();
			GridGame board_Nono = new NonoBoard();
			board_Nono.getGame();	//Loading board
			con_Nono.start();		//Starting game
			
			do {
				System.out.println(board_Nono.toString());
				user_move = con_Nono.move();
				board_Nono.changeBlock(user_move.getRow(), user_move.getColumn(), user_move.getInput());
				
			}while(!board_Nono.isSolved());
			break;
			
		default:
			System.exit(0);
			
		}	
	}

}
