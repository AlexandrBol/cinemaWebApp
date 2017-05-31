package ua.org.bolshakov.dto;


import ua.org.bolshakov.model.Entity;

import java.time.LocalDate;

public class SessionDTO  extends Entity<Integer> {

    private int movieID;
    private int hallId;
    private LocalDate dateSession;

    public SessionDTO(int movieID, int hallId, LocalDate dateSession) {
        this.movieID = movieID;
        this.hallId = hallId;
        this.dateSession = dateSession;
    }

    public SessionDTO() {
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

    public LocalDate getDateSession() {
        return dateSession;
    }

    public void setDateSession(LocalDate dateSession) {
        this.dateSession = dateSession;
    }

    @Override
    public String toString() {
        return "SessionDTO{" +
                "movieID=" + movieID +
                ", hallId=" + hallId +
                ", dateSession=" + dateSession +
                '}';
    }
}
