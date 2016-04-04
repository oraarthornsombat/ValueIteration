public class ValueIteration {
	private static double[][] grid = new double[7][7];
	private static double gamma = 1;
	private static double epsilon = .001;
	private static int maxIters = 1000;
	private static double[][] oldGrid = new double[7][7];

	public static double getReward(int i, int j) {
		if (i == 3 && j == 6) {
			return 0;
		} else {
			return -1;
		}
	}

	public static double getMaxValue(int i, int j, int wind) {

		if (wind == 0) {
			double max = Double.NEGATIVE_INFINITY;
			// check N
			if (i > 0) {
				if (oldGrid[i - 1][j] > max) {
					max = oldGrid[i - 1][j];
				}
			}
			// check NE
			if (i > 0 && j < 6) {
				if (oldGrid[i - 1][j + 1] > max) {
					max = oldGrid[i - 1][j + 1];
				}
			}
			// check E
			if (j < 6) {
				if (oldGrid[i][j + 1] > max) {
					max = oldGrid[i][j + 1];
				}
			}
			// check SE
			if (i < 6 && j < 6) {
				if (oldGrid[i + 1][j + 1] > max) {
					max = oldGrid[i + 1][j + 1];
				}
			}
			// check S
			if (i < 6) {
				if (oldGrid[i + 1][j] > max) {
					max = oldGrid[i + 1][j];
				}
			}
			// check SW
			if (i < 6 && j > 0) {
				if (oldGrid[i + 1][j - 1] > max) {
					max = oldGrid[i + 1][j - 1];
				}
			}
			// check W
			if (j > 0) {
				if (oldGrid[i][j - 1] > max) {
					max = oldGrid[i][j - 1];
				}
			}
			// check NW
			if (i > 0 && j > 0) {
				if (oldGrid[i - 1][j - 1] > max) {
					max = oldGrid[i - 1][j - 1];
				}
			}
			// check current
			if (oldGrid[i][j] > max) {
				max = oldGrid[i][j];
			}
			return max;
		} else if (wind == 1) {
			// case 1
			double max = Double.NEGATIVE_INFINITY;
			return max;

		} else {
			// case 2
			double max = Double.NEGATIVE_INFINITY;
			return max;
		}
	}

	public static void findValueFunction(int wind) {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				grid[i][j] = 0;
			}
		}
		int iters = 0;
		while (iters <= maxIters) {
			iters++;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					oldGrid[i][j] = grid[i][j];
				}
			}
			double delta = 0;
			for (int i = 0; i < 7; i++) {
				for (int j = 0; j < 7; j++) {
					grid[i][j] = getReward(i, j) + gamma
							* getMaxValue(i, j, wind);
					if (Math.abs(grid[i][j] - oldGrid[i][j]) > delta) {
						delta = Math.abs(grid[i][j] - oldGrid[i][j]);
					}
				}
			}
			if (delta < epsilon) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int wind = 0;
		findValueFunction(wind);
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(grid[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
}
