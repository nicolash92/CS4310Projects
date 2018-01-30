package com.homework2.GUI.controllers;

import com.homework2.GUI.MainFX;

import javafx.event.ActionEvent;

public class Controller {
	
	public void runSudoku() throws Exception {

		MainFX.getMainFX().startSudoku();
	}
	
	public void runNonogram() throws Exception {
		MainFX.getMainFX().startNonogram();
	}
}
