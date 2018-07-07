package ua.org.bolshakov.model;

import java.util.Objects;

public class Hall extends Entity<Integer> {

    private String name;
    private Integer price;

    public Hall() {
    }

    public Hall(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hall hall = (Hall) o;
        return Objects.equals(getName(), hall.getName()) &&
                Objects.equals(getPrice(), hall.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getPrice());
    }
}
