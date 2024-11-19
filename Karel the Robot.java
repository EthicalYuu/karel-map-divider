import stanford.karel.*;

public class BlankKarel extends SuperKarel {

	int noSteps = 0;

	public void run() {
		int width;
		int height;
		int squareSide;

		width = moveTillEnd(false);		// Finding width of the map

		turnAround();
		moveNoSteps(width/2, false);
		faceNorth();
		height = moveTillEnd(true);		// Create vertical line and add beepers

		if(width < 5 || height < 5){
			System.out.println("Ivalid world can't create shape!");
			System.exit(1);
		}

		squareSide = (width <= height) ? width-2 : height-2;

		mapDecision(width, height);

		reposition(squareSide, width);

		createSquare(squareSide);

		fixSquare(squareSide, width, height);
	}

	public void mapDecision(int width, int height){

		if(width%2 == 0 && height%2 == 0){

			evenWidthEvenHeight(height);

		} else if(width%2 != 0 && height%2 == 0){

			oddWidthEvenHeight(height);

		} else if(width%2 == 0 && height%2 != 0){

			evenWidthOddHeight(height);

		} else {
			oddWidthOddHeight(height);
		}
	}
	public void evenWidthEvenHeight(int height){
		uTurn1();
		faceWest();
		moveTillEnd(false);
		faceNorth();
		moveNoSteps(height/2, false);
		faceEast();
		moveTillEnd(true);
		uTurn2();
		faceNorth();
		moveAndCount();
		faceWest();
	}
	public void oddWidthEvenHeight(int height){
		faceWest();
		moveTillEnd(false);
		faceSouth();
		moveNoSteps(height/2-1, false);
		faceEast();
		moveTillEnd(true);
		uTurn2();
		faceNorth();
		moveAndCount();
		faceWest();
	}
	public void evenWidthOddHeight(int height){
		uTurn1();
		faceEast();
		moveTillEnd(false);
		faceNorth();
		moveNoSteps(height/2, false);
		faceWest();
		moveTillEnd(true);
	}
	public void oddWidthOddHeight(int height){
		faceEast();
		moveTillEnd(false);
		faceSouth();
		moveNoSteps(height/2, false);
		faceWest();
		moveTillEnd(true);
	}

	public void reposition(int squareSide, int width){
		turnAround();
		if(squareSide%2 != 0 && width%2 == 0){
			moveNoSteps(width/2 - squareSide/2 - 1, false);
		} else {
			moveNoSteps(width/2 - squareSide/2, false);
		}
	}

	public void createSquare(int squareSide){
		faceSouth();
		moveNoSteps(squareSide/2 ,true);

		faceEast();
		moveNoSteps(squareSide-1,true);

		faceNorth();
		moveNoSteps(squareSide-1, true);

		faceWest();
		moveNoSteps(squareSide-1, true);

		faceSouth();
		moveNoSteps(squareSide/2 , true);
	}
	public void uTurn1(){
		faceEast();
		moveAndCount();
		faceSouth();
		moveTillEnd(true);
	}

	public void uTurn2(){
		faceSouth();
		moveAndCount();
		faceWest();
		moveTillEnd(true);
	}

	public void uTurn3(int squareSide){
		faceEast();
		moveAndCount();
		faceNorth();
		moveNoSteps(squareSide-1, true);
	}


	public void fixSquare(int squareSide, int width, int height){
		if(squareSide%2 == 0 && width%2 == 0 && height%2 != 0){
			faceEast();
			moveNoSteps(squareSide-1, true);
		} else if(squareSide%2 != 0 && width%2 == 0 && height%2 != 0){
			moveNoSteps(squareSide/2, false);
			uTurn3(squareSide);
		} else if (squareSide%2 == 0 && width%2 != 0 && height%2 == 0){
			moveNoSteps(squareSide/2-1, false);
			uTurn3(squareSide);
		}
	}

	public int moveTillEnd(Boolean withBeeper){
		int counter = 1;
		while(frontIsClear()){
			counter++;
			if(noBeepersPresent() && withBeeper) putBeeper();
			moveAndCount();
		}
		if(noBeepersPresent() && withBeeper) putBeeper();
		return counter;
	}

	public void moveNoSteps(int noSteps, boolean withBeepers){
		for(int i = 1; i<=noSteps ;i++){
			if(noBeepersPresent() && withBeepers){
				putBeeper();
			}
			moveAndCount();
		}
		if(noBeepersPresent() && withBeepers){
			putBeeper();
		}
	}

	public void faceEast(){
		while(notFacingEast()){
			turnLeft();
		}
	}
	public void faceWest(){
		while(notFacingWest()){
			turnLeft();
		}
	}
	public void faceNorth(){
		while(notFacingNorth()){
			turnLeft();
		}
	}

	public void faceSouth(){
		while(notFacingSouth()){
			turnLeft();
		}
	}

	public void moveAndCount(){
		move();
		noSteps++;
		System.out.println(noSteps);
	}

}

