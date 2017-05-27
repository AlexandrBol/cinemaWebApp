package ua.org.bolshakov.dto;

import lombok.Getter;
import lombok.Setter;
import ua.org.bolshakov.model.Entity;

import java.time.LocalDate;


public class MovieDTO extends Entity<Integer> {

    private String title;
    private String description;
    private Integer duration;
    private LocalDate rent_start;
    private LocalDate rent_end;
    private String genre;
    private Integer rate;
    private String poster;
    private String video;

    public MovieDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getRent_start() {
        return rent_start;
    }

    public void setRent_start(LocalDate rent_start) {
        this.rent_start = rent_start;
    }

    public LocalDate getRent_end() {
        return rent_end;
    }

    public void setRent_end(LocalDate rent_end) {
        this.rent_end = rent_end;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public MovieDTO(String title, String description, Integer duration, LocalDate rent_start, LocalDate rent_end, String genre, Integer rate, String poster, String video) {
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
}