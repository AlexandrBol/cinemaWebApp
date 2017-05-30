package ua.org.bolshakov.model;

import java.util.Objects;

public class Order extends Entity<Integer>{
    private  int idTicket;
    private  int idUser;

    public Order() {
    }

    public Order(int idTicket, int idUser) {
        this.idTicket = idTicket;
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return idTicket == order.idTicket &&
                idUser == order.idUser;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTicket() {

        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idTicket, idUser);
    }

    @Override
    public String toString() {
        return "Order{" +
                "idTicket=" + idTicket +
                ", idUser=" + idUser +
                '}';
    }
}
