package other;

/**
 * 表示路或墙单元格的元素，默认路 [R]，墙 [W]
 */
enum GridType {
    RoadGrid("[R]"),
    WallGrid("[W]");

    private String symbol;

    GridType(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return String.valueOf(this.symbol);
    }
}