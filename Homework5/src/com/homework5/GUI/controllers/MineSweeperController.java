package com.homework5.GUI.controllers;

import com.homework5.model.board.GridGame;
import com.homework5.model.board.NonoBoard;
import com.homework5.model.board.SudoBoard;
import com.homework5.model.board.SweeperBoard;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MineSweeperController {

	private GridGame sweeperBoard;
	private static String btnStyle="-fx-min-width: 40;-fx-min-height: 40;";
	private static boolean ended=false;

	public void setBoard(SweeperBoard sweeperBoard, Parent root) {
		this.sweeperBoard=sweeperBoard;
		this.sweeperBoard.getGame();
		
	}
	
	public void onButtonClick(ActionEvent e) {
		if(!this.ended) {
			if(!this.sweeperBoard.isSolved()) {
				Button btn = ((Button) e.getSource());
				int i=Integer.parseInt(btn.getId().substring(0, 1))-1;
				int j=Integer.parseInt(btn.getId().substring(1, 2))-1;
				
				if(this.sweeperBoard.changeBlock(i,j, 0)) {
					btn.setStyle("-fx-min-width: 40;-fx-min-height: 40; -fx-background-color:#FFFFFF;");
					btn.setText(((SweeperBoard)this.sweeperBoard).countMines(i, j));
				}else {
					Stage stage = (Stage) btn.getScene().getWindow();
					stage.setTitle("boom!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					btn.setStyle("-fx-min-width: 40;-fx-min-height: 40; -fx-background-color:#FF2222;");
					ended = true;
				}
				System.out.println("********** debug Solution ***********");
				System.out.println(((SweeperBoard)this.sweeperBoard).toString());
				System.out.println("*********************");
				if(this.sweeperBoard.isSolved()) {
					Stage stage = (Stage) btn.getScene().getWindow();
					stage.setTitle("You Win!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
					ended = true;
					btn.setText(((SweeperBoard)this.sweeperBoard).countMines(i, j));
				}
			}
		}
	}
}
