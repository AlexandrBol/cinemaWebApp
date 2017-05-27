package ua.org.bolshakov.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
public class Movie extends Entity<Integer>{
    private String title;
    private String description;
    private Integer duration;
    private LocalDate rent_start;
    private LocalDate rent_end;
    private String genre;
    private Integer rate;
    private String poster;
    private String video;


    public Movie() {
    }

    public Movie(String title, String description, Integer duration, LocalDate rent_start, LocalDate rent_end, String genre, Integer rate, String poster, String video) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.rent_start = rent_start;
        this.rent_end = rent_end;
        this.genre = genre;
        this.rate = rate;
        this.poster = poster;
        this.video = video;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", rent_start=" + rent_start +
                ", rent_end=" + rent_end +
                ", genre='" + genre + '\'' +
                ", rate=" + rate +
                ", poster='" + poster + '\'' +
                ", video='" + video + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return Objects.equals(getTitle(), movie.getTitle()) &&
                Objects.equals(getDescription(), movie.getDescription()) &&
                Objects.equals(getDuration(), movie.getDuration()) &&
                Objects.equals(getRent_start(), movie.getRent_start()) &&
                Objects.equals(getRent_end(), movie.getRent_end()) &&
                Objects.equals(getGenre(), movie.getGenre()) &&
                Objects.equals(getRate(), movie.getRate()) &&
                Objects.equals(getPoster(), movie.getPoster()) &&
                Objects.equals(getVideo(), movie.getVideo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTitle(), getDescription(), getDuration(), getRent_start(), getRent_end(), getGenre(), getRate(), getPoster(), getVideo());
    }
}