package ua.org.bolshakov.model;

import java.util.Objects;

public class Place extends Entity<Integer> {

    private int seat;
    private int row;
    private boolean status;
    private int sessionId;

    public Place() {
    }

    public Place(int seat, int row, boolean status, int sessionId) {
        this.seat = seat;
        this.row = row;
        this.status = status;
        this.sessionId = sessionId;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Place place = (Place) o;
        return getSeat() == place.getSeat() &&
                getRow() == place.getRow() &&
                isStatus() == place.isStatus() &&
                getSessionId() == place.getSessionId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSeat(), getRow(), isStatus(), getSessionId());
    }
}
