package ua.org.bolshakov.dto;

import ua.org.bolshakov.model.Entity;

public class PlaceDTO extends Entity<Integer> {

    private int seat;
    private int row;
    private boolean status;
    private int sessionId;

    public PlaceDTO() {
    }

    public PlaceDTO(int seat, int row, boolean status, int sessionId) {
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
    public String toString() {
        return "PlaceDTO{" +
                "seat=" + seat +
                ", row=" + row +
                ", status=" + status +
                ", sessionId=" + sessionId +
                '}';
    }
}
