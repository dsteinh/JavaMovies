/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.dal.sql;

import hr.algebra.dal.Repository;
import hr.algebra.model.Movie;
import hr.algebra.model.Person;
import hr.algebra.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author dnlbe
 */
public class SqlRepository implements Repository {

    //User
    private static final String ID_USER = "IDUser";
    private static final String USERNAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String IS_ADMIN = "IsAdmin";

    //Movie
    private static final String ID_MOVIE = "IDMovie";
    private static final String TITLE = "Title";
    private static final String PLOT = "Plot";
    private static final String DIRECTOR_ID = "DirectorID";
    private static final String IMG_PATH = "ImgPath";

    //Actor
    private static final String ID_ACTOR = "IDActor";
    private static final String ACTOR_ID = "ActorID";
    private static final String MOVIE_ID = "MovieID";
    //Director
    private static final String ID_DIRECTOR = "IDDirector";

    private static final String FIRST_NAME = "FirstName";
    private static final String LAST_NAME = "LastName";

    private static final String SELECT_USER = "{ CALL selectUser (?) }";
    private static final String SELECT_USERS = "{ CALL selectUsers }";
    private static final String CREATE_USER = "{ CALL createUser (?,?,?) }";

    private static final String CREATE_DIRECTOR = "{ CALL createDirector (?,?) }";
    private static final String CREATE_MOVIE_WITH_DIRECTOR_NAME = "{ CALL createMovieWithDirectorName (?,?,?,?,?) }";
    private static final String CREATE_ACTOR = "{ CALL createActors (?,?) }";
    private static final String CREATE_MOVIE_ACTOR = "{ CALL createMovieActor (?,?,?) }";
    private static final String CREATE_MOVIE_ACTOR_WITH_IDS = "{ CALL createMovieActorWithIds (?,?) }";
    private static final String DELETE_ALL = "{ CALL deleteAllData }";
    private static final String SELECT_MOVIES = "{ CALL selectMovies }";
    private static final String SELECT_MOVIE = "{ CALL selectMovie (?) }";
    private static final String SELECT_DIRECTOR_BY_ID = "{ CALL selectDirectorById (?) }";
    private static final String SELECT_ACTOR_BY_ID = "{ CALL selectActorById (?) }";
    private static final String SELECT_ACTORS_BY_MOVIE_ID = "{ CALL selectActorsByMovieId (?) }";
    private static final String SELECT_ACTORS = "{ CALL selectActors }";
    private static final String UPDATE_MOVIE = "{ CALL updateMovie (?,?,?,?,?) }";
    private static final String UPDATE_ACTOR = "{ CALL updateActor (?,?,?) }";
    private static final String CREATE_MOVIE = "{ CALL createMovie (?,?,?,?,?) }";
    private static final String DELETE_MOVIE = "{ CALL deleteMovie (?) }";
    private static final String DELETE_ACTOR = "{ CALL deleteActor (?) }";
    private static final String DELETE_MOVIE_ACTORS_BY_ID = "{ CALL deleteMovieActorsById (?) }";
    private static final String DELETE_MOVIE_ACTOR = "{ CALL deleteMovieActor (?,?) }";

