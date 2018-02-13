package com.se.controller;

import com.se.view.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class uiController extends Application{
	Stage window;
	menu menu; 
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception{
		
		int result = new menu().display("Reminder");

		switch(result) {
		case 1:
			new reminder().display("Alarm");
			
			break;
			
		case 2:
			int vaule = new countdown().display("Timer");
			System.out.print(vaule);
			break;
			
		}
		
	}

	

}
