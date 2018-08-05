package other;

import java.util.regex.Pattern;

class MazeFactory {

    public static Maze Create(String command) {
        Maze maze;
        Pattern pattern = Pattern.compile("\n");
        String[] rows = pattern.split(command);
        // 获取第一行数据
        String firstRow = rows[0];
        maze = createMaze(firstRow);

        // 获取第二行数据
        String secondRow = rows[1];
        maze = addRoadGrid(maze, secondRow);
        return maze;
    }

    /**
     * 根据输入中的行列初始化 maze
     *
     * @param firstRow 第一行输入
     * @return 初始化的 maze 对象
     */
    public static Maze createMaze(String firstRow) {
        Pattern pattern = Pattern.compile("[ ]+");
        String[] gridSize = pattern.split(firstRow);
        int row = Integer.parseInt(gridSize[0]);
        int column = Integer.parseInt(gridSize[1]);
        Maze maze = new Maze(row * 2 + 1, column * 2 + 1);
        maze.init();
        return maze;
    }

    /**
     * 根据输入中的行列初始化 maze
     *
     * @param secondRow 第二行输入
     * @return 初始化的 maze 对象
     */
    public static Maze addRoadGrid(Maze maze, String secondRow) {
        Pattern pattern = Pattern.compile(";");
        Pattern patternSpace = Pattern.compile("[ ]+");
        Pattern patternComma = Pattern.compile(",");
        // 道路网格
        String[] roadGrids = pattern.split(secondRow);
        int roadGridsLength = roadGrids.length;
        int[] firstGrid = new int[2];
        int[] SecondGrid = new int[2];
        for (String roadGrid : roadGrids) {
            String[] grids = patternSpace.split(roadGrid);
            // 获得第一个网格的坐标
            String[] gridOne = patternComma.split(grids[0]);
            firstGrid[0] = Integer.parseInt(gridOne[0]);
            firstGrid[1] = Integer.parseInt(gridOne[1]);
            // 获得第二个网格的坐标
            String[] gridTwo = patternComma.split(grids[1]);
            SecondGrid[0] = Integer.parseInt(gridTwo[0]);
            SecondGrid[1] = Integer.parseInt(gridTwo[1]);

            // 将原道路网格坐标映射到maze上，并连同
            firstGrid[0] = firstGrid[0] * 2 + 1;
            firstGrid[1] = firstGrid[1] * 2 + 1;

            SecondGrid[0] = SecondGrid[0] * 2 + 1;
            SecondGrid[1] = SecondGrid[1] * 2 + 1;

            // 设置两个grid中间的grid为road grid
            maze.setRoadGrid((firstGrid[0] + SecondGrid[0]) / 2, (firstGrid[1] + SecondGrid[1]) / 2);
        }
        return maze;
    }
}