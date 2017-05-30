package ua.org.bolshakov.model;


import java.time.LocalDate;
import java.util.Objects;

public class Session extends Entity<Integer> {
    private int movieID;
    private int hallId;
    private LocalDate dateSession;

    public LocalDate getDateSession() {
        return dateSession;
    }

    public void setDateSession(LocalDate dateSession) {
        this.dateSession = dateSession;
    }

    public Session(int movieID, int hallId, LocalDate dateSession) {

        this.movieID = movieID;
        this.hallId = hallId;
        this.dateSession = dateSession;
    }

    public Session() {
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Session session = (Session) o;
        return getMovieID() == session.getMovieID() &&
                getHallId() == session.getHallId() &&
                Objects.equals(getDateSession(), session.getDateSession());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMovieID(), getHallId(), getDateSession());
    }
}
