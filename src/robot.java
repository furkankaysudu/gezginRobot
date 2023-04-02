public class robot {
    izgara foo = new izgara();
	int N = foo.getSize();
    
    void printSolution(int sol[][])
	{
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(" " + sol[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

	boolean isSafe(int maze[][], int x, int y)
	{
		return (x >= 1 && x < 4 && y >= 1 && y < 6 && maze[x][y] == 0);
	}


	boolean solveMaze(int maze[][])
	{
		int sol[][] = { {1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1},
						{1,1,1,1,1,1,1,1,1,1}};

		if (solveMazeUtil(maze, 1, 1, sol) == false) {
			System.out.print("Çıkış yok");
			return false;
		}

		printSolution(sol);
		return true;
	}

	boolean solveMazeUtil(int maze[][], int x, int y,
						int sol[][])
	{
		if (x == N - 1 && y == N - 1) {
			sol[x][y] = 1;
			return true;
		}

		if (isSafe(maze, x, y) == true) {
			sol[x][y] = 0;

			if (solveMazeUtil(maze, x + 1, y, sol))
				return true;
				printSolution(sol);

			if (solveMazeUtil(maze, x, y + 1, sol))
				return true;
				printSolution(sol);

			sol[x][y] = 1;
			return false;
		}

		return false;
	}
}
