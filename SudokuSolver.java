
public class SudokuSolver {
	static int[][] sudo = { 
		 {5,1,7,6,0,0,0,3,4},
	         {2,8,9,0,0,4,0,0,0},
	         {3,4,6,2,0,5,0,9,0},
	         {6,0,2,0,0,0,0,1,0},
	         {0,3,8,0,0,6,0,4,7},
	         {0,0,0,0,0,0,0,0,0},
	         {0,9,0,0,0,0,0,7,8},
	         {7,0,3,4,0,0,5,6,0},
	         {0,0,0,0,0,0,0,0,0}
	         };

	
	
	static boolean checkHorizontal(int spalte, int wert) {
		for (int i = 0; i < sudo.length; i++) {
			if (sudo[spalte][i] == wert)
				return false;
		}
		return true;
	}
	static boolean checkVertikal(int reihe, int wert) {
		for (int i = 0; i < sudo.length; i++) {
			if (sudo[i][reihe] == wert) 
				return false;
			
		}
		return true;
	}
	static boolean checkQuadrat(int spalte, int reihe, int wert) {
		int x = spalte - spalte % 3;
		int y = reihe - reihe % 3;
		for (int i = x; i < x + 3; i++) {
			for (int j = y; j < y + 3; j++) {
				if (sudo[i][j] == wert)
					return false;
			}
		}
		return true;
	}
	
	static boolean check(int spalte, int reihe, int wert) {
		return checkHorizontal(spalte, wert) && checkVertikal(reihe, wert) && checkQuadrat(spalte, reihe, wert);
	}
	
	static void solve() {
			for (int i = 0; i < sudo.length; i++) {
				for (int j = 0; j < sudo.length; j++) {
					if (sudo[i][j] == 0) {
						for (int x = 1; x <= 9; x++) {
							if (check(i,j,x)) {
								sudo[i][j] = x;
								solve();
								sudo[i][j] = 0;
							}
						}
						return;
					}
				}
			}
			print();
		}
	
	
	static void print() {
		for (int i = 0; i < sudo.length; i++) {
			System.out.println();
			for (int j = 0; j < sudo.length; j++) {
				System.out.print(sudo[i][j] + " ");
			}
		}
	}

	

	public static void main(String[] args) {
		solve();
	
		
	}

}
