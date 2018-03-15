package com.homework5.GUI.controllers;

import com.homework5.model.board.GridGame;
import com.homework5.model.board.NonoBoard;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class NonogramController {

	private GridGame nonoBoard;
	private static String btnStyle="-fx-min-width: 40;-fx-min-height: 40;";

	public void setBoard(NonoBoard nonoBoard, Parent root) {
		this.nonoBoard=nonoBoard;
		this.nonoBoard.getGame();
		for(int i=1; i<10; i++) {
			((Label)root.lookup("#0"+i)).setText(((NonoBoard)this.nonoBoard).getColumnHints(i-1).replaceAll(" ", "\n"));
			((Label)root.lookup("#"+i+"0")).setText(((NonoBoard)this.nonoBoard).getRowHints(i-1));
		}
	}
	
	public void onButtonClick(ActionEvent e) {

		if(!this.nonoBoard.isSolved()) {
			Button btn = ((Button) e.getSource());
			this.nonoBoard.changeBlock(Integer.parseInt(btn.getId().substring(0, 1))-1, Integer.parseInt(btn.getId().substring(1, 2))-1, 0);
			if(btn.getStyle().matches(btnStyle)) {
				btn.setStyle("-fx-min-width: 40;-fx-min-height: 40; -fx-background-color:#111111;");
			}
			else {
				btn.setStyle(btnStyle);
			}
			System.out.println("********** Solution ***********");
			System.out.println(((NonoBoard)this.nonoBoard).showSolution());
			System.out.println("--------- Board ----------");
			System.out.println(((NonoBoard)this.nonoBoard).toString());
			System.out.println("*********************");
			if(this.nonoBoard.isSolved()) {
				Stage stage = (Stage) btn.getScene().getWindow();
				stage.setTitle("You Win!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			}
		}
	}
}
