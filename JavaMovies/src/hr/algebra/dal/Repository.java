/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal;

import hr.algebra.model.Movie;
import hr.algebra.model.Person;
import hr.algebra.model.User;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 *
 * @author dnlbe
 */
public interface Repository {

    User selectUser(int id) throws Exception;

    List<User> selectUsers() throws Exception;

    void createUser(User user) throws Exception;

    public void createMovies(Set<Movie> movies) throws Exception;

    public void createDirectors(Set<Person> directors) throws Exception;

    public void deleteAllData() throws Exception;

    public void createActors(Set<Person> actors) throws Exception;

    public void createMoviActors(Set<Movie> movies) throws Exception;

    public List<Movie> selectMovies() throws Exception;

    public Optional<Movie> selectMovie(int selectedMovieId) throws Exception;

    public Optional<Person> selectDirectorById(int directorId) throws Exception;

    public List<Person> selectActorsByMovieId(int id) throws Exception;

    public List<Person> selectActors() throws Exception;

    public void updateMovie(int id, Movie selectedMovie) throws Exception;

    public void createMovie(Movie movie) throws Exception;

    public void deleteMovie(Movie selectedMovie) throws Exception;
    
    public void deleteMovieActorById(int id) throws Exception;

    public void deleteMovieActor(int idMovie, int idActor) throws Exception;

    public Optional<Person> selectActors(int selectedPersonId) throws Exception;

    public void createActor(Person person) throws Exception;

    public void updatePerson(int id, Person selectedPerson) throws Exception;

    public void deleteActor(Person selectedPerson) throws Exception;
}
