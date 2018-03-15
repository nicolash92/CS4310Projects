package com.homework2.GUI.controllers;

import com.homework2.model.board.GridGame;
import com.homework2.model.board.NonoBoard;
import com.homework2.model.board.SudoBoard;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class SudokuController {

	private GridGame sudoBoard;
	private static String btnStyle="-fx-min-width: 40;-fx-min-height: 40;";

	public void setBoard(SudoBoard sudoBoard, Parent root) {
		this.sudoBoard=sudoBoard;
		this.sudoBoard.getGame();
		for(int i=1; i<10; i++) {
			for(int j=1; j<10; j++) {
				((Button)root.lookup("#"+i+""+j)).setText(((SudoBoard)this.sudoBoard).getBlockValue(i-1, j-1));
			}
		}
	}
	
	public void onButtonClick(ActionEvent e) {

		if(!this.sudoBoard.isSolved()) {
			Button btn = ((Button) e.getSource());
			int i=Integer.parseInt(btn.getId().substring(0, 1))-1;
			int j=Integer.parseInt(btn.getId().substring(1, 2))-1;
			int k;
			try {
				k=Integer.parseInt(((SudoBoard)this.sudoBoard).getBlockValue(i, j))+1;
			}catch(Exception ex) {
				k=1;
			}
			System.out.println("------------ "+k);
			this.sudoBoard.changeBlock(i,j, k);
			btn.setText(((SudoBoard)this.sudoBoard).getBlockValue(i, j));
			System.out.println("********** Board ***********");
			System.out.println(((SudoBoard)this.sudoBoard).toString());
			System.out.println("*********************");
			if(this.sudoBoard.isSolved()) {
				Stage stage = (Stage) btn.getScene().getWindow();
				stage.setTitle("You Win!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
}
