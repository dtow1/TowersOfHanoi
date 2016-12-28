package recursive;

public class RecursiveMain {

	public static void main(String[] args) {
		RecHanoi testTower = new RecHanoi(5);
		RecHanoi testTowerTwo = new RecHanoi(3);
		
		
		System.out.println("Testing movement to location one.");
		testTower.displayTowers();
		
		testTower.moveTower(3);
		
		testTower.displayTowers();
		
		
		System.out.println("\n\nTesting movement to location two.");
		
		testTowerTwo.setAutoDisplay(true);
		testTowerTwo.displayTowers();
		
		testTowerTwo.moveTower(2);
		
		testTowerTwo.displayTowers();

	}

}