    @Override
    public User selectUser(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USER)) {
            stmt.setInt("@" + ID_USER, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt(ID_USER),
                            rs.getString(USERNAME),
                            rs.getString(PASSWORD),
                            rs.getBoolean(IS_ADMIN));
                }
            }
        }
        return null;
    }

    @Override
    public List<User> selectUsers() throws Exception {
        List<User> users = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_USERS);
                ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                users.add(new User(
                        rs.getInt(ID_USER),
                        rs.getString(USERNAME),
                        rs.getString(PASSWORD),
                        rs.getBoolean(IS_ADMIN)));
            }
        }
        return users;
    }

    @Override
    public void createUser(User user) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_USER)) {
            // careful - if we use integers as positions, it is 1 based! 
            //stmt.setString(1, student.getFirstName()); 
            // so, we better use parameter names!
            stmt.setString("@" + USERNAME, user.getUsername());
            stmt.setString("@" + PASSWORD, user.getPassword());
            stmt.setBoolean("@" + IS_ADMIN, user.isAdmin());

            stmt.executeUpdate();

        }
    }

    @Override
    public void createMovies(Set<Movie> movies) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE_WITH_DIRECTOR_NAME)) {
            // careful - if we use integers as positions, it is 1 based! 
            //stmt.setString(1, student.getFirstName()); 
            // so, we better use parameter names!
            for (Movie mov : movies) {

                stmt.setString("@" + FIRST_NAME, mov.getDirector().getFirstName());
                stmt.setString("@" + LAST_NAME, mov.getDirector().getLastName());
                stmt.setString("@" + TITLE, mov.getTitle());
                stmt.setString("@" + PLOT, mov.getPlot());
                stmt.setString("@" + IMG_PATH, mov.getImagePath());

                stmt.executeUpdate();
            }

        }

    }

    @Override
    public void createDirectors(Set<Person> directors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_DIRECTOR)) {
            // careful - if we use integers as positions, it is 1 based! 
            //stmt.setString(1, student.getFirstName()); 
            // so, we better use parameter names!
            for (Person dir : directors) {
                stmt.setString("@" + FIRST_NAME, dir.getFirstName());
                stmt.setString("@" + LAST_NAME, dir.getLastName());

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void deleteAllData() throws Exception {

        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ALL)) {
            // careful - if we use integers as positions, it is 1 based! 
            //stmt.setString(1, student.getFirstName()); 
            // so, we better use parameter names!

            stmt.executeUpdate();

        }
    }

    @Override
    public void createActors(Set<Person> actors) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_ACTOR)) {
            // careful - if we use integers as positions, it is 1 based! 
            //stmt.setString(1, student.getFirstName()); 
            // so, we better use parameter names!
            for (Person act : actors) {
                stmt.setString("@" + FIRST_NAME, act.getFirstName());
                stmt.setString("@" + LAST_NAME, act.getLastName());

                stmt.executeUpdate();
            }
        }
    }

    @Override
    public void createMoviActors(Set<Movie> movies) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE_ACTOR)) {
            // careful - if we use integers as positions, it is 1 based! 
            //stmt.setString(1, student.getFirstName()); 
            // so, we better use parameter names!
            for (Movie mov : movies) {

                List<Person> actors = mov.getActors();
                if (actors == null) {
                    continue;
                }
                for (Person p : actors) {
                    stmt.setString("@" + TITLE, mov.getTitle());
                    stmt.setString("@" + FIRST_NAME, p.getFirstName());
                    stmt.setString("@" + LAST_NAME, p.getLastName());
                    stmt.executeUpdate();
                }

            }
        }
    }

    @Override
    public List<Movie> selectMovies() throws Exception {
        List<Movie> movies = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIES);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                movies.add(new Movie(
                        rs.getInt(ID_MOVIE),
                        rs.getString(TITLE),
                        rs.getInt(DIRECTOR_ID),
                        rs.getString(PLOT),
                        rs.getString(IMG_PATH)
                ));
            }
        }
        return movies;
    }

    @Override
    public Optional<Movie> selectMovie(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_MOVIE)) {

            stmt.setInt("@" + ID_MOVIE, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Movie(
                            rs.getInt(ID_MOVIE),
                            rs.getString(TITLE),
                            rs.getInt(DIRECTOR_ID),
                            rs.getString(PLOT),
                            rs.getString(IMG_PATH)
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Person> selectDirectorById(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_DIRECTOR_BY_ID)) {

            stmt.setInt("@" + ID_DIRECTOR, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Person(
                            rs.getInt(ID_DIRECTOR),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME)
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Person> selectActors(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ACTOR_BY_ID)) {

            stmt.setInt("@" + ID_ACTOR, id);
            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    return Optional.of(new Person(
                            rs.getInt(ID_ACTOR),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME)
                    ));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Person> selectActorsByMovieId(int id) throws Exception {
        List<Person> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ACTORS_BY_MOVIE_ID)) {
            stmt.setInt("@" + ID_MOVIE, id);
            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    actors.add(new Person(
                            rs.getInt(ID_ACTOR),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME)
                    ));
                }
            }
        }
        return actors;

    }

    @Override
    public List<Person> selectActors() throws Exception {
        List<Person> actors = new ArrayList<>();
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(SELECT_ACTORS)) {

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    actors.add(new Person(
                            rs.getInt(ID_ACTOR),
                            rs.getString(FIRST_NAME),
                            rs.getString(LAST_NAME)
                    ));
                }
            }
        }
        return actors;
    }

    @Override
    public void updateMovie(int id, Movie data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_MOVIE)) {
            stmt.setInt("@" + ID_MOVIE, id);

            stmt.setString("@" + TITLE, data.getTitle());
            stmt.setString("@" + PLOT, data.getPlot());
            stmt.setInt("@" + DIRECTOR_ID, data.getDirectorId());
            stmt.setString("@" + IMG_PATH, data.getImagePath());

            stmt.executeUpdate();
            deleteMovieActorById(id);
            data.getActors().forEach(a -> {
                try {
                    createMovieActor(a, id);
                } catch (SQLException ex) {
                    Logger.getLogger(SqlRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        }
    }

    @Override
    public void createMovie(Movie data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE)) {

            stmt.setString("@" + TITLE, data.getTitle());
            stmt.setString("@" + PLOT, data.getPlot());
            stmt.setInt("@" + DIRECTOR_ID, data.getDirectorId());
            stmt.setString("@" + IMG_PATH, data.getImagePath());
            stmt.registerOutParameter("@" + ID_MOVIE, Types.INTEGER);

            stmt.executeUpdate();
            int id = stmt.getInt("@" + ID_MOVIE);

            data.getActors().forEach(a -> {
                try {
                    createMovieActor(a, id);
                } catch (SQLException ex) {
                    Logger.getLogger(SqlRepository.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

        }
    }

    private void createMovieActor(Person data, int id) throws SQLException {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_MOVIE_ACTOR_WITH_IDS)) {

            stmt.setInt("@" + MOVIE_ID, id);
            stmt.setInt("@" + ACTOR_ID, data.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteMovie(Movie selectedMovie) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE)) {

            stmt.setInt("@" + MOVIE_ID, selectedMovie.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteMovieActorById(int id) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE_ACTORS_BY_ID)) {

            stmt.setInt("@" + MOVIE_ID, id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteMovieActor(int idMovie, int idActor) {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_MOVIE_ACTOR)) {

            stmt.setInt("@" + MOVIE_ID, idMovie);
            stmt.setInt("@" + ACTOR_ID, idActor);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void createActor(Person person) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(CREATE_ACTOR)) {

            stmt.setString("@" + FIRST_NAME, person.getFirstName());
            stmt.setString("@" + LAST_NAME, person.getLastName());

            stmt.executeUpdate();

        }
    }

    @Override
    public void updatePerson(int id, Person data) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(UPDATE_ACTOR)) {

            stmt.setInt("@" + ID_ACTOR, id);
            stmt.setString("@" + FIRST_NAME, data.getFirstName());
            stmt.setString("@" + LAST_NAME, data.getLastName());

            stmt.executeUpdate();

        }
    }

    @Override
    public void deleteActor(Person selectedPerson) throws Exception {
        DataSource dataSource = DataSourceSingleton.getInstance();
        try (Connection con = dataSource.getConnection();
                CallableStatement stmt = con.prepareCall(DELETE_ACTOR)) {

            stmt.setInt("@" + ID_ACTOR, selectedPerson.getId());
            stmt.executeUpdate();
        }
    }

}
