package recursive;

public class RecursiveMain {

	public static void main(String[] args) {
		RecHanoi testTower = new RecHanoi(5);
		RecHanoi testTowerTwo = new RecHanoi(5);
		
		testTower.displayTowers();
		
		testTower.moveTower(3);
		
		testTower.displayTowers();
		
		testTowerTwo.displayTowers();
		
		testTowerTwo.moveTower(2);
		
		testTowerTwo.displayTowers();

	}

}
