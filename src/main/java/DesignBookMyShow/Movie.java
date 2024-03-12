package DesignBookMyShow;

import java.math.BigDecimal;

public class Movie {
    private int movieId;
    private String movieName;
    private BigDecimal movieDurations;
    // other details like Genre, Language etc

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public BigDecimal getMovieDurations() {
        return movieDurations;
    }

    public void setMovieDurations(BigDecimal movieDurations) {
        this.movieDurations = movieDurations;
    }
}
