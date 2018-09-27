class CellGrouping {
  public Cell[] group;
  public GroupingType type;

  CellGrouping(GroupingType type) {
    this.type = type;
    this.group = null;
  }

  public int getHeadRow() {
    return this.group[0].row;
  }

  public int getHeadCol() {
    return this.group[0].col;
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
