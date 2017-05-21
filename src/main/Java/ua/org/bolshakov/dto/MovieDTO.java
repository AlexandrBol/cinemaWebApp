package ua.org.bolshakov.dto;


import lombok.Getter;
import lombok.Setter;
import ua.org.bolshakov.model.Entity;
@Setter
@Getter
public class MovieDTO extends Entity<Integer> {

    private String title;
    private String description;
    private int duration;

    public MovieDTO() {
    }

    public MovieDTO(String title, String description, int duration) {
        this.title = title;
        this.description = description;
        this.duration = duration;

    }


    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                "} ";
    }
}