package problems.book_my_show.model;

public class Movie {

    private final String movieId;
    private final String name;
    private final String desc;
    private final long duration;

    public Movie(String movieId, String name, String desc, long duration) {
        this.movieId = movieId;
        this.name = name;
        this.desc = desc;
        this.duration = duration;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public long getDuration() {
        return duration;
    }

}
