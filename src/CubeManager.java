public class CubeManager {
    public static void main(String[] args) {
        Cube cube = new Cube(true);

        cube.printFace(Cube.Face.FRONT);
        cube.printFace(Cube.Face.BACK);
        cube.printFace(Cube.Face.LEFT);
        cube.printFace(Cube.Face.RIGHT);
        cube.printFace(Cube.Face.TOP);
        cube.printFace(Cube.Face.BOTTOM);

        System.out.println(cube.isSolved());
        cube.reset();
        System.out.println(cube.isSolved());
        cube.scramble();
        System.out.println(cube.isSolved());
        cube.reset();
        System.out.println(cube.isSolved());
        /*
        cube.printFace(Cube.Face.FRONT);
        cube.printFace(Cube.Face.BACK);
        cube.printFace(Cube.Face.LEFT);
        cube.printFace(Cube.Face.RIGHT);
        cube.printFace(Cube.Face.TOP);
        cube.printFace(Cube.Face.BOTTOM);
        /*
        cube.printFace(Cube.Face.FRONT);
        cube.printFace(Cube.Face.BACK);
        cube.printFace(Cube.Face.LEFT);
        cube.printFace(Cube.Face.RIGHT);
        cube.printFace(Cube.Face.TOP);
        cube.printFace(Cube.Face.BOTTOM);*/


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
