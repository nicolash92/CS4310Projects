package com.homework5.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import com.homework5.GUI.controllers.MineSweeperController;
import com.homework5.GUI.controllers.NonogramController;
import com.homework5.GUI.controllers.SudokuController;
import com.homework5.model.board.NonoBoard;
import com.homework5.model.board.SudoBoard;
import com.homework5.model.board.SweeperBoard;

public class MainFX extends Application {
	private static MainFX mainFX;
	private static Stage stage;
	
	public static MainFX getMainFX() {
		return mainFX;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		mainFX=this;
		stage=primaryStage;
		
		Parent root = FXMLLoader.load(getClass().getResource("view.fxml"));
		primaryStage.setTitle("Grid Games!");
		primaryStage.setScene(new Scene(root, 400, 200));
		primaryStage.show();
	}
	
	public void startNonogram() throws Exception {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("nonogram-view.fxml"));
		Parent root = loader.load();
		((NonogramController) loader.getController()).setBoard(new NonoBoard(), root);
		stage.setTitle("Nonogram!");
		stage.setScene(new Scene(root, 800, 600));
		stage.show();
	}
	
	public void startSudoku() throws Exception {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("sudoku-view.fxml"));
		Parent root = loader.load();
		((SudokuController) loader.getController()).setBoard(new SudoBoard(), root);
		stage.setTitle("Sudoku!");
		stage.setScene(new Scene(root, 800, 600));
		stage.show();
		
	}
	
	public void startMineSweeper() throws Exception {
		FXMLLoader loader= new FXMLLoader(getClass().getResource("minesweeper-view.fxml"));
		Parent root = loader.load();
		((MineSweeperController) loader.getController()).setBoard(new SweeperBoard(), root);
		stage.setTitle("Mine Sweeper");
		stage.setScene(new Scene(root, 800, 600));
		stage.show();
	}

}
