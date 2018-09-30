package Solver;

import java.util.ArrayList;
import java.util.Arrays;

class Cell {
  int row;
  int col;
  ArrayList<CellGrouping> parentGroups;
  BasicSolver solver;
  boolean solved;
  ArrayList<Integer> possibleValues;

  Cell(int row, int col, int value, BasicSolver solver) {
    this.row = row;
    this.col = col;
    this.solved = (value != 0);
    this.parentGroups = new ArrayList<CellGrouping>();
    this.solver = solver;
    if (this.solved) {
      this.possibleValues = new ArrayList<Integer>();
      this.possibleValues.add(value);
    }
    else {
      this.possibleValues = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    }
  }

  void checkNewSolved() {
    if (!solved && possibleValues.size() == 1) {
      solver.worklist.add(this);
      this.solved = true;
    }

  }

  public String toString() {
    if (solved) {
      return possibleValues.get(0) + " ";
    }
    else {
      return "_ ";
    }
  }
}
