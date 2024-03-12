package DesignBookMyShow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {
    Map<City, List<Theatre>> cityVsTheatre;
    List<Theatre> allTheatres;

    public TheatreController() {
        this.cityVsTheatre = new HashMap<>();
        this.allTheatres = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {
        this.allTheatres.add(theatre);
        List<Theatre> theatres = this.cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        this.cityVsTheatre.put(city, theatres);
    }

    // get all theatres and the list of shows in it for a given movie and a city
    public Map<Theatre, List<Show>> getAllShowInTheatre(Movie movie, City city) {
        Map<Theatre, List<Show>> allRunningShowInAllTheatres = new HashMap<>();
        // get all theatre for a city first
        List<Theatre> theatres = this.cityVsTheatre.getOrDefault(city, new ArrayList<>());
        // theatre has screen, screen has seats,also it has list of show in it.
        // show has movie associated with it
       for (Theatre theatre:theatres){
           List<Show> givenMovieShows = new ArrayList<>();
           List<Show> showList = theatre.getShows();
           showList.stream().forEach(show -> {
               if (show.getMovie().getMovieId() == movie.getMovieId()) {
                   givenMovieShows.add(show);
               }
           });
           if (!givenMovieShows.isEmpty()) {
               allRunningShowInAllTheatres.put(theatre, givenMovieShows);
           }
       }
        return allRunningShowInAllTheatres;
    }
}
