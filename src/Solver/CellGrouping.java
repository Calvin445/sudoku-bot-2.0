package Solver;

class CellGrouping {
  public Cell[] group;
  public GroupingType type;

  CellGrouping(GroupingType type) {
    this.type = type;
    this.group = null;
  }

  public void removeFromPossible(int i, Cell... exclude) {
    for (Cell toBeRemoved : this.group) {
      boolean remove = true;
      for (Cell excludedCell : exclude) {
        remove = (remove && toBeRemoved != excludedCell);
      }
      if (remove) {
        toBeRemoved.possibleValues.remove(new Integer(i));
        toBeRemoved.checkNewSolved();
      }
    }
  }

  public String toString() {
    String s = "";
    for(Cell c : group) {
      s += c.toString();
    }

    return s;
  }
}

enum GroupingType {
  ROW, COLUMN, SQUARE;
}
