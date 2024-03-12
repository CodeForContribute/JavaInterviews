package DesignBookMyShow;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookMyShow {
    MovieController movieController;
    TheatreController theatreController;

    public BookMyShow(MovieController movieController, TheatreController theatreController) {
        this.movieController = movieController;
        this.theatreController = theatreController;
    }

    public BookMyShow() {
        this.movieController = new MovieController();
        this.theatreController = new TheatreController();
    }

    public static void main(String[] args) {
        BookMyShow bookMyShow = new BookMyShow();
        bookMyShow.initialize();
        bookMyShow.createBooking(City.BANGALORE, "BAHUBALI");
        bookMyShow.createBooking(City.BANGALORE, "AVENGERS");
    }

    private void createBooking(City city, String movieName) {
        // 1. search movie by location
        List<Movie> movies = this.movieController.getMoviesForACity(city);
        // 2. select the move which we want to watch
        Movie interstedMovie = null;
        for (Movie movie : movies) {
            if (movie.getMovieName().equals(movieName)) {
                interstedMovie = movie;
            }
        }
        // 3. get all show of this movie in given city
        Map<Theatre, List<Show>> showTheatreMap = this.theatreController.getAllShowInTheatre(interstedMovie, city);
        // 4. select the particular show user is interested in
        Map.Entry<Theatre, List<Show>> entry = showTheatreMap.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);
        // select the seat
        int seatNumber = 30;
        List<Integer> bookedSeats = interestedShow.getBookedSeats();
        if (!bookedSeats.contains(seatNumber)) {
            bookedSeats.add(seatNumber);
            // start payment
            Payment payment = new Payment();
            payment.setPaymentId(1);
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for (Seat screenSeat : interestedShow.getScreen().getSeatList()) {
                if (screenSeat.getSeatId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setPayment(payment);
            booking.setShow(interestedShow);
        } else {
            System.out.println("seat already booked, try again !!");
            return;
        }
        System.out.println("Booking successful");

    }

    public void initialize() {
        // createMovies
        createMovies();
        // createTheatres
        createTheatres();
    }

    public void createMovies() {
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieName("AVENGERS");
        avengers.setMovieDurations(new BigDecimal("128.00"));

        Movie bahubali = new Movie();
        bahubali.setMovieId(2);
        bahubali.setMovieName("BAHUBALI");
        bahubali.setMovieDurations(new BigDecimal("180.00"));

        // add movies against the cities
        movieController.addMovie(avengers, City.BANGALORE);
        movieController.addMovie(avengers, City.DELHI);
        movieController.addMovie(bahubali, City.BANGALORE);
        movieController.addMovie(bahubali, City.PATNA);

    }

    public void createTheatres() {
        Movie avengerMovie = this.movieController.getMovieByName("AVENGERS");
        Movie bahubaliMovie = this.movieController.getMovieByName("BAHUBALI");
        Theatre inox = new Theatre();
        inox.setTheatreId(1);
        inox.setScreens(createScreens());
        inox.setCity(City.BANGALORE);
        List<Show> inoxShows = new ArrayList<>();
        Show inoxMorningShow = createShows(1, inox.getScreens().get(0), avengerMovie, 8);
        Show eveningShow = createShows(2, inox.getScreens().get(1), bahubaliMovie, 16);
        inoxShows.add(inoxMorningShow);
        inoxShows.add(eveningShow);

        Theatre pvr = new Theatre();
        pvr.setTheatreId(2);
        pvr.setScreens(createScreens());
        pvr.setCity(City.DELHI);
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShows(3, pvr.getScreens().get(0), avengerMovie, 13);
        Show pvrEveningShow = createShows(4, pvr.getScreens().get(1), bahubaliMovie, 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvr.setShows(pvrShows);

        this.theatreController.addTheatre(inox, City.BANGALORE);
        this.theatreController.addTheatre(pvr, City.PATNA);
    }

    public Show createShows(int showId, Screen screen, Movie movie, int time) {
        Show show = new Show();
        show.setShowId(showId);
        show.setScreen(screen);
        show.setMovie(movie);
        show.setStartTime(time);
        return show;
    }

    private List<Screen> createScreens() {
        List<Screen> screens = new ArrayList<>();
        Screen sc1 = new Screen();
        sc1.setScreenId(1);
        sc1.setSeatList(createSeats(50));
        screens.add(sc1);

        Screen sc2 = new Screen();
        sc2.setScreenId(1);
        sc2.setSeatList(createSeats(100));
        screens.add(sc2);

        return screens;
    }

    private List<Seat> createSeats(int totalSeats) {
        List<Seat> seats = new ArrayList<>();
        for (int s = 0; s < totalSeats / 3; ++s) {
            Seat seat = new Seat();
            seat.setSeatId(s);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        for (int s = totalSeats / 3; s < 2 * totalSeats / 3; ++s) {
            Seat seat = new Seat();
            seat.setSeatId(s);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }

        for (int s = 2 * totalSeats / 3; s < totalSeats; ++s) {
            Seat seat = new Seat();
            seat.setSeatId(s);
            seat.setSeatCategory(SeatCategory.GOLD);
            seats.add(seat);
        }
        return seats;
    }
}
