package com.sg.dvdlibrary.dto;

import java.util.Objects;

//This library defines DVD properties and related functions to access the values.
public class DVDLibrary {
    // declare the variables.
    private String title;
    private String releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String note;

    public DVDLibrary(String title){
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DVDLibrary that = (DVDLibrary) o;
        return title.equals(that.title) && releaseDate.equals(that.releaseDate) && mpaaRating.equals(that.mpaaRating) && directorName.equals(that.directorName) && studio.equals(that.studio) && note.equals(that.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, releaseDate, mpaaRating, directorName, studio, note);
    }

    @Override
    public String toString() {
        return "DVDLibrary{" +
                "title='" + title + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", mpaaRating='" + mpaaRating + '\'' +
                ", directorName='" + directorName + '\'' +
                ", studio='" + studio + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
