package com.github.mcbeelen.chinook;

<<<<<<< HEAD
=======
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

>>>>>>> spring-data/employee
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
<<<<<<< HEAD
=======
import java.util.concurrent.TimeUnit;
>>>>>>> spring-data/employee

import static com.github.mcbeelen.chinook.Track.TrackBuilder.aTrack;

public class PlainJdbcTrackRepository implements TrackRepository {
    @Override
    public Optional<Track> getById(Integer trackId) throws SQLException {

        ensureThatTheDriverIsLoadedIntoTheJvm();

        Track foundTrack = null;
        try (Connection connection = getConnection()) {
            try (Statement stmt = connection.createStatement()) {

<<<<<<< HEAD
                ResultSet rs = stmt.executeQuery("SELECT Name, Composer FROM Track WHERE TrackID = " + trackId);
=======
                String sql = "SELECT Name, Composer FROM Track WHERE TrackID = " + trackId;

                ResultSet rs = stmt.executeQuery(sql);
>>>>>>> spring-data/employee

                if (rs.next()) {
                    String trackName = rs.getString("Name");
                    String composer = rs.getString("Composer");

                    foundTrack = aTrack()
                            .withName(trackName)
                            .withComposer(composer)
                            .build();
                }

                rs.close();
            }
        }

            return Optional.ofNullable(foundTrack);

    }

    private void ensureThatTheDriverIsLoadedIntoTheJvm() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        ;
    }

    private Connection getConnection() {
<<<<<<< HEAD
        Connection conn = null;

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/OJpwdfrCqW?" +
                            "user=OJpwdfrCqW&password=Hzbt4PVTZY");

=======

        Stopwatch stopwatch = Stopwatch.createStarted();
        Connection connection = null;
        try {
            connection = ConnectionUtil.INSTANCE.dataSource.getConnection();
>>>>>>> spring-data/employee

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

<<<<<<< HEAD
        return conn;
=======
        LoggerFactory.getLogger(this.getClass()).info("Get connection took: {}", stopwatch.elapsed(TimeUnit.MILLISECONDS));

        return connection;
>>>>>>> spring-data/employee
    }
}
