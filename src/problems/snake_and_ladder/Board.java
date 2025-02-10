package problems.snake_and_ladder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    private Cell[][] cells;
    private int size;

    public Board(int size, int numberOfSnakes, int numberOfLadder) {
        this.size = size;
        init(size);
        addSnakeLadders(numberOfSnakes, numberOfLadder);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private void init(int size) {
        cells = new Cell[size][size];

        for (int i =0; i< size; i++) {
            for(int j = 0; j< size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    private void addSnakeLadders(int numberOfSnakes, int numberOfLadder) {

        addSnakes(numberOfSnakes);
        addLadder(numberOfLadder);

    }

    private void addSnakes(int numberOfSnakes) {
        while (numberOfSnakes-- > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length-1);

            if (snakeTail >= snakeHead) {
                continue;
            }

            Jump jump = new Jump(snakeHead, snakeTail);
            Cell cell = getCell(snakeHead);
            cell.setJump(jump);

        }
    }

    private void addLadder(int numberOfLadder) {
        while (numberOfLadder-- > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length-1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length-1);

            if (ladderHead >= ladderTail) {
                continue;
            }

            Jump jump = new Jump(ladderHead, ladderTail);
            Cell cell = getCell(ladderHead);
            cell.setJump(jump);

        }
    }


    public Cell getCell(int position) {
        return cells[position / cells.length][position % cells.length];
    }

}
