import java.util.ArrayList;
import java.util.Arrays;

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
    this.possibleValues = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
  }

  public String toString() {
    return "_ ";
  }
}
