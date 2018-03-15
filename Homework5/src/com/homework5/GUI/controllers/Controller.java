package com.homework5.GUI.controllers;

import com.homework5.GUI.MainFX;

public class Controller {
	
	public void runSudoku() throws Exception {

		MainFX.getMainFX().startSudoku();
	}
	
	public void runNonogram() throws Exception {
		MainFX.getMainFX().startNonogram();
	}
	public void runMineSweeper() throws Exception {
		MainFX.getMainFX().startMineSweeper();
	}
}
