public class CinemaManagementApp {
    public static void main(String[] args) {
        CinemaConfig config = CinemaConfig.getInstance();
        config.setCinemaName("Star Wars");
        config.setNumberOfScreens(5);
        config.setOperatingHours("12:00 - 23:00");
        System.out.println("Cinema Name: " + config.getCinemaName());
        System.out.println("Number of Screens: " + config.getNumberOfScreens());
        System.out.println("Operating Hours: " + config.getOperatingHours());

        MovieFactory regularFactory = new RegularMovieFactory();
        Movie movie = regularFactory.createMovie("Inception");
        System.out.println("Movie: " + movie.getTitle() + ", Type: " + movie.getType());

        UIFactory uiFactory = new DarkThemeFactory();
        Button button = uiFactory.createButton();
        button.render();

        TicketBooking booking = new TicketBooking.TicketBookingBuilder()
                .setMovieTitle("Inception")
                .setSeatNumber("B3")
                .setSnackCombo("Popcorn and Soda")
                .build();

        System.out.println("Ticket Booking:");
        System.out.println("Movie Title: " + booking.getMovieTitle());
        System.out.println("Seat Number: " + booking.getSeatNumber());
        System.out.println("Snack Combo: " + booking.getSnackCombo());

        StandardSchedule template = new StandardSchedule();
        template.setTime("21:00");
        MovieSchedule eveningSchedule = template.clone();
        eveningSchedule.setMovie(movie);

        System.out.println("Schedule:");
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Time: " + template.getTime());
    }
}




