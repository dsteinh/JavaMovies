/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dodo
 */
@XmlRootElement
public class Cinestar {
    private List<Movie> movies;

    public Cinestar() {
    }
    
    @XmlElement(name = "movie")
    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
    public Cinestar(List<Movie> movies) {
        this.movies = movies;
    }
    
}
