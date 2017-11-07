public class Cuboid {
    private int[] colors;
    Cuboid(int[] colors) {
        if (colors.length != 6) throw new IllegalArgumentException();
        this.colors = colors;
    }

    Cuboid() {
        this.colors = new int[]{0, 1, 2, 3, 4, 5};
    }

    public void rotateLeft() {
        this.colors[1] = 2;
        this.colors[2] = 3;
        this.colors[3] = 4;
        this.colors[4] = 1;
    }

    public int getColor(Cube.Face face) {
        switch (face) {
            case LEFT:
                return this.colors[4];
            case RIGHT:
                return this.colors[2];
            case TOP:
                return this.colors[1];
            case BOTTOM:
                return this.colors[3];
            case FRONT:
                return this.colors[0];
            case BACK:
                return this.colors[5];
            default:
                throw new IllegalArgumentException();
        }
    }
}
