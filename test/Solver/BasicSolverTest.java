package Solver;

import org.junit.Test;

import Solver.BasicSolver;

import static org.junit.Assert.*;

public class BasicSolverTest {

  @Test
  public void testSolveEasy1() {
    int[][] testBoard = {
            {0,0,8,1,0,0,6,0,5},
            {0,3,0,0,8,4,2,1,0},
            {9,1,0,2,0,0,4,0,0},
            {0,5,4,0,0,6,0,2,8},
            {1,2,9,0,0,0,5,4,0},
            {0,0,0,5,4,2,0,0,0},
            {0,0,2,0,0,0,1,6,7},
            {0,0,1,0,2,9,0,5,0},
            {5,8,0,4,7,0,0,0,0}
    };

    int[][] solution = {
            {2,4,8,1,9,3,6,7,5},
            {6,3,5,7,8,4,2,1,9},
            {9,1,7,2,6,5,4,8,3},
            {7,5,4,9,1,6,3,2,8},
            {1,2,9,8,3,7,5,4,6},
            {8,6,3,5,4,2,7,9,1},
            {4,9,2,3,5,8,1,6,7},
            {3,7,1,6,2,9,8,5,4},
            {5,8,6,4,7,1,9,3,2}
    };

    BasicSolver s = new BasicSolver(testBoard);

    long startTime = System.nanoTime();
    s.solve();
    long endTime = System.nanoTime();
    double msDuration = ((endTime - startTime) / 1000000.0);

    int[][] actual = s.getBoard();

    for (int row = 0; row < testBoard.length; row++) {
      for (int col = 0; col < testBoard.length; col++) {
        assertEquals(solution[row][col], actual[row][col]);
      }
    }

    System.out.println("Solved Easy 1 Puzzle in " + msDuration + " ms");
  }

  @Test
  public void testSolveMedium1() {
    int[][] testBoard = {
            {0,0,0,5,0,0,0,0,0},
            {2,1,6,8,0,0,0,3,0},
            {0,0,0,0,0,0,8,0,0},
            {4,0,2,0,7,0,0,0,0},
            {0,0,3,0,0,1,0,0,7},
            {5,0,0,6,4,0,9,0,0},
            {0,0,0,0,2,0,7,5,0},
            {3,9,7,0,0,0,0,2,0},
            {0,0,0,0,0,0,4,0,0}
    };

    int[][] solution = {
            {8,3,9,5,6,4,2,7,1},
            {2,1,6,8,9,7,5,3,4},
            {7,5,4,3,1,2,8,6,9},
            {4,6,2,9,7,8,3,1,5},
            {9,8,3,2,5,1,6,4,7},
            {5,7,1,6,4,3,9,8,2},
            {6,4,8,1,2,9,7,5,3},
            {3,9,7,4,8,5,1,2,6},
            {1,2,5,7,3,6,4,9,8}
    };

    BasicSolver s = new BasicSolver(testBoard);

    long startTime = System.nanoTime();
    s.solve();
    long endTime = System.nanoTime();
    double msDuration = ((endTime - startTime) / 1000000.0);

    int[][] actual = s.getBoard();

    for (int row = 0; row < testBoard.length; row++) {
      for (int col = 0; col < testBoard.length; col++) {
        assertEquals(solution[row][col], actual[row][col]);
      }
    }

    System.out.println("Solved Medium 1 Puzzle in " + msDuration + " ms");
  }

}