package com.se.view;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class countdown {
	int time;
	
	public int display(String title) {
		Stage window = new Stage();
		
		//Creating a GridPane container
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
		grid.setVgap(5);
		grid.setHgap(5);
		
		//Define a field
		//Hours
		TextField hour = setField("Hour.");
		grid = setGride(grid, hour, 0, 0);
		
		//Minutes
		TextField min = setField("Min.");
		grid = setGride(grid, min, 0, 1);
		
		//Seconds
		TextField sec = setField("Sec.");
		grid = setGride(grid, sec, 0, 2);
		
		//Button 
		//Submit
		Button submit = new Button("Submit");
		grid = setGride(grid, submit, 1, 0);
		
		//Clear
		Button clear = new Button("Clear");
		grid = setGride(grid, clear, 1, 1);
		
		//Setting an action
		submit.setOnAction(e -> {
			int hours = ConvertToInt(hour.getText());
			int mins = ConvertToInt(min.getText());
			int seconds = ConvertToInt(sec.getText());
			
			time = convertToSeconds(hours, mins, seconds);
			
			window.close();
		});
		
		clear.setOnAction(e -> {
			hour.clear();
			min.clear();
			sec.clear();
		});
		
		Scene scene = new Scene(grid, 240, 110);
		
		window.setScene(scene);
		window.setTitle(title);
		
		window.showAndWait();;
		
		return time;
	}
	
	private int convertToSeconds(int hours, int mins, int seconds) {
		
		return ((hours * 3600) + (mins * 60) + seconds);
	}

	private GridPane setGride(GridPane grid, Node child, int column, int row) {
		GridPane.setConstraints(child, column, row);
		grid.getChildren().add(child);
		
		return grid;
	}

	private TextField setField(String title) {
		TextField temp = new TextField();
		temp.setPromptText(title);
		temp.setPrefColumnCount(10);
		
		return temp;
	}
	
	private int ConvertToInt(String text) {
	
		if(text.isEmpty())
			return 0;
		
		return Integer.parseInt(text);
		
	}
	
}
