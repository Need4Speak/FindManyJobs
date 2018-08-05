package other;

/**
 * 结果信息常量
 */
enum Result {
    Right(100, "No Error"),  //无错
    NullPointerError(300, "Null Pointer Error."),  //空指针错误
    NumberFormartError(400, "Incorrect number format."),  //数字格式错误
    OutOfRangeError(401, "Number out of range. "),  //数字大小错误
    CommandFormartError(402, "Incorrect command format."),  //命令格式错误
    MazeFormartError(403, "Incorrect maze format.");

    private int resultCode;
    private String message;

    Result(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    @Override
    public String toString() {
        return String.valueOf(this.message);
    }
}