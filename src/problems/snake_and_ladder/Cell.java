package problems.snake_and_ladder;

public class Cell {
    private Jump jump;

    public Cell() {
    }

    public Cell(Jump jump) {
        this.jump = jump;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }
}
