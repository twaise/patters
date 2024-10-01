
interface MovieSchedule extends Cloneable {
    MovieSchedule clone();
    void setMovie(Movie movie);
    String getTime();
}
class StandardSchedule implements MovieSchedule {
    private Movie movie;
    private String time;

    public void setTime(String time) {
        this.time = time;
    }
    public String getTime() {
        return time;
    }
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    public MovieSchedule clone() {
        StandardSchedule clone = new StandardSchedule();
        clone.setTime(this.time);
        clone.setMovie(this.movie); // Можно клонировать и объект movie, если нужно
        return clone;
    }
}
