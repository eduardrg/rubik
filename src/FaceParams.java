public class FaceParams {
    private int start;
    private int colInc;
    private int rowInc;

    FaceParams(int start, int colInc, int rowInc) {
        this.start = start;
        this.colInc = colInc;
        this.rowInc = rowInc;
    }
    FaceParams(int[] params) {
        if (params.length != 3) throw new IllegalArgumentException();
        this.start = start;
        this.colInc = colInc;
        this.rowInc = rowInc;
    }

    public int getStart() {
        return start;
    }

    public int getColInc() {
        return colInc;
    }

    public int getRowInc() {
        return rowInc;
    }
}
