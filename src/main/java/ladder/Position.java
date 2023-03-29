package ladder;

public class Position {
    public int position;

    private Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    public void goRight() {
        position = position + 1;
        validatePosition(position);
    }

    public void goLeft() {
        position = position - 1;
        validatePosition(position);
    }

    public boolean isSmaller(int position) {
        return this.position < position;
    }

    public boolean isBigger(int position) {
        return this.position > position;
    }

    public static Position createPosition(int position) {
        validatePosition(position);
        return new Position(position);
    }

    public int getNextPosition() {
        return position + 1;
    }

    private static void validatePosition(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("좌표는 0 이상이어야 합니다!");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("position : ");
        sb.append(position);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Position))
            return false;
        Position p = (Position) o;
        return p.position == position;
    }
}
