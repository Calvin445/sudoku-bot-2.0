import java.util.ArrayList;

abstract class Cell {
  public int row;
  public int col;
  public CellGrouping parentGroup;

  public abstract String toString();
}

class SolvedCell extends Cell {
  public int value;

  SolvedCell(int row, int col, int value) {
    this.row = row;
    this.col = col;
    this.value = value;
    this.parentGroup = null; // to be assigned later.
  }

  public String toString() {
    return this.value + " ";
  }

}

class UnsolvedCell extends Cell {
  public ArrayList<Integer> possibleValues;

  UnsolvedCell(int row, int col) {
    this.row = row;
    this.col = col;
    this.possibleValues = new ArrayList<Integer>();
  }

  public String toString() {
    return "_ ";
  }
}
