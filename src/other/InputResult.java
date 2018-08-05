package other;

/**
 * 为了存储 getInput 返回值
 */
class InputResult {
    private Result result;
    private String content;

    public InputResult() {
    }

    public InputResult(Result result, String content) {
        this.result = result;
        this.content = content;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}