public class Cuboid {
    private int[] colors;
    Cuboid(int[] colors) {
        if (colors.length != 6) throw new IllegalArgumentException();
        this.colors = colors;
    }

    Cuboid() {
        this.colors = new int[]{0, 1, 2, 3, 4, 5};
    }

    public void rotateLeft(Cube.Face face) {
        orientTo(face);
        swap(1,4);
        swap(1, 3);
        swap(1, 2);
        orientTo(opposite(face));
    }

    private Cube.Face opposite(Cube.Face face) {
        if (face == Cube.Face.FRONT) {
            return Cube.Face.BACK;
        } else if (face == Cube.Face.LEFT) {
            return Cube.Face.RIGHT;
        } else if (face == Cube.Face.RIGHT) {
            return Cube.Face.LEFT;
        } else if (face == Cube.Face.TOP) {
            return Cube.Face.BOTTOM;
        } else if (face == Cube.Face.BOTTOM) {
            return Cube.Face.TOP;
        } else if (face == Cube.Face.BACK) {
            return Cube.Face.FRONT;
        } else {
            throw new IllegalArgumentException(String.valueOf(face));
        }
    }

    public void orientTo(Cube.Face face) {
        if (face == Cube.Face.FRONT) {
            // do nothing
        } else if (face == Cube.Face.LEFT) {
            swap(0,2);
            swap(0, 4);
            swap(5, 4);
        } else if (face == Cube.Face.RIGHT) {
            swap(0, 2);
            swap(2,5);
            swap(4, 5);
        } else if (face == Cube.Face.TOP) {
            swap(0, 1);
            swap(0, 3);
            swap(1, 5);
        } else if (face == Cube.Face.BOTTOM) {
            swap(0, 1);
            swap(0, 3);
            swap(3, 5);
        } else if (face == Cube.Face.BACK) {
            swap(0,5);
            swap(2, 4);
        } else {
            throw new IllegalArgumentException(String.valueOf(face));
        }
            /*
        }
        switch (face) {
            case FRONT:
                // do nothing
            case LEFT:
                swap(0,4);
                swap(2, 4);
                swap(2, 5);
            case RIGHT:
                swap(0, 2);
                swap(2,5);
                swap(4, 5);
            case TOP:
                swap(0, 1);
                swap(0, 3);
                swap(1, 5);
            case BOTTOM:
                swap(0, 1);
                swap(0, 3);
                swap(3, 5);
            case BACK:
                swap(0,5);
                swap(2, 4);
            default:
                throw new IllegalArgumentException(String.valueOf(face));
        }
        */
    }

    private void swap(int a, int b) {
        int temp = this.colors[a];
        this.colors[a] = this.colors[b];
        this.colors[b] = temp;
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
