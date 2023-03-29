package ladder;

public class LadderRunner {

    private final Row[] rows;

    public LadderRunner(Row[] rows) {
        this.rows = rows;
    }

    public int run(Position position) {
        for (int i = 0; i < rows.length; i++) {
            rows[i].nextPosition(position);
        }
        return position.getPosition();
    }


    public void printLadderGame(Position position){
        LadderPosition ladderPosition = LadderPosition.createLadderPosition(position, 0);

        for (int i = 0; i < rows.length; i++) {
            ladderPosition.setLocation(position, i);
            printLadder(ladderPosition);
            printLadderAfter(ladderPosition);
        }

        return;
    }

    private void printLadder(LadderPosition ladderPosition){
        System.out.println("Before");
        for (int i = 0; i < rows.length; i++) {
            rows[i].printRow(ladderPosition,ladderPosition.checkCurrentRow(i));
            if(ladderPosition.checkCurrentRow(i)) rows[i].nextPosition(ladderPosition.getX());
        }
        System.out.println();
    }

    private void printLadderAfter(LadderPosition ladderPosition){
        System.out.println("After");
        for (int i = 0; i < rows.length; i++) {
            rows[i].printRow(ladderPosition,ladderPosition.checkCurrentRow(i));
        }
        System.out.println();
    }


}