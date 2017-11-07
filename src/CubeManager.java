public class CubeManager {
    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.printFace(Cube.Face.FRONT);
        cube.printFace(Cube.Face.LEFT);
        cube.rotateLeft(Cube.Face.LEFT);
        cube.printFace(Cube.Face.FRONT);
        cube.printFace(Cube.Face.LEFT);

        /*
        System.out.println(cube.getCuboid(0).getColor(Cube.Face.LEFT));
        cube.rotateRight(Cube.Face.LEFT);
        System.out.println(cube.getCuboid(0).getColor(Cube.Face.LEFT));
        System.out.println(cube.getCuboid(3).getColor(Cube.Face.LEFT));
        System.out.println(cube.getCuboid(6).getColor(Cube.Face.LEFT));
        */
        /*
        System.out.println("\t\tx\ty\tz\t");
        for (int i = 0; i < 27; i++) {
            System.out.println("n = " + i + "\t" + coordinatesToString(cube.getCoordinates(i)));
        }
        */

    }

    private static String coordinatesToString(int[] coordinates) {
        String s = "";
        for (int i = 0; i < coordinates.length; i++) {
            s += coordinates[i] + "\t";
        }
        return s;
    }
}
