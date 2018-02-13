package com.se.view;


import javafx.stage.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class menu {
	
	static int switch_num;
	
	public static int display(String title) {
		Stage window = new Stage();						//Creating a new window
		window.initModality(Modality.APPLICATION_MODAL);	//Can't exit out of screen
		window.setTitle(title);
		
		//Creating buttons
		Button reminder_button = new Button("Reminder"); 
		Button countdown_button = new Button("Timer");
		
		
		//Click and will set answer
		reminder_button.setOnAction(e ->	{
			switch_num = 1;
			window.close();
		});
		
		countdown_button.setOnAction(e -> {
			switch_num = 2;
			window.close();
		});
		
		//Layout
		HBox layout = new HBox();
		layout.getChildren().addAll(reminder_button, countdown_button);
		layout.setAlignment(Pos.CENTER);
		Scene scene = new Scene(layout, 150, 50);
		window.setScene(scene);
		window.showAndWait();;
		
		return switch_num;
	}
}
