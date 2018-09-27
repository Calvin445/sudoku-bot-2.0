import java.io.File;

public class SudokuBot {

  public static void main(String[] args) {

    SudokuReader reader = new PixelOCR(new File("sudoku.png"));
    int[][] originalBoard = reader.readToGrid();
    SudokuSolver solver = new BasicSolver(originalBoard);
    int[][] solvedBoard = solver.solve();

    System.out.println("Original Board:");
    System.out.println(printBoard(originalBoard));

    System.out.println("Solved Board:");
    System.out.println(printBoard(solvedBoard));
  }

  private static String printBoard(int[][] originalBoard) {
    String s = "";
    for(int[] row : originalBoard) {
      for(int cell : row) {
        s += (cell + " ");
      }
      s += "\n";
    }
    return s;
  }
}
