package ua.org.bolshakov.model;

import java.util.Objects;

public class Ticket extends Entity<Integer> {

    private Integer placeID;

    public Ticket() {
    }

    public Integer getPlaceID() {
        return placeID;
    }

    public void setPlaceID(Integer placeID) {
        this.placeID = placeID;
    }

    public Ticket(int placeID) {
        this.placeID = placeID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(placeID, ticket.placeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), placeID);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "placeID=" + placeID +
                '}';
    }
}
