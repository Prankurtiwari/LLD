package problems.snake_and_ladder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {


    private Board board;
    private Dice dice;
    private final Deque<Player> players = new LinkedList<>();
    private Player winner;

    public Game() {
        initGame();
    }

    private void initGame() {
        board = new Board(10, 8, 9);
        dice = new Dice(1, 1, 6);
        addPlayers();
    }

    private void addPlayers() {
        players.add(new Player("prankur", 0));
        players.add(new Player("prakarsh", 0));
    }

    public void startGame() {

        while (winner == null) {
            Player player = findPlayerTurn();
            System.out.println("player turn is:" + player.getPlayerName() + " current position is: " + player.getPosition());

            int position = dice.rollDice();
            System.out.println("dice role for : " + player.getPlayerName() + " dice position: " + position);

            int playerPosition = player.getPosition() + position;
            playerPosition = jumpCheck(playerPosition);
            player.setPosition(playerPosition);

            System.out.println("player turn is:" + player.getPlayerName() + " new Position is: " + playerPosition);


            if(playerPosition >= board.getSize() * board.getSize() - 1 ){
                winner = player;
            }


        }
        System.out.println("WINNER IS:" + winner.getPlayerName());
    }

    private Player findPlayerTurn() {
        Player playerTurns = players.removeFirst();
        players.addLast(playerTurns);
        return playerTurns;

    }
    private int jumpCheck (int playerNewPosition) {

        if(playerNewPosition > board.getSize() * board.getSize() - 1){
            return playerNewPosition;
        }

        Cell cell = board.getCell(playerNewPosition);
        if(cell.getJump() != null && cell.getJump().getStart() == playerNewPosition) {
            String jumpBy = (cell.getJump().getStart() < cell.getJump().getEnd()) ? "Ladder" : "Snake";
            System.out.println("jump done by: " + jumpBy);
            return cell.getJump().getEnd();
        }
        return playerNewPosition;
    }


}
