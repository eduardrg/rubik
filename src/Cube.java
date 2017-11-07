import java.util.HashMap;
import java.util.Map;

public class Cube {
    private Cuboid[][][] cuboids;
    private static final int SIZE = 3;

    public enum Face {
        LEFT, RIGHT, BOTTOM, TOP, FRONT, BACK
    }

    private Map<Face, FaceParams> faces;

    Cube() {
        this.cuboids = new Cuboid[SIZE][SIZE][SIZE];
        this.faces = new HashMap<>();
        this.faces.put(Face.LEFT, new FaceParams(2, -1, 3));
        this.faces.put(Face.RIGHT, new FaceParams(18, 1, 3));
        this.faces.put(Face.TOP, new FaceParams(2, 9, -1));
        this.faces.put(Face.BOTTOM, new FaceParams(6, 9, 1));
        this.faces.put(Face.FRONT, new FaceParams(0, 9, 3));
        this.faces.put(Face.BACK, new FaceParams(20, -9, 3));

        for (int x = 0; x < SIZE; x++) {
            for (int y = 0; y < SIZE; y++) {
                for (int z = 0; z < SIZE; z++) {
                    this.cuboids[x][y][z] = new Cuboid(new int[]{0, 1, 2, 3, 4, 5});
                }
            }
        }
    }

    int[] getCoordinates(int n) {
        if (n < 0 || n >= Math.pow(SIZE, 3)) {
            throw new IllegalArgumentException();
        }
        int x, y, z;
        x = n / 9;
        y = (n % 9) / 3;
        z = n % 3;
        return new int[] {x, y, z};
    }

    Cuboid getCuboid(int x, int y, int z) {
        return this.cuboids[x][y][z];
    }

    public void rotateLeft(Face face) {
        this.rotateLeft(face, 1);
    }

    public void rotateRight(Face face) {
        this.rotateRight(face, 1);
    }

    public void rotateRight(Face face, int times) {
        times = times % 4;
        rotateLeft(face, 4 - times);
    }
    public void rotateLeft(Face face, int times) {
        times = times % 4;
        for (int i = 1; i <= times; i++) {
            if (!this.faces.containsKey(face)) throw new IllegalArgumentException();
            rotateLeft(this.faces.get(face), face);
        }
    }

    void rotateLeft(FaceParams faceParams, Face face) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                getCuboid(faceParams.getStart() + (j * faceParams.getColInc()) + (i * faceParams.getRowInc())).rotateLeft(face);
            }
        }

        int topMid = faceParams.getStart() + faceParams.getColInc();
        int topRight = faceParams.getStart() + 2 * faceParams.getColInc();
        int leftMid = faceParams.getStart() + faceParams.getRowInc();
        int rightMid = topRight + faceParams.getRowInc();
        int bottomLeft = faceParams.getStart() + 2 * faceParams.getRowInc();
        int bottomMid = topMid + 2 * faceParams.getRowInc();
        int bottomRight = topRight + 2 * faceParams.getRowInc();

        swap(faceParams.getStart(), topRight);
        swap(topRight, bottomRight);
        swap(bottomRight, bottomLeft);
        swap(topMid, leftMid);
        swap(topMid, rightMid);
        swap(rightMid, bottomMid);

    }

    Cuboid getCuboid(int[] a) {
        return this.cuboids[a[0]][a[1]][a[2]];
    }

    Cuboid getCuboid(int n) {
        return getCuboid(getCoordinates(n));
    }

    private void swap(int[] aCoordinates, int[] bCoordinates) {
        Cuboid temp = getCuboid(aCoordinates);
        this.cuboids[aCoordinates[0]][aCoordinates[1]][aCoordinates[2]] = getCuboid(bCoordinates);
        this.cuboids[bCoordinates[0]][bCoordinates[1]][bCoordinates[2]] = temp;
    }

    private void swap(int cuboidA, int cuboidB) {
        swap(getCoordinates(cuboidA), getCoordinates(cuboidB));
    }

    public void printFace(Face face) {
        FaceParams faceParams = this.faces.get(face);
        System.out.println(String.valueOf(face));
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Cuboid cuboid = getCuboid(faceParams.getStart() + (j * faceParams.getColInc()) + (i * faceParams.getRowInc()));
                System.out.print(cuboid.getColor(face) + " ");
            }
            System.out.println();
        }
    }

    public boolean isSolved() {
        for (Face f : Face.values()) {
            FaceParams fp = this.faces.get(f);
            Cuboid cuboid = this.getCuboid(fp.getStart());
            int color = cuboid.getColor(f);
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    Cuboid c = getCuboid(fp.getStart() + (j * fp.getColInc()) + (i * fp.getRowInc()));
                    if (c.getColor(f) != color) return false;
                }
            }
        }
        return true;
    }

}
