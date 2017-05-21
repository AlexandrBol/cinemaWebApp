package ua.org.bolshakov.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie extends Entity<Integer>{
    private String title;
    private String description;
    private Integer duration;

    public Movie(String title, String description, Integer duration) {
        this.title = title;
        this.description = description;
        this.duration = duration;
    }

    public Movie() {
    }

    @Override
    public String toString() {
        return "Movie{" +
                "description='" + description + '\'' +
                ", id=" + getId() +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        if (!super.equals(o)) return false;

        Movie movie = (Movie) o;

        if (!getTitle().equals(movie.getTitle())) return false;
        if (!getDescription().equals(movie.getDescription())) return false;
        return getDuration().equals(movie.getDuration());

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + getDuration().hashCode();
        return result;
    }
}