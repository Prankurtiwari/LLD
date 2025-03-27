package problems.review_system.enums;

public enum Rating {
    ONE(1, "WORST"),
    TWO(2, "Average"),
    THREE(3, "Good");

    private final int score;
    private final String desc;

    Rating(int score, String desc) {
        this.score = score;
        this.desc = desc;
    }

    public int getScore() {
        return score;
    }

    public String getDesc() {
        return desc;
    }
}
