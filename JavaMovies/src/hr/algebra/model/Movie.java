/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dodo
 */
public class Movie {

    private int id;
    private String title;
    private String plot;
    private Person director;
    private int directorId;
    private List<Person> actros;
    private String imagePath;

    public Movie() {
    }

    public Movie(int id, String title, int directorId, String plot, String imagePath) {
        this.title = title;
        this.plot = plot;
        this.directorId = directorId;
        this.imagePath = imagePath;
        this.id = id;
    }

    public Movie(String title, String plot, Person director, String imagePath, List<Person> actros) {
        this.title = title;
        this.plot = plot;
        this.director = director;
        this.imagePath = imagePath;
        this.actros = actros;
    }

    public Movie(int id, String title, String plot, Person director, String imagePath, List<Person> actros) {
        this(title, plot, director, imagePath, actros);
        this.id = id;
    }

    @XmlTransient
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @XmlTransient
    public int getDirectorId() {
        return directorId;
    }

    public void setDirectorId(int directorId) {
        this.directorId = directorId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public Person getDirector() {
        return director;
    }

    public void setDirector(Person director) {
        this.director = director;
    }

    @XmlElementWrapper
    @XmlElement(name = "actor")
    public List<Person> getActors() {
        return actros;
    }

    public void setActros(List<Person> actros) {
        this.actros = actros;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title=" + title + ", plot=" + plot + ", director=" + director + ", actros=" + actros + ", imagePath=" + imagePath + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

}
