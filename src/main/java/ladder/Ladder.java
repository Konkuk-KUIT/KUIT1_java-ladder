package ladder;

public class Ladder {
    private final Row[] rows;

    public Ladder(int numberOfRows, int numberOfPeoplePerRow) {
        if (numberOfRows <= 0 || numberOfPeoplePerRow <= 0) {
            throw new IllegalArgumentException("사다리의 가로와 세로줄은 모두 자연수여야 합니다.");
        }
        this.rows = new Row[numberOfRows];
        for (int i = 0; i < numberOfRows; i++) {
            rows[i] = new Row(numberOfPeoplePerRow);
        }
    }

    public void drawLine(int rowNumber, int position) {
        if (rowNumber < 1 || rowNumber > rows.length) {
            throw new IllegalArgumentException();
        }
        rows[rowNumber - 1].drawLine(position);
    }

    public int run(int startPosition) {
        int currentPosition = startPosition;
        for (Row row : rows) {
            if (currentPosition > 1 && row.isLineDrawn(currentPosition - 1)) {
                currentPosition--;
            } else if (currentPosition < row.getNumberOfPerson() && row.isLineDrawn(currentPosition)) {
                currentPosition++;
            }
        }
        return currentPosition;
    }

    public void runAll() {
        for (int i = 1; i <= rows[0].getNumberOfPerson(); i++) {
            System.out.println("시작 지점: " + i + " -> " + run(i));
        }
    }
}