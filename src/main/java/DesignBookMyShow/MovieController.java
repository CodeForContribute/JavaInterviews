package DesignBookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    private final Map<City, List<Movie>> cityMovieMap;
    private final List<Movie> allMovies;

    public MovieController() {
        this.cityMovieMap = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }

    public MovieController(Map<City, List<Movie>> cityMovieMap, List<Movie> allMovies) {
        this.cityMovieMap = cityMovieMap;
        this.allMovies = allMovies;
    }

    public void addMovie(Movie movie, City city) {
        this.allMovies.add(movie);
        List<Movie> moviesInACity = this.cityMovieMap.getOrDefault(city, new ArrayList<Movie>());
        moviesInACity.add(movie);
        this.cityMovieMap.put(city, moviesInACity);
    }

    public Movie getMovieByName(String movieName) {
        Movie foundMovie = null;
        for (Movie movie : this.allMovies) {
            if (movie.getMovieName().equals(movieName)) {
                foundMovie = movie;
                break;
            }
        }
        return foundMovie;
    }

    public List<Movie> getMoviesForACity(City city) {
        return this.cityMovieMap.getOrDefault(city, new ArrayList<>());
    }
    // Other crud operation we can do on it.

}
