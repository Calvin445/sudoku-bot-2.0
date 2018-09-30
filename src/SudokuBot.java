import Solver.BasicSolver;

public class SudokuBot {

  public static void main(String[] args) {
    int[][] testBoard = {
            {0,0,0,5,0,0,0,0,0},
            {2,1,6,8,0,0,0,3,0},
            {0,0,0,0,0,0,8,0,0},
            {4,0,2,0,7,0,0,0,0},
            {0,0,3,0,0,1,0,0,7},
            {5,0,0,6,4,0,9,0,0},
            {0,0,0,0,2,0,7,5,0},
            {3,9,7,0,0,0,0,2,0},
            {0,0,0,0,0,0,4,0,0}
    };

    BasicSolver s = new BasicSolver(testBoard);

    long startTime = System.nanoTime();
    s.solve();
    long endTime = System.nanoTime();
    double msDuration = ((endTime - startTime) / 1000000.0);
    System.out.println("\nSolved Medium 1 Puzzle in " + msDuration + " ms\n");

    int[][] actual = s.getBoard();

    String pretty = "";

    for (int row = 0; row < testBoard.length; row++) {
      for (int col = 0; col < testBoard.length; col++) {
        if (testBoard[row][col] == 0) {
          pretty += "_ ";
        }
        else {
          pretty += testBoard[row][col] + " ";
        }
      }
      if (row == 4) {
        pretty += "    ->    ";
      }
      else {
        pretty += "          ";
      }
      for (int col = 0; col < testBoard.length; col++) {
        pretty += actual[row][col] + " ";
      }
      pretty += "\n";
    }

    System.out.println(pretty);
  }

}
