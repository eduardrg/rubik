import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CubeTest {
    Cube cube;
    @Before
    public void makeNewCube() {
        this.cube = new Cube(true);
    }

    @Test
    public void newCubeShouldBeSolved() {
        assertTrue(this.cube.isSolved());
    }

    @Test
    public void scrambledCubeShouldNotBeSolved() {
        this.cube.scramble();
        assertFalse(this.cube.isSolved());
    }

    @Test
    public void allMovesShouldBeReversible() {
        for (int i = 0; i < Cube.Face.values().length; i++) {
            for (int j = 0; j < Move.Direction.values().length; j++) {
                makeNewCube();
                moveShouldBeReversible(new Move(Cube.Face.values()[i], Move.Direction.values()[j], 1));
            }
        }
    }

    public void moveShouldBeReversible(Move move) {
        this.cube.doMove(move, true);
        this.cube.doMove(move.reverse(), false);
        assertEquals("Could not reverse move: " + move.toString(), true, this.cube.isSolved());
    }

    @Test
    public void resetCubeShouldBeSolved() {
        cube.scramble();
        cube.reset();
        assertTrue(cube.isSolved());
    }

}
