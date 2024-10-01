class TicketBooking {
    private String movieTitle;
    private String seatNumber;
    private String snackCombo;
    private TicketBooking(TicketBookingBuilder builder) {
        this.movieTitle = builder.movieTitle;
        this.seatNumber = builder.seatNumber;
        this.snackCombo = builder.snackCombo;
    }
    public String getMovieTitle() {
        return movieTitle;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public String getSnackCombo() {
        return snackCombo;
    }
    public static class TicketBookingBuilder {
        private String movieTitle;
        private String seatNumber;
        private String snackCombo;
        public TicketBookingBuilder setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
            return this;
        }
        public TicketBookingBuilder setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }
        public TicketBookingBuilder setSnackCombo(String snackCombo) {
            this.snackCombo = snackCombo;
            return this;
        }
        public TicketBooking build() {
            return new TicketBooking(this);
        }
    }
}