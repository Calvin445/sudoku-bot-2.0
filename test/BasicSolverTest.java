import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BasicSolverTest {
  @Test
  public void testSolve() {
  }

  @Test
  public void testConstructor() {
    int[][] testBoard = {
            {0,0,0,5,9,0,8,0,0},
            {2,1,0,4,0,3,7,0,0},
            {0,0,0,7,0,0,0,3,0},
            {0,3,0,0,0,0,0,0,4},
            {5,9,0,0,0,0,0,0,1},
            {0,7,0,1,0,0,0,0,9},
            {0,0,0,6,0,0,1,0,7},
            {0,0,0,0,8,4,0,0,0},
            {0,0,4,0,0,0,0,0,0}
    };

    BasicSolver s = new BasicSolver(testBoard);

    String sExpected = "_ _ _ 5 9 _ 8 _ _ \n" +
            "2 1 _ 4 _ 3 7 _ _ \n" +
            "_ _ _ 7 _ _ _ 3 _ \n" +
            "_ 3 _ _ _ _ _ _ 4 \n" +
            "5 9 _ _ _ _ _ _ 1 \n" +
            "_ 7 _ 1 _ _ _ _ 9 \n" +
            "_ _ _ 6 _ _ 1 _ 7 \n" +
            "_ _ _ _ 8 4 _ _ _ \n" +
            "_ _ 4 _ _ _ _ _ _ \n";


    assertEquals(sExpected, s.toString());

    String sExpected2 = "2 1 _ 4 _ 3 7 _ _ " +
            "_ _ _ 4 1 9 7 _ _ " +
            "_ _ _ _ _ _ 1 _ _ ";

    String sActual2 = s.groupings[1].toString() +
            s.groupings[17].toString() +
            s.groupings[22].toString();


    assertEquals(sExpected2, sActual2);


  }



}