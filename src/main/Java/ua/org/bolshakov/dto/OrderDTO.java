package ua.org.bolshakov.dto;

import ua.org.bolshakov.model.Entity;

public class OrderDTO extends Entity<Integer> {
    private  int idTicket;
    private  int idUser;

    public OrderDTO() {
    }

    public OrderDTO(int idTicket, int idUser) {
        this.idTicket = idTicket;
        this.idUser = idUser;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }
}
