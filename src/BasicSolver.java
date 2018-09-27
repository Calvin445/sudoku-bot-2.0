import java.util.ArrayList;

class BasicSolver implements SudokuSolver {

  Cell[][] board;
  CellGrouping[] groupings;

  public BasicSolver(int[][] b) {
    // must be an n^2 x n^2 board.
    // create board.
    this.board = new Cell[b.length][b.length];
    for (int row = 0; row < b.length; row++) {
      for (int col = 0; col < b.length; col++) {
        if (b[row][col] == 0) {
          this.board[row][col] = new UnsolvedCell(row, col);
        }
        else {
          this.board[row][col] = new SolvedCell(row, col, b[row][col]);
        }
      }
    }
    // create groupings.
    this.groupings = new CellGrouping[3 * b.length]; // 9 rows, 9 cols, 9 squares
    // rows
    for (int row = 0; row < b.length; row++) {
      Cell[] r = new Cell[b.length];
      CellGrouping rGroup = new CellGrouping(GroupingType.ROW);
      for (int col = 0; col < b.length; col++) {
        r[col] = this.board[row][col];
        this.board[row][col].parentGroup = rGroup;
      }
      rGroup.group = r;
      this.groupings[row] = rGroup;
    }
    // cols
    for (int col = 0; col < b.length; col++) {
      Cell[] c = new Cell[b.length];
      CellGrouping cGroup = new CellGrouping(GroupingType.COLUMN);
      for (int row = 0; row < b.length; row++) {
        c[row] = this.board[row][col];
        this.board[row][col].parentGroup = cGroup;
      }
      cGroup.group = c;
      this.groupings[col + b.length] = cGroup;
    }
    // squares
    int groupingCount = 0;
    for (int headRow = 0; headRow < b.length; headRow += 3) {
      for (int headCol = 0; headCol < b.length; headCol += 3) {
        Cell[] s = new Cell[b.length];
        CellGrouping sGroup = new CellGrouping(GroupingType.SQUARE);
        int sCount = 0;
        for (int row = headRow; row < headRow + 3; row++) {
          for (int col = headCol; col < headCol + 3; col++) {
            s[sCount] = this.board[row][col];
            this.board[row][col].parentGroup = sGroup;
            sCount++;
          }
        }
        sGroup.group = s;
        this.groupings[groupingCount + (2 * b.length)] = sGroup;
        groupingCount++;
      }
    }
  }

  public int[][] solve() {
    // TODO
    return new int[0][0];
  }

  public String toString() {
    String s = "";
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board.length; col++) {
        s += this.board[row][col].toString();
      }
      s += "\n";
    }
    return s;
  }

}
