package com.github.mcbeelen.chinook;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import static com.github.mcbeelen.chinook.Track.TrackBuilder.aTrack;

public class PlainJdbcTrackRepository implements TrackRepository {
    @Override
    public Optional<Track> getById(Integer trackId) throws SQLException {

        ensureThatTheDriverIsLoadedIntoTheJvm();

        Track foundTrack = null;
        try (Connection connection = getConnection()) {
            try (Statement stmt = connection.createStatement()) {

                ResultSet rs = stmt.executeQuery("SELECT Name, Composer FROM Track WHERE TrackID = " + trackId);

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
        Connection conn = null;

        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/OJpwdfrCqW?" +
                            "user=OJpwdfrCqW&password=Hzbt4PVTZY");


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return conn;
    }
}
