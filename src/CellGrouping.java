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

  public void update() {
    for(Cell c : this.group) {
      if (c instanceof SolvedCell) {
        removeFromPossible(((SolvedCell) c).value);
      }
    }
  }

  private void removeFromPossible(int i) {

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
