package other;

class Maze {
    private String[][] grid;
    private int row; //行长
    private int column; //列长

    private Maze() {

    }

    public Maze(int row, int column) {
        if (row > 0 && column > 0) {
            this.row = row;
            this.column = column;
            grid = new String[row][column];
        }
    }

    /**
     * 初始化网格为墙网格
     *
     * @return 初始化成功，返回 true，否则，返回false
     */
    public void init() {
        for (int indexRow = 0; indexRow < this.row; indexRow++) {
            for (int indexColumn = 0; indexColumn < this.column; indexColumn++) {
                if ((indexRow - 1) % 2 == 0 && (indexColumn - 1) % 2 == 0)
                    // 设置道路网格
                    grid[indexRow][indexColumn] = GridType.RoadGrid.toString();
                else
                    // 设置墙网格
                    grid[indexRow][indexColumn] = GridType.WallGrid.toString();
            }
        }
    }

    /**
     * 渲染网格
     *
     * @return
     */
    public String Render() {
        StringBuilder strBuilder = new StringBuilder();
        for (int indexRow = 0; indexRow < this.row; indexRow++) {
            for (int indexColumn = 0; indexColumn < this.column; indexColumn++) {
                strBuilder.append(grid[indexRow][indexColumn]);
                if (indexColumn < this.column - 1)
                    strBuilder.append(" ");
            }
            if (indexRow < this.row - 1)
                strBuilder.append("\n");
        }
        return strBuilder.toString();
    }

    /**
     * grid 数组是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return this.row > 0 && this.column > 0;
    }

    /**
     * Set Road Gird According to Coordinates
     *
     * @param x Coordinate x
     * @param y Coordinate y
     */
    public void setRoadGrid(int x, int y) {
        grid[x][y] = GridType.RoadGrid.toString();
    }

    /**
     * 判断路网格是否连通
     * @return 连通返回 true，否则返回 null
     */
    public boolean isConnnected() {
        if (this.row < 3 || this.column < 3) {
            // 迷宫至少有3行3列
            return false;
        } else if (3 == this.row && 3 == this.column) {
            // 迷宫为3行3列时，若第2行第2列为路，返回true
            if (!grid[1][1].equals(GridType.RoadGrid.toString()))
                return false;
        } else {
            for (int rowIndex = 1; rowIndex < this.row - 1; rowIndex = 2 * rowIndex + 1) {
                for (int columnIndex = 1; columnIndex < this.row - 1; columnIndex = columnIndex * 2 + 1) {
                    // 若某一路节点上下左右没有一个路节点，则说明该路节点没有联通，返回false
                    if (!(grid[rowIndex - 1][columnIndex].equals(GridType.RoadGrid.toString())
                            || grid[rowIndex + 1][columnIndex].equals(GridType.RoadGrid.toString())
                            || grid[rowIndex][columnIndex - 1].equals(GridType.RoadGrid.toString())
                            || grid[rowIndex][columnIndex + 1].equals(GridType.RoadGrid.toString())))
                        return false;
                }
            }
        }
        return true;
    }
}