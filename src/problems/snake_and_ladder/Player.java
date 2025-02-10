package problems.snake_and_ladder;

public class Player {
    private String playerName;
    private int Position;

    public Player(String playerName, int position) {
        this.playerName = playerName;
        Position = position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }
}
