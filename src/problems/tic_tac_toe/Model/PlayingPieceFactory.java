package problems.tic_tac_toe.Model;

public class PlayingPieceFactory {
    PlayingPiece piece;

    public PlayingPiece getPiece(String input) {
        switch (input.toLowerCase()) {
            case "x":
                piece = new PlayingPieceX();
                break;
            case "o":
                piece = new PlayingPieceO();
                break;
            default:
                throw new RuntimeException(input + " piece not found");
        }
        return piece;
    }
}
