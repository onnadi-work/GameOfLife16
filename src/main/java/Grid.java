import java.util.Arrays;

public class Grid {
    private static final int DEAD = 0;
    private static final int ALIVE = 1;
    private static final int UNDERPOPULATION_LIMIT = 2;
    private static final int OVERPOPULATION_LIMIT = 3;
    private static final int RESURRECTION_COUNT = 3;
    int cells[][];
    int xLength;
    int yLength;

    public Grid(int xLength, int yLength, int fill) {
        this.xLength = xLength;
        this.yLength = yLength;
        cells = new int[yLength][xLength];

        for(int y = 0; y < yLength; y++){
            for(int x = 0; x < xLength; x++){
                setCell(x, y, fill);
            }
        }
    }

    public int countNeighbors(int x, int y) {
        return getCell(x-1, y-1) + getCell(x, y-1) + getCell(x+1, y-1) +
                getCell(x-1, y)  + getCell(x+1, y) +
                getCell(x-1, y+1) + getCell(x, y+1) + getCell(x+1, y+1);
    }

    private int getCell(int x, int y) {
        if(x < 0 || x >= xLength || y < 0 || y >= yLength){
            return DEAD;
        }
        return cells[y][x];
    }

    public void setCell(int x, int y, int cell) {
        cells[y][x] = cell;
    }

    public int nextCell(int x, int y, int numNeighbors) {
        if(getCell(x, y) == ALIVE && (numNeighbors < UNDERPOPULATION_LIMIT || numNeighbors > OVERPOPULATION_LIMIT)){
            return DEAD;
        }else if(getCell(x, y) == DEAD && numNeighbors != RESURRECTION_COUNT){
            return DEAD;
        }
        return ALIVE;
    }

    public Grid next() {
        Grid returnValue = new Grid(xLength, yLength, DEAD);

        for(int y = 0; y < yLength; y++){
            for(int x = 0; x < xLength; x++){
                returnValue.setCell(x, y, nextCell(x, y, countNeighbors(x, y)));
            }
        }

        return returnValue;
    }

    @Override
    public String toString() {
        return Arrays.deepToString(cells);
    }

    @Override
    public boolean equals(Object obj) {
        return Arrays.deepEquals(cells, ((Grid)obj).cells);
    }
}
