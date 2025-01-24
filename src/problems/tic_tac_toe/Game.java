package problems.tic_tac_toe;

import problems.tic_tac_toe.Model.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
* Question: Implement an In-Memory Relational Data Store
* Objective: Design and implement a simple in-memory relational data store with CRUD operations and indexing.
* The data store should be able to support basic operations like creating tables, inserting and updating rows, deleting rows, and indexing on a single column.
* For simplicity, assume:
* All fields in a table are of type string.
* You do not need to implement SQL parsing. Methods will be called directly.
* Each row will have a unique,Auto-Gen-ID
* */

public class Game {

    Deque<Player> players;
    Board gameBoard;

    public Game() {
        initGame();
    }

    public void initGame() {
        players = new LinkedList<>();
        gameBoard = new Board(3);

        PlayingPieceFactory playingPieceFactory = new PlayingPieceFactory();
        PlayingPiece pieceX= playingPieceFactory.getPiece("X");
        PlayingPiece pieceO= playingPieceFactory.getPiece("O");

        Player player1 = new Player("prankur", pieceX);
        Player player2 = new Player("prakarsh", pieceO);

        players.add(player1);
        players.add(player2);

    }

    public String startGame() {
      boolean noWinner = true;
      while (noWinner) {
          Player playerTurn = players.removeFirst();
          gameBoard.printBoard();

          List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
          if (freeSpaces.isEmpty()) {
              noWinner = false;
              continue;
          }

          System.out.println("Player " + playerTurn.name + "Enter the row");
          Scanner input = new Scanner(System.in);
          String s = input.nextLine();
          String[] value = s.split(",");
          int row = Integer.parseInt(value[0]);
          int col = Integer.parseInt(value[1]);


          boolean placed = gameBoard.addPiece(row, col, playerTurn.playingPiece);
          if (!placed) {
              System.out.println("Incorrect position chosen by " + playerTurn.name);
              players.addFirst(playerTurn);
              continue;
          }
          players.addLast(playerTurn);

          boolean isWinner = isThereWinner(row, col, playerTurn.playingPiece.type);
          if (isWinner) {
              return playerTurn.name;
          }
      }
      return "Nobody";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].type != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].type != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].type != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].type != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }


    public static void main(String[] args) {
        Game game = new Game();
        System.out.println("The game winner is: " + game.startGame());
    }
}
