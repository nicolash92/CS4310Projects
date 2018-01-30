package com.homework2;

import com.homework2.GUI.MainFX;

import javafx.application.Application;
import com.Controller.gameController;
import java.util.Scanner;

public class Main {

	private static Scanner scanner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=-1;
		while (true) {
			i = getchoice("[0] Console, [1] Graphical User Interface (GUI): ");
			if(i==0 || i==1)
				break;
            System.out.print("That's not a valid choice.\n");
		}
		
		switch (i) {
		case 0:
			new gameController();
			break;
			
		case 1:
			Application.launch(MainFX.class, args);
			break;
		}
	}
	
	private static int getchoice(String prompt) {
	    System.out.print(prompt);
	    while(true){
	        try {
	            scanner = new Scanner(System.in);
				return Integer.parseInt(scanner.next());
	        } catch(NumberFormatException ne) {
	            System.out.print("That's not a valid choice.\n"+prompt);
	        }
	    }
	}
}
