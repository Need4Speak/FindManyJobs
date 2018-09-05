package other;

import java.util.regex.Pattern;

/**
 * 处理输入
 */
public class InputCheck {
    /**
     * 从文件中获取输入的两行数据，如
     * 3 3
     * 0,1 0,2;0,0 1,0;0,1 1,1;0,2 1,2;1,0 1,1;1,1 1,2;1,1 2,1;1,2 2,2;2,0 2,1
     *
     * @param fileName
     * @return 返回 InputResult 对象，输入出错时，该对象包含错误信息，否则包含正确的输入信息
     */
    public static InputResult getInput(String fileName) {
        InputResult inputResult = new InputResult();

        String input = FileUtil.readFile(fileName);
        Result verifyInputResult = verifyInput(input);
        if (verifyInputResult == Result.Right) {
            Pattern pattern = Pattern.compile("\n");
            String[] rows = pattern.split(input);
            // 获取第一行数据
            String firstRow = rows[0];
            // 获取第二行数据
            String secondRow = rows[1];

            //验证两行数据
            Result firstRowResult = verifyFirstRow(firstRow);
            Result secondRowResult = verifySecondRow(secondRow);

            if (firstRowResult == Result.Right && secondRowResult == Result.Right) {
                // 两行都无错时，返回读取的内容
                inputResult.setResult(Result.Right);
                inputResult.setContent(input);
            } else if (firstRowResult != Result.Right) {
                // 第一行出错时，返回出错信息
                inputResult.setResult(firstRowResult);
            } else if (secondRowResult != Result.Right) {
                // 第二行出错时，返回出错信息
                inputResult.setResult(secondRowResult);
            }
        } else {
            inputResult.setResult(verifyInputResult);
        }
        return inputResult;
    }

    /**
     * 判断输入是否正确：非空，有两行
     *
     * @param input 输入
     * @return 返回 Result信息
     */
    private static Result verifyInput(String input) {
        if (input != null) {
            input = input.trim();
            if (!input.equals("")) {
                Pattern pattern = Pattern.compile("\n");
                String[] rows = pattern.split(input);
                if (2 == rows.length) {
                    return Result.Right;
                }
            }
        }
        return Result.NullPointerError;
    }

    /**
     * 验证第一行是否有误
     *
     * @param firstRow 第一行，即 3*3，5*4
     * @return 返回 Result信息
     */
    private static Result verifyFirstRow(String firstRow) {
        if (firstRow != null) {
            firstRow = firstRow.trim();
            if (!firstRow.equals("")) {
                Pattern pattern = Pattern.compile("[ ]+");
                String[] roadGridSize = pattern.split(firstRow);
                // 如果第一行输入的参数长度不是2时，输出错误为命令格式错误
                if (2 != roadGridSize.length) {
                    return Result.CommandFormartError;
                } else if (isInteger(roadGridSize[0]) != Result.Right
                        || isInteger(roadGridSize[1]) != Result.Right) {
                    // 输入的两个数，任意一个不是数字时，输出无效数字错误
                    return Result.NumberFormartError;
                } else if (isCorrectInteger(roadGridSize[0]) != Result.Right
                        || isCorrectInteger(roadGridSize[1]) != Result.Right) {
                    // 超出范围时，输出超出预定范围错误
                    return Result.OutOfRangeError;
                }
                return Result.Right;
            }
        }
        return Result.NullPointerError;
    }

    /**
     * @param secondRow 第二行输入
     * @return 返回 Result信息
     */
    private static Result verifySecondRow(String secondRow) {
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
            String[] gridTwo = patternComma.split(grids[1]);
            if (isInteger(gridOne[0]) == Result.Right
                    && isInteger(gridOne[1]) == Result.Right
                    && isInteger(gridTwo[0]) == Result.Right
                    && isInteger(gridTwo[1]) == Result.Right) {
                firstGrid[0] = Integer.parseInt(gridOne[0]);
                firstGrid[1] = Integer.parseInt(gridOne[1]);
                // 获得第二个网格的坐标

                SecondGrid[0] = Integer.parseInt(gridTwo[0]);
                SecondGrid[1] = Integer.parseInt(gridTwo[1]);
                // 判断两个道路网格的连通关系是否正确，每一个 ​cell​ 只能够直接与相邻正南、正北、正东、正西的 ​cell​ 连通
                if (Math.abs(firstGrid[0] - SecondGrid[0]) + Math.abs(firstGrid[1] - SecondGrid[1]) != 1)
                    return Result.MazeFormartError;
            } else
                return Result.NumberFormartError;
        }
        return Result.Right;
    }


    /**
     * 判断数字是否超出预定范围
     *
     * @param str 传入的字符串
     * @return 是非0整数返回true, 否则返回false
     */
    private static Result isCorrectInteger(String str) {
        if (str == null) {
            return Result.NullPointerError;
        }

        if ((1 == str.length() && str.equals("0")) || '-' == str.charAt(0))
            return Result.OutOfRangeError;

        if (isInteger(str) == Result.Right) {
            try {
                Long.parseLong(str);
            } catch (NumberFormatException exp) {
                return Result.OutOfRangeError;
            }
            return Result.Right;
        }
        return Result.OutOfRangeError;
    }

    /**
     * 判断是否为整数
     *
     * @param str 传入的字符串
     * @return 是整数返回true, 否则返回false
     */
    private static Result isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        if (pattern.matcher(str).matches())
            return Result.Right;
        else
            return Result.NumberFormartError;
    }

}
