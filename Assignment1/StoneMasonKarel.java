/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	private static final int COLUMN_SEPARATOR = 4;

	// You fill in this part
	public void run() {
		while(true) { //while not at the end of the wall
			handleColumn();
			moveToNextColumn();
			if (!frontIsClear()) {
				break;
			}
		}
		handleColumn(); //perform this one last time
	}
	
	private void moveToNextColumn() {
		faceEast();
		for (int i=0; i<COLUMN_SEPARATOR; i++) {
			move();
		}
	}
	
	private void faceEast() {
		while (notFacingEast()) {
			turnLeft();
		}
	}
	
	/*
	 * Assuming that Karel is facing East
	 */
	private void handleColumn() {
		turnLeft();
		while(true) {
			if (noBeepersPresent()) {
				putBeeper();
			}
			if (!frontIsClear()) {
				break;
			}
			move();
		}
		turnAround();
		while(frontIsClear()) {
			move();
		}
	}
}