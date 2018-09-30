package Solver;

import java.util.ArrayList;

class BasicSolver implements SudokuSolver {

  Cell[][] board;
  CellGrouping[] groupings;
  ArrayList<Cell> worklist;

  public BasicSolver(int[][] b) {
    // must be an n^2 x n^2 board.
    // create board.
    this.board = new Cell[b.length][b.length];
    this.groupings = new CellGrouping[3 * b.length]; // 9 rows, 9 cols, 9 squares
    this.worklist = new ArrayList<Cell>();
    setUpBoard(b);
    createGroupings(b);
    updatePossible();
  }

  private void setUpBoard(int[][] b) {
    for (int row = 0; row < b.length; row++) {
      for (int col = 0; col < b.length; col++) {
        this.board[row][col] = new Cell(row, col, b[row][col], this);
      }
    }
  }

  private void createGroupings(int[][] b) {
    // create groupings.
    // rows
    for (int row = 0; row < b.length; row++) {
      Cell[] r = new Cell[b.length];
      CellGrouping rGroup = new CellGrouping(GroupingType.ROW);
      for (int col = 0; col < b.length; col++) {
        r[col] = this.board[row][col];
        this.board[row][col].parentGroups.add(rGroup);
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
        this.board[row][col].parentGroups.add(cGroup);
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
            this.board[row][col].parentGroups.add(sGroup);
            sCount++;
          }
        }
        sGroup.group = s;
        this.groupings[groupingCount + (2 * b.length)] = sGroup;
        groupingCount++;
      }
    }
  }

  private void updatePossible() {
    for (int row = 0; row < this.board.length; row++) {
      for (int col = 0; col < this.board.length; col++) {
        Cell c = this.board[row][col];
        if(c.possibleValues.size() == 1) {
          for (CellGrouping group : c.parentGroups) {
            group.removeFromPossible(c.possibleValues.get(0), c);
          }
        }
      }
    }
  }

  public void solve() {
    while (!solved()) {
      while (!worklist.isEmpty()) {
        Cell c = worklist.remove(0);
        board[c.row][c.col].solved = true;
        for (CellGrouping group : c.parentGroups) {
          group.removeFromPossible(c.possibleValues.get(0), c);
        }
      }

      for (CellGrouping cg : this.groupings) {
        resolvePairs(cg);
      }

      updatePossible();
    }
  }

  private void resolvePairs(CellGrouping cg) {
    for (int i = 0; i < cg.group.length - 1; i++) {
      Cell c = cg.group[i];
      if (c.possibleValues.size() == 2) {
        for (int j = i + 1 ; j < cg.group.length; j++) {
          // cg.group[j] is the matched cell
          if (c.possibleValues.equals(cg.group[j].possibleValues)) {
            cg.removeFromPossible(c.possibleValues.get(0), c, cg.group[j]);
            cg.removeFromPossible(c.possibleValues.get(1), c, cg.group[j]);
          }
        }
      }
    }
  }

  private boolean solved() {
    for (Cell[] row : board) {
      for (Cell c : row) {
        if (!c.solved) {
          return false;
        }
      }
    }
    return true;
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

  public int[][] getBoard() {
    int[][] b = new int[this.board.length][this.board.length];
    for (int row = 0; row < board.length; row++) {
      for (int col = 0; col < board.length; col++) {
        if (this.board[row][col].solved) {
          b[row][col] = this.board[row][col].possibleValues.get(0);
        }
        else {
          b[row][col] = 0;
        }
      }
    }
    return b;
  }

}
