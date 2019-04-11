import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameOfLifeTest {

    public static final int DEAD = 0;
    private static final int ALIVE = 1;

    @Test
    public void countNeighborsReturns0Given1x1Grid() {
        assertEquals(0, new Grid(1, 1, ALIVE).countNeighbors(0, 0));
    }

    @Test
    public void countNeighborsReturns1Given3x3DeadGridWithNWAlive() {
        Grid grid = new Grid(3, 3, DEAD);
        grid.setCell(0, 0, 1);

        int actual = grid.countNeighbors(1, 1);

        assertEquals(1, actual);
    }

    @Test
    public void countNeighborsReturns1Given3x3DeadGridWithNAlive() {
        Grid grid = new Grid(3, 3, DEAD);
        grid.setCell(1, 0, 1);

        int actual = grid.countNeighbors(1, 1);

        assertEquals(1, actual);
    }

    @Test
    public void countNeighborsReturns1Given3x3DeadGridWithNEAlive() {
        Grid grid = new Grid(3, 3, DEAD);
        grid.setCell(2, 0, 1);

        int actual = grid.countNeighbors(1, 1);

        assertEquals(1, actual);
    }

    @Test
    public void countNeighborsReturns1Given3x3DeadGridWithWAlive() {
        Grid grid = new Grid(3, 3, DEAD);
        grid.setCell(0, 1, 1);

        int actual = grid.countNeighbors(1, 1);

        assertEquals(1, actual);
    }

    @Test
    public void countNeighborsReturns1Given3x3DeadGridWithEAlive() {
        Grid grid = new Grid(3, 3, DEAD);
        grid.setCell(2, 1, 1);

        int actual = grid.countNeighbors(1, 1);

        assertEquals(1, actual);
    }

    @Test
    public void countNeighborsReturns1Given3x3DeadGridWithSWAlive() {
        Grid grid = new Grid(3, 3, DEAD);
        grid.setCell(0, 2, 1);

        int actual = grid.countNeighbors(1, 1);

        assertEquals(1, actual);
    }

    @Test
    public void countNeighborsReturns1Given3x3DeadGridWithSAlive() {
        Grid grid = new Grid(3, 3, DEAD);
        grid.setCell(1, 2, 1);

        int actual = grid.countNeighbors(1, 1);

        assertEquals(1, actual);
    }

    @Test
    public void countNeighborsReturns1Given3x3DeadGridWithSEAlive() {
        Grid grid = new Grid(3, 3, DEAD);
        grid.setCell(2, 2, 1);

        int actual = grid.countNeighbors(1, 1);

        assertEquals(1, actual);
    }

    @Test
    public void countNeighborsReturns8Given3x3AlieGrid() {
        Grid grid = new Grid(3, 3, ALIVE);

        int actual = grid.countNeighbors(1, 1);

        assertEquals(8, actual);
    }

    @Test
    public void nextCellReturnsDeadGivenAliveAnd0Neighbors() {
        Grid grid = new Grid(1, 1, ALIVE);

        int actual = grid.nextCell(0, 0, 0);

        assertEquals(DEAD, actual);
    }

    @Test
    public void nextCellReturnsDeadGivenAliveAnd4Neighbors() {
        Grid grid = new Grid(1, 1, ALIVE);

        int actual = grid.nextCell(0, 0, 4);

        assertEquals(DEAD, actual);
    }

    @Test
    public void nextCellReturnsDeadGivenDeadAnd4Neighbors() {
        Grid grid = new Grid(1, 1, DEAD);

        int actual = grid.nextCell(0, 0, 4);

        assertEquals(DEAD, actual);
    }

    @Test
    public void nextReturnsDeadGridGiven1x1AliveGrid() {
        Grid expected = new Grid(1, 1, DEAD);

        Grid actual = new Grid(1, 1, ALIVE).next();

        assertEquals(expected, actual);
    }

    @Test
    public void nextReturnsAliveGridGiven2x2AliveGrid() {
        Grid expected = new Grid(2, 2, ALIVE);

        Grid actual = new Grid(2, 2, ALIVE).next();

        assertEquals(expected, actual);
    }
}
