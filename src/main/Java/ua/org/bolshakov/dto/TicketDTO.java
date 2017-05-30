package ua.org.bolshakov.dto;


import ua.org.bolshakov.model.Entity;

public class TicketDTO extends Entity<Integer> {

    private int placeID;

    public TicketDTO() {
    }

    public TicketDTO(int placeID) {

        this.placeID = placeID;
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }
}
