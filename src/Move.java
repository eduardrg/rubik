public class Move {
    public enum Direction {
        LEFT, RIGHT
    }
    public int times;
    public Direction direction;
    public Cube.Face face;

    Move(Cube.Face face, Direction direction, int times) {
        this.face = face;
        this.direction = direction;
        this.times = times;
    }

    public Move reverse() {
        if (this.direction == Direction.LEFT) {
            return new Move(this.face, Direction.RIGHT, this.times);
        } else {
            return new Move(this.face, Direction.LEFT, this.times);
        }
    }

    @Override
    public String toString() {
        return this.face + " " + this.direction + " " + times;
    }
}
