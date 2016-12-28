package recursive;

/**
 * This class is part of a project to implement and demonstrate a recursive solution to Towers of Hanoi.
 * The user provides a tower size (or the default of 5 is used) and the then sorts the objects. The output
 * can be displayed so that at each stage the changes are demonstrated.
 * 
 * @author dtow1
 * 12/28/2016
 */
public class RecHanoi{
	private Plate[] pegOne, pegTwo, pegThree; 	//The pegs/towers
	private int pegOneTop,pegTwoTop,pegThreeTop;//The top of the tower pointer
	private int size;							//The size of each tower
	private boolean autoDisplay;				//Flag to indicate if the towers should be displayed after each change or not.
	
	
	/**
	 *  Default constructor. Calls the other constructor with a size of 5.
	 */
	RecHanoi(){
		this(5);
	}

	/**
	 * Constructor. Initializes the three pegs and sets automatic display of the pegs to off.
	 * @param size - The size of the towers
	 */
	RecHanoi(int size){
		this.size=size;
		pegOne = new Plate[size];
		pegTwo = new Plate[size];
		pegThree = new Plate[size];
		
		//Initialize each tower to an empty value.
		for(int i=0; i<size;i++){
			pegOne[size-(i+1)]=new Plate(i+1); 	//Initialize from largest to smallest so you can tell 
												//at a glance that larger values are always below smaller values.
			pegTwo[i]=null;
			pegThree[i]=null;
		}
		autoDisplay=false;
	}
	
	
	/**
	 * Method to begin the tower transfer. Initial peg will always be peg one, so the user only needs to specify the destination
	 * peg. With this version of the towers of Hanoi, you can choose to have the tower rebuilt on peg 2 or peg 3.
	 *
	 * @param end - Peg that will hold the final tower
	 */
	public int moveTower(int targetPeg){
		if(targetPeg!=2 && targetPeg!=3){
			throw new IllegalArgumentException("Only peg 2 and peg 3 are valid targets for the tower move");
		}
		//Since only 2 or 3 should get to this point, else handles 3
		if(targetPeg==2){
			return moveTowerHelper(size,pegOne,pegTwo,pegThree);
		}else{
			return moveTowerHelper(size,pegOne,pegThree,pegTwo);
		}

	}
	
	/**
	 * Private method to hold the recursive logic. This method will control when each plate is moved to another peg.
	 * 
	 * @param count - Variable for the number of moves used so far.
	 * @param startPeg - The starting peg for this move.
	 * @param endPeg - The destination peg for this move.
	 * @param tempPeg - The temporary peg that can be used if multiple plates need to be moved
	 * @return = returns the number of moves used so far.
	 */
	private int moveTowerHelper(int size, Plate[] startPeg, Plate[] endPeg, Plate[] tempPeg){
		int count=0;
		if(size==1){
			movePlate(startPeg,endPeg);
			return count++;
		}else{
			count+=moveTowerHelper(size-1,startPeg,tempPeg,endPeg);
			movePlate(startPeg,endPeg);
			count++;
			count+=moveTowerHelper(size-1,tempPeg,endPeg,startPeg);
			return count;
		}
	}
	
	
	/**
	 * Private method to complete the actual move of a plate.
	 * 
	 * @param startPeg - Peg that a plate will be moved from
	 * @param endPeg - Peg that a plate will be moved to
	 */
	private void movePlate(Plate[] startPeg, Plate[] endPeg){
		
			if(startPeg[0]!=null){
				int startPegTop=0;
				int endPegTop=0;
				for(Plate start: startPeg){
					if(start!=null){
						startPegTop++;
					}
				}
				for(Plate end: endPeg){
					if(end!=null){
						endPegTop++;
					}
				}
				
				endPeg[endPegTop]=startPeg[startPegTop-1];
				startPeg[startPegTop-1]=null;
				if(autoDisplay){
					displayTowers();
				}
			}


	}
	
	/**
	 * Method to display the contents of each peg.
	 */
	public void displayTowers(){
		System.out.print("Tower 1: ");
		for(int i=0;i<size && pegOne[i]!=null; i++){
			System.out.print(pegOne[i].getNumber() + " ");
		}
		
		System.out.print("\nTower 2: ");
		for(int i=0;i<size && pegTwo[i]!=null; i++){
			System.out.print(pegTwo[i].getNumber() + " ");
		}
		
		System.out.print("\nTower 3: ");
		for(int i=0;i<size && pegThree[i]!=null; i++){
			System.out.print(pegThree[i].getNumber() + " ");
		}
		System.out.println();
	}
	
	
	
	
	/**
	 * Getter for the size
	 * @return - Number of plates in the tower.
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Setter for the size
	 * @param size = value to set the number of plates in the tower.
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Method to toggle verbose/automatic tower status printouts.
	 * @param autoDisplay - true to enable verbose, false to disable verbose.
	 */
	public void setAutoDisplay(boolean autoDisplay) {
		this.autoDisplay = autoDisplay;
	}




	/**
	 * Private class to hold plate objects. Plate objects are essential just holding integer values, but by creating
	 * objects, there is something to actually move around and display instead of just finding how many moves the 
	 * transfer takes. It also allows me to expand and add functionality later, for example if I wish to do an implementation
	 * based on linked lists instead of arrays.
	 * 
	 * @author dtow1
	 * 12/28/2016
	 */
	private class Plate{
		private int number;
		
		/**
		 * The number of the plate object. This is really the final/initial stack position for this plate.
		 * @param number
		 */
		Plate(int number){
			this.number=number;
		}

		/**
		 * Getter for the plate number
		 * @return - the number for this plate
		 */
		public int getNumber() {
			return number;
		}

		/**
		 * Setter for the plate number
		 * @param number - the setter for this plate
		 */
		public void setNumber(int number) {
			this.number = number;
		}

	}
	
}
